package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.AnswerE;

public class AnswerDTO {
    private AnswerE answerE;
    private String message;
    private Boolean isSuccess;

    public AnswerDTO(AnswerE answerE, String message, Boolean isSuccess) {
        this.answerE = answerE;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public AnswerE getAnswerE() {
        return answerE;
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
