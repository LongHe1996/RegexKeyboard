package regex.keyboard.api.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.app.service.AnswerServiceV;
import regex.keyboard.app.service.QuestionSericeV;
import regex.keyboard.domain.regexKeyboard.entity.QuestionE;

@RestController
public class QuestionBController {
    @Autowired
    private QuestionSericeV questionSericeV;
    public QuestionDTO submitQuestion(QuestionE questionE,String loginUserName){
        return questionSericeV.submitQuestion(questionE, loginUserName);
    }
    public List<OneForAllQuestionDTO> getAllQuestion(){
        return questionSericeV.getAllQuestions();
    }
    public OneForAllQuestionDTO getOneQuestion(Long questionId){
       return  questionSericeV.getAQuestion(questionId);
    }
}
