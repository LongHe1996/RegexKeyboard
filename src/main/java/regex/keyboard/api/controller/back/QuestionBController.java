package regex.keyboard.api.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.app.service.QuestionSericeV;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;

@RestController
public class QuestionBController {
    @Autowired
    private QuestionSericeV questionSericeV;

    public QuestionDTO submitQuestion(QuestionE questionE, String loginUserName) {
        return questionSericeV.submitQuestion(questionE, loginUserName);
    }

    public List<OneForAllQuestionDTO> getAllQuestion() {
        return questionSericeV.getAllQuestions();
    }

    public OneForAllQuestionDTO getOneQuestion(Long questionId) {
        return questionSericeV.getAQuestion(questionId);
    }

    public List<OneForAllQuestionDTO> getAllMyQuestion(Long userId) {
        return questionSericeV.getAllMyQuestions(userId);
    }
    public Boolean doAccept(Long questionId,Long answerId){
        QuestionDTO questionDTO = questionSericeV.doAccept(questionId, answerId);
        return questionDTO.getSuccess();
    }
}
