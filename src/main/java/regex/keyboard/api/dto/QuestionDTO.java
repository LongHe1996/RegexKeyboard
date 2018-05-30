package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.QuestionE;

public class QuestionDTO {
    private QuestionE questionE;
    private String message;

    public QuestionDTO(QuestionE questionE, String message) {
        this.questionE = questionE;
        this.message = message;
    }

    public QuestionE getQuestionE() {
        return questionE;
    }

    public String getMessage() {
        return message;
    }
}
