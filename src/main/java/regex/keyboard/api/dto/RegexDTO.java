package regex.keyboard.api.dto;

import regex.keyboard.domain.regexkeyboard.entity.RegexE;

public class RegexDTO {
    private RegexE regexE;
    private String message;

    public RegexDTO(RegexE regexE, String message) {
        this.regexE = regexE;
        this.message = message;
    }

    public RegexE getRegexE() {
        return regexE;
    }

    public String getMessage() {
        return message;
    }
}
