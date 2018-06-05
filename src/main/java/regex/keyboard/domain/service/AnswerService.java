package regex.keyboard.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.AnswerDTO;
import regex.keyboard.domain.regexkeyboard.entity.AnswerE;

@Service
public interface AnswerService {
    AnswerDTO create(AnswerE answerE);

    String deleteById(Long id);

    AnswerDTO updateIfAccepted(AnswerE answerE);

    List<AnswerDTO> selectByRespondent(Long respondent);

    List<AnswerDTO> selectByQuestionId(Long questionId);
}
