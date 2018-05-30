package regex.keyboard.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.CollectionDTO;
import regex.keyboard.domain.regexKeyboard.entity.CollectionE;
@Service
public interface CollectionService {
    List<CollectionDTO> selectByCollector(Long collector);
    String deleteById(Long id);
    CollectionDTO create(CollectionE collectionE);
}
