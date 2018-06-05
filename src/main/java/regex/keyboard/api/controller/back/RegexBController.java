package regex.keyboard.api.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.RegexResultDTO;
import regex.keyboard.app.service.RegexServiceV;

@RestController
public class RegexBController {
    @Autowired
    private RegexServiceV regexServiceV;

    public RegexResultDTO getRegexByStr(String regexDescribe) {
        return regexServiceV.buildRegex(regexDescribe);
    }
}
