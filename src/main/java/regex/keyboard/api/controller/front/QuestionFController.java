package regex.keyboard.api.controller.front;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import regex.keyboard.api.controller.back.AnswerBController;
import regex.keyboard.api.controller.back.QuestionBController;
import regex.keyboard.api.dto.*;
import regex.keyboard.domain.regexKeyboard.entity.AnswerE;
import regex.keyboard.domain.regexKeyboard.entity.QuestionE;
import regex.keyboard.domain.regexKeyboard.entity.UserE;

@Controller
public class QuestionFController {
    @Autowired
    private QuestionBController questionBController;
    @Autowired
    private AnswerBController answerBController;
    @GetMapping("getAllQuestions")
    @ResponseBody
    public String getAllQuestion(HashMap<String,Object> map){
        List<OneForAllQuestionDTO> allQuestion = questionBController.getAllQuestion();
        map.put("allQuestion",allQuestion);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String result = jsonObject.toString();
        return result;
    }
    @RequestMapping("/submitquestion")
    public String login(QuestionE questionE,String loginUserName, HashMap<String, Object> map){
        if("".equals(loginUserName)){
            map.put("error","尚未登录");
            return "/qanda";
        }
        QuestionDTO questionDTO = questionBController.submitQuestion(questionE, loginUserName);
        System.out.println(questionDTO.getMessage());
        return "/qanda";
    }

    @GetMapping("getsinglequestion")
    public String getSingleQuestionDefault(Long id,HashMap<String,Object> map){
        OneForAllQuestionDTO oneQuestion = questionBController.getOneQuestion(id);
        map.put("questionerNickName",oneQuestion.getQuestioner().getNickName());
        map.put("questionerId",oneQuestion.getQuestioner().getId());
        map.put("questionTitle",oneQuestion.getQuestionTitle());
        map.put("questionContent",oneQuestion.getQuestionContent());
        map.put("questionPutTime",oneQuestion.getPutTime());
        map.put("answerNum",oneQuestion.getAnswerNum()+" comments");
        map.put("isSolved",oneQuestion.getSolved());
        return "/singlequestion";
    }
    @GetMapping("allAnswerToAQuestion")
    @ResponseBody
    public String getAllQuestion(Long id,HashMap<String,Object> map){
        System.out.println(id);
        List<OneForAllAnswersDTO> allAnswerToAQuestion = answerBController.getAllAnswerToAQuestion(id);
        map.put("allAnswers",allAnswerToAQuestion);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String result = jsonObject.toString();
        System.out.println(result);
        return result;
    }
    @RequestMapping("/submitanswer")
    public String signup(AnswerE answerE,String loginUserName,Long questionId,HashMap<String, Object> map){
        System.out.println(answerE+"\nquestionId:"+questionId+"\nloginuser："+loginUserName);
        if("".equals(loginUserName)){
            map.put("error","尚未登录");
            return "redirect:getsinglequestion?id="+questionId;
        }
        answerBController.submitAnswer(answerE, loginUserName,questionId);
        return "redirect:getsinglequestion?id="+questionId;
    }
}

