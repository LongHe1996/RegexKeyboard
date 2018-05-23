package regex.keyboard.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.domain.regexKeyboard.entity.QuestionE;


@Service
public interface QuestionService {
    QuestionDTO create(QuestionE questionE);

    String deleteById(Long id);

    QuestionDTO updateIfSolved(QuestionE questionE, Long acceptAnswer);

    QuestionDTO selectById(Long id);

    List<QuestionDTO> selectByUserId(Long userId);
}
