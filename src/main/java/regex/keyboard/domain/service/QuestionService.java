package regex.keyboard.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;


@Service
public interface QuestionService {
    QuestionDTO create(QuestionE questionE);

    QuestionDTO deleteById(Long id);

    QuestionDTO updateIfSolved(QuestionE questionE, Long acceptAnswer);

    QuestionDTO selectById(Long id);

    List<QuestionDTO> selectByQuestioner(Long quesrioner);

    List<QuestionDTO> selectAllSort();
}
