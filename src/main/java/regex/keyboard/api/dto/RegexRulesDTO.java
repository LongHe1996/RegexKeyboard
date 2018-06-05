package regex.keyboard.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import regex.keyboard.domain.regexkeyboard.entity.RegexRulesE;

@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class RegexRulesDTO {
    private RegexRulesE regexRulesE;
    private String message;

    public RegexRulesDTO(RegexRulesE regexRulesE, String message) {
        this.regexRulesE = regexRulesE;
        this.message = message;
    }

    public void setRegexRulesE(RegexRulesE regexRulesE) {
        this.regexRulesE = regexRulesE;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RegexRulesE getRegexRulesE() {
        return regexRulesE;
    }

    public String getMessage() {
        return message;
    }
}
