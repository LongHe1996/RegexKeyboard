package regex.keyboard.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.AnswerDTO;
import regex.keyboard.api.dto.OneForAllAnswersDTO;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.app.service.AnswerServiceV;
import regex.keyboard.domain.regexkeyboard.convertor.AnswerConvertor;
import regex.keyboard.domain.regexkeyboard.entity.AnswerE;
import regex.keyboard.domain.service.AnswerService;
import regex.keyboard.domain.service.QuestionService;
import regex.keyboard.domain.service.UserService;

@Service
public class AnswerServiceVImpl implements AnswerServiceV {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private AnswerConvertor answerConvertor;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;

    @Override
    public List<OneForAllAnswersDTO> getAllTheAnswersToAQuestion(Long questionId) {
        List<OneForAllAnswersDTO> oneForAllAnswersDTOS = new ArrayList<>();
        List<AnswerDTO> answerDTOS = answerService.selectByQuestionId(questionId);
        for (AnswerDTO answerDTO : answerDTOS
                ) {
            oneForAllAnswersDTOS.add(answerConvertor.dtoToForView(answerDTO));
        }
        return oneForAllAnswersDTOS;
    }

    @Override
    public AnswerDTO submitAnswer(AnswerE answerE, String loginUserName, Long questionId) {
        UserDTO userDTO = userService.selectByUserName(loginUserName);
        QuestionDTO questionDTO = questionService.selectById(questionId);
        answerE.setRespondent(userDTO.getUserE());
        answerE.setQuestion(questionDTO.getQuestionE());
        answerE.setAccepted(false);
        answerE.setPutTime(new Date());
        AnswerDTO answerDTO = answerService.create(answerE);
        if (answerDTO.getSuccess()) {
            answerDTO.setMessage("提交成功");
        }
        return answerDTO;
    }
}
