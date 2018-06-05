package regex.keyboard.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexRulesDTO;
import regex.keyboard.api.dto.RegexRulesNatureDTO;

@Service
public interface RegexRulesServiceV {
    List<RegexRulesDTO> getAllRules();
    List<RegexRulesNatureDTO> getAllRulesNature();
}
