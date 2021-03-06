package regex.keyboard.api.dto;

import regex.keyboard.domain.regexkeyboard.entity.QuestionE;

public class QuestionDTO {
    private QuestionE questionE;
    private String message;
    private Boolean isSuccess;

    public QuestionDTO(QuestionE questionE, String message, Boolean isSuccess) {
        this.questionE = questionE;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public QuestionE getQuestionE() {
        return questionE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}
