package regex.keyboard.domain.regexkeyboard.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import regex.keyboard.domain.regexkeyboard.entity.CollectionE;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;
import regex.keyboard.domain.regexkeyboard.entity.UserE;
import regex.keyboard.domain.repository.QuestionRepository;
import regex.keyboard.domain.repository.UserRepository;
import regex.keyboard.infra.dataobject.CollectionDO;
import regex.keyboard.infra.dataobject.QuestionDO;
import regex.keyboard.infra.dataobject.UserDO;

/**
 * @Description: collection convertor.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/29 23:25
 */
@Component
public class CollectionConvetor implements ConvertorI<CollectionDO, CollectionE> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionConvertor questionConvertor;
    @Autowired
    private UserConvertor userConvertor;

    @Override
    public CollectionE doToEntity(CollectionDO dataObject) {
        UserDO userDO = userRepository.findOne(dataObject.getCollector());
        UserE userE = userConvertor.doToEntity(userDO);
        QuestionDO questionDO = questionRepository.findOne(dataObject.getQuestionId());
        QuestionE questionE = questionConvertor.doToEntity(questionDO);
        return new CollectionE(dataObject.getId(), questionE, userE, dataObject.getCollectionTime());
    }

    @Override
    public CollectionDO entityToDo(CollectionE entity) {
        return new CollectionDO(entity.getId(), entity.getQuestion().getId(), entity.getCollector().getId(), entity.getCollectionTime());
    }
}
