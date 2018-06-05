package regex.keyboard.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexRulesDTO;
import regex.keyboard.domain.regexkeyboard.convertor.RegexRulesConvertor;
import regex.keyboard.domain.regexkeyboard.entity.RegexRulesE;
import regex.keyboard.domain.repository.RegexRulesRepository;
import regex.keyboard.domain.service.RegexRulesService;
import regex.keyboard.infra.dataobject.RegexRulesDO;

@Service
public class RegexRulesServiceImpl implements RegexRulesService {
    @Autowired
    private RegexRulesRepository regexRulesRepository;
    @Autowired
    private RegexRulesConvertor regexRulesConvertor;

    @Override
    public List<RegexRulesDTO> selectAllRegexRules() {
        List<RegexRulesDTO> allRegexRules = new ArrayList<>();
        for (RegexRulesDO regexRulesDO : regexRulesRepository.findAll()
                ) {
            RegexRulesE regexRulesE = regexRulesConvertor.doToEntity(regexRulesDO);
            allRegexRules.add(new RegexRulesDTO(regexRulesE, "all.regexRules"));
        }
        return allRegexRules;
    }
}
