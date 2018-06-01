package regex.keyboard.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.AnswerDTO;
import regex.keyboard.api.dto.OneForAllAnswersDTO;
import regex.keyboard.domain.regexKeyboard.entity.AnswerE;

@Service
public interface AnswerServiceV {
    List<OneForAllAnswersDTO> getAllTheAnswersToAQuestion(Long questionId);
    AnswerDTO submitAnswer(AnswerE answerE,String loginUserName,Long questionId);
}
