package regex.keyboard.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.CollectionDTO;
import regex.keyboard.domain.regexkeyboard.convertor.CollectionConvetor;
import regex.keyboard.domain.regexkeyboard.entity.CollectionE;
import regex.keyboard.domain.repository.CollectionRepository;
import regex.keyboard.domain.service.CollectionService;
import regex.keyboard.infra.dataobject.CollectionDO;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private CollectionConvetor collectionConvetor;

    @Override
    public List<CollectionDTO> selectByCollector(Long collector) {
        List<CollectionDTO> collectionDTOList = new ArrayList<>();
        List<CollectionDO> byCollector = collectionRepository.findByCollector(collector);
        if(byCollector==null){
            collectionDTOList.add(new CollectionDTO(null,"error,select.collection.by,collector",false));
            return collectionDTOList;
        }
        for (CollectionDO collectionDO : byCollector
                ) {
            CollectionE collectionE = collectionConvetor.doToEntity(collectionDO);
            collectionDTOList.add(new CollectionDTO(collectionE, "success,select.collection.by,collector",true));
        }
        return collectionDTOList;
    }

    @Override
    public String deleteById(Long id) {
        CollectionDO collectionDO = collectionRepository.findOne(id);
        if (collectionDO == null) {
            return "error.delete.collection.not.exist.id" + id;
        }
        collectionRepository.delete(id);
        return "success.delete.collection.id:" + id;
    }

    @Override
    public CollectionDTO create(CollectionE collectionE) {
        CollectionDO collectionDO = collectionConvetor.entityToDo(collectionE);
        CollectionDO saveCollectionDO = collectionRepository.save(collectionDO);
        return new CollectionDTO(collectionConvetor.doToEntity(saveCollectionDO), "success.create.collection:" + saveCollectionDO,true);
    }

    @Override
    public CollectionDTO selectByCollectorAndQuestion(Long userId, Long questionId) {
        CollectionDO byCollectorAndQuestionId = collectionRepository.findByCollectorAndQuestionId(userId, questionId);
        if(byCollectorAndQuestionId!=null) {
            return new CollectionDTO(collectionConvetor.doToEntity(byCollectorAndQuestionId), "success.select.collection.by.u.q:" + byCollectorAndQuestionId, true);
        }else {
            return new CollectionDTO(null,"error.select.collection,by u,q:",false);
        }
    }
}
