package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.RegexRulesNatureE;

public class RegexRulesNatureDTO {
    private RegexRulesNatureE regexRulesNatureE;
    private String message;

    public RegexRulesNatureDTO(RegexRulesNatureE regexRulesNatureE, String message) {
        this.regexRulesNatureE = regexRulesNatureE;
        this.message = message;
    }

    public RegexRulesNatureE getRegexRulesNatureE() {
        return regexRulesNatureE;
    }

    public String getMessage() {
        return message;
    }
}
