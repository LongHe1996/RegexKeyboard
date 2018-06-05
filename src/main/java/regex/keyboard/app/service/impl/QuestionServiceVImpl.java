package regex.keyboard.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.app.service.QuestionSericeV;
import regex.keyboard.domain.regexkeyboard.convertor.QuestionConvertor;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;
import regex.keyboard.domain.service.QuestionService;
import regex.keyboard.domain.service.UserService;

@Service
public class QuestionServiceVImpl implements QuestionSericeV {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionConvertor questionConvertor;
    @Autowired
    private UserService userService;

    @Override
    public QuestionDTO submitQuestion(QuestionE questionE, String loginUserName) {
        UserDTO userDTO = userService.selectByUserName(loginUserName);
        questionE.setQuestioner(userDTO.getUserE());
        questionE.setPutTime(new Date());
        questionE.setSolved(false);
        QuestionDTO questionDTO = questionService.create(questionE);
        if (questionDTO.getSuccess()) {
            questionDTO.setMessage("提交成功");
        }
        return questionDTO;
    }

    @Override
    public List<OneForAllQuestionDTO> getAllQuestions() {
        List<OneForAllQuestionDTO> oneForAllQuestionDTOS = new ArrayList<>();
        List<QuestionDTO> questionDTOS = questionService.selectAllSort();
        for (QuestionDTO questionDTO : questionDTOS
                ) {
            OneForAllQuestionDTO oneForAllQuestionDTO = questionConvertor.DtoToForView(questionDTO);
            oneForAllQuestionDTOS.add(oneForAllQuestionDTO);
        }
        return oneForAllQuestionDTOS;
    }

    @Override
    public OneForAllQuestionDTO getAQuestion(Long id) {
        QuestionDTO questionDTO = questionService.selectById(id);
        if (!questionDTO.getSuccess()) {
            questionDTO.setMessage("问题不存在！");
        } else {
            questionDTO.setMessage("检索成功！");
        }
        return questionConvertor.DtoToForView(questionDTO);
    }
}
