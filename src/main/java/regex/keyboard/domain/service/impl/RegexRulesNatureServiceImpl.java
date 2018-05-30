package regex.keyboard.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexRulesNatureDTO;
import regex.keyboard.domain.regexKeyboard.convertor.RegexRulesNatureConvetor;
import regex.keyboard.domain.regexKeyboard.entity.RegexRulesNatureE;
import regex.keyboard.domain.repository.RegexRulesNatureRepository;
import regex.keyboard.domain.service.RegexRulesNatureService;
import regex.keyboard.infra.dataobject.RegexRulesNatureDO;
@Service
public class RegexRulesNatureServiceImpl implements RegexRulesNatureService {
    @Autowired
    private RegexRulesNatureRepository regexRulesNatureRepository;
    @Autowired
    private RegexRulesNatureConvetor regexRulesNatureConvetor;

    @Override
    public List<RegexRulesNatureDTO> selectAllNature() {
        List<RegexRulesNatureDTO> allRegexRulesNature = new ArrayList<>();
        for (RegexRulesNatureDO regexRulesNatureDO : regexRulesNatureRepository.findAll()) {
            RegexRulesNatureE regexRulesNatureE = regexRulesNatureConvetor.doToEntity(regexRulesNatureDO);
            allRegexRulesNature.add(new RegexRulesNatureDTO(regexRulesNatureE, "all.regex.rules.nature"));
        }
        return allRegexRulesNature;
    }
}
