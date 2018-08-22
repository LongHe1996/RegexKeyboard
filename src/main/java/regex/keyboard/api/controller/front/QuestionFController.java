package regex.keyboard.api.controller.front;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import regex.keyboard.api.controller.back.AnswerBController;
import regex.keyboard.api.controller.back.QuestionBController;
import regex.keyboard.api.dto.OneForAllAnswersDTO;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.domain.regexkeyboard.entity.AnswerE;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;

@Controller
public class QuestionFController {
    @Autowired
    private QuestionBController questionBController;
    @Autowired
    private AnswerBController answerBController;

    @GetMapping("getAllQuestions")
    @ResponseBody
    public String getAllQuestion(Map<String, Object> map) {
        List<OneForAllQuestionDTO> allQuestion = questionBController.getAllQuestion();
        map.put("allQuestion", allQuestion);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    @RequestMapping("/submitquestion")
    public String login(QuestionE questionE, String loginUserName, Map<String, Object> map) {
        if ("".equals(loginUserName)) {
            map.put("error", "尚未登录");
            return "/qanda";
        }
        questionBController.submitQuestion(questionE, loginUserName);
        return "/qanda";
    }

    @GetMapping("getsinglequestion")
    public String getSingleQuestionDefault(Long id, Map<String, Object> map) {
        OneForAllQuestionDTO oneQuestion = questionBController.getOneQuestion(id);
        map.put("questionerNickName", oneQuestion.getQuestioner().getNickName());
        map.put("questionerId", oneQuestion.getQuestioner().getId());
        map.put("questionTitle", oneQuestion.getQuestionTitle());
        map.put("questionContent", oneQuestion.getQuestionContent());
        map.put("questionPutTime", oneQuestion.getPutTime());
        map.put("answerNum", oneQuestion.getAnswerNum() + " comments");
        map.put("isSolved", oneQuestion.getSolved());
        return "/singlequestion";
    }

    @GetMapping("allAnswerToAQuestion")
    @ResponseBody
    public String getAllQuestion(Long id, Map<String, Object> map) {
        List<OneForAllAnswersDTO> allAnswerToAQuestion = answerBController.getAllAnswerToAQuestion(id);
        map.put("allAnswers", allAnswerToAQuestion);
        JSONObject jsonObject = JSONObject.fromObject(map);
       return jsonObject.toString();
    }

    @RequestMapping("/submitanswer")
    public String signup(AnswerE answerE, String loginUserName, Long questionId, Map<String, Object> map) {
        if ("".equals(loginUserName)) {
            map.put("error", "尚未登录");
            return "redirect:getsinglequestion?id=" + questionId;
        }
        answerBController.submitAnswer(answerE, loginUserName, questionId);
        return "redirect:getsinglequestion?id=" + questionId;
    }

    @GetMapping("getAllMyQuetions")
    @ResponseBody
    public String getAllMyQuestion(Long userId, Map<String, Object> map) {
        List<OneForAllQuestionDTO> allMyQuestion = questionBController.getAllMyQuestion(userId);
        if(allMyQuestion==null||allMyQuestion.isEmpty()){
            map.put("error","还没有提问过哦！");
        }else {
            map.put("error", "0");
            map.put("allmyQuestion",allMyQuestion);
        }
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
    @GetMapping("getAllMyAnswers")
    @ResponseBody
    public String getAllMyAnswer(Long userId,Map<String, Object> map) {
        List<OneForAllAnswersDTO> allMyAnswers = answerBController.getAllMyAnswer(userId);
        if(allMyAnswers==null||allMyAnswers.isEmpty()){
            map.put("error","还没有回答过问题哦！");
        }else {
            map.put("error", "0");
            map.put("allmyAnswer",allMyAnswers);
        }
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
    @RequestMapping("doaccept")
    public String doAccept(String qanda,Map<String, Object> map) {
        int answer = qanda.indexOf("answer");
        Long questionId=new Long(qanda.substring(0,answer));
        System.out.println(qanda+" "+questionId);
        Long answerId=new Long(qanda.substring(answer+6));
        System.out.println(questionId+"and"+answerId);
        Boolean aBoolean = questionBController.doAccept(questionId, answerId);
        return "redirect:getsinglequestion?id=" + questionId;
    }
}

