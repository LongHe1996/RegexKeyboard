package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.AnswerE;

public class AnswerDTO {
    private AnswerE answerE;
    private String message;

    public AnswerDTO(AnswerE answerE, String message) {
        this.answerE = answerE;
        this.message = message;
    }
}
