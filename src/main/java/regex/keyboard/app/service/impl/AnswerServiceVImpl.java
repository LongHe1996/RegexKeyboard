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
        if(answerDTOS.get(0).getSuccess()){
        for (AnswerDTO answerDTO : answerDTOS
                ) {
            oneForAllAnswersDTOS.add(answerConvertor.dtoToForView(answerDTO));
        }}
        return oneForAllAnswersDTOS;
    }

    @Override
    public AnswerDTO submitAnswer(AnswerE answerE, String loginUserName, Long questionId) {
        UserDTO userDTO = userService.selectByUserName(loginUserName);
        answerE.setRespondent(userDTO.getUserE());
        answerE.setQuestionId(questionId);
        answerE.setAccepted(false);
        answerE.setPutTime(new Date());
        AnswerDTO answerDTO = answerService.create(answerE);
        if (answerDTO.getSuccess()) {
            answerDTO.setMessage("提交成功");
        }
        return answerDTO;
    }

    @Override
    public List<OneForAllAnswersDTO> getAllMyAnswer(Long userId) {
        List<OneForAllAnswersDTO> allMyAnswers = new ArrayList<>();
        List<AnswerDTO> answerDTOS = answerService.selectByRespondent(userId);
        if(!answerDTOS.get(0).getSuccess()){
            return  allMyAnswers;
        }
        for (AnswerDTO answerDTO : answerDTOS
                ) {
            OneForAllAnswersDTO oneForAllAnswersDTO = answerConvertor.dtoToForView(answerDTO);

            QuestionDTO questionDTO = questionService.selectById(answerDTO.getAnswerE().getQuestionId());
            oneForAllAnswersDTO.setNickName(questionDTO.getQuestionE().getQuestionTitle());
            allMyAnswers.add(oneForAllAnswersDTO);
        }
        return allMyAnswers;
    }
}
