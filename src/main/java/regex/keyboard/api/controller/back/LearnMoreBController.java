package regex.keyboard.api.controller.back;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.RegexRulesDTO;
import regex.keyboard.api.dto.RegexRulesNatureDTO;
import regex.keyboard.app.service.RegexRulesServiceV;
import regex.keyboard.domain.regexkeyboard.entity.RegexRulesE;
import regex.keyboard.domain.regexkeyboard.entity.RegexRulesNatureE;

@RestController
public class LearnMoreBController {
    @Autowired
    private RegexRulesServiceV regexRulesServiceV;

    public List<RegexRulesE> getAllRegexRules() {
        List<RegexRulesE> allRegexRules = new ArrayList<>();
        List<RegexRulesDTO> allRules = regexRulesServiceV.getAllRules();
        for (RegexRulesDTO regexRulesDTO : allRules
                ) {
            allRegexRules.add(regexRulesDTO.getRegexRulesE());
        }
        return allRegexRules;
    }

    public List<RegexRulesNatureE> getAllRegexRulesNature() {
        List<RegexRulesNatureE> allRegexRulesNatures = new ArrayList<>();
        List<RegexRulesNatureDTO> allRulesNature = regexRulesServiceV.getAllRulesNature();
        for (RegexRulesNatureDTO regexRulesNatureDTO : allRulesNature
                ) {
            allRegexRulesNatures.add(regexRulesNatureDTO.getRegexRulesNatureE());
        }
        return allRegexRulesNatures;
    }
}
