package regex.keyboard.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;

@Service
public interface QuestionSericeV {
    QuestionDTO submitQuestion(QuestionE questionE, String loginUserName);

    List<OneForAllQuestionDTO> getAllQuestions();

    OneForAllQuestionDTO getAQuestion(Long id);

    List<OneForAllQuestionDTO> getAllMyQuestions(Long userId);

    public QuestionDTO doAccept(Long questionId,Long answerId);
}
