package regex.keyboard.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import regex.keyboard.domain.regexKeyboard.entity.RegexRulesE;
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class RegexRulesDTO {
    private RegexRulesE regexRulesE;
    private String message;

    public RegexRulesDTO(RegexRulesE regexRulesE, String message) {
        this.regexRulesE = regexRulesE;
        this.message = message;
    }
}
