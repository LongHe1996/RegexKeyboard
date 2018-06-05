package regex.keyboard.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexRulesDTO;
import regex.keyboard.api.dto.RegexRulesNatureDTO;
import regex.keyboard.app.service.RegexRulesServiceV;
import regex.keyboard.domain.service.RegexRulesNatureService;
import regex.keyboard.domain.service.RegexRulesService;

@Service
public class RegexRulesServiceVImpl implements RegexRulesServiceV {
    @Autowired
    private RegexRulesService regexRulesService;
    @Autowired
    private RegexRulesNatureService regexRulesNatureService;
    @Override
    public List<RegexRulesDTO> getAllRules() {
        return regexRulesService.selectAllRegexRules();
    }

    @Override
    public List<RegexRulesNatureDTO> getAllRulesNature() {
        return regexRulesNatureService.selectAllNature();
    }
}
