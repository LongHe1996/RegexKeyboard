package regex.keyboard.api.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.RegexRulesDTO;
import regex.keyboard.domain.service.impl.RegexRulesServiceImpl;

@RestController
public class RegexRulesBController {
    @Autowired
    private RegexRulesServiceImpl regexRulesService;

    @RequestMapping("/getAllRegexRules")
    public Integer getAllUsers() {
        return regexRulesService.selectAllRegexRules().size();
    }
}
