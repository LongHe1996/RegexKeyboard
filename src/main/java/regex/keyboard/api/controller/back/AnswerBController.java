package regex.keyboard.api.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.AnswerDTO;
import regex.keyboard.api.dto.OneForAllAnswersDTO;
import regex.keyboard.app.service.AnswerServiceV;
import regex.keyboard.domain.regexkeyboard.entity.AnswerE;

@RestController
public class AnswerBController {
    @Autowired
    private AnswerServiceV answerServiceV;

    public List<OneForAllAnswersDTO> getAllAnswerToAQuestion(Long questionId) {
        return answerServiceV.getAllTheAnswersToAQuestion(questionId);
    }

    public AnswerDTO submitAnswer(AnswerE answerE, String loginUserName, Long questionId) {
        return answerServiceV.submitAnswer(answerE, loginUserName, questionId);
    }
}
