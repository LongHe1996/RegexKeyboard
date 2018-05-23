package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.RegexE;

public class RegexDTO {
    private RegexE regexE;
    private String message;

    public RegexDTO(RegexE regexE, String message) {
        this.regexE = regexE;
        this.message = message;
    }
}
