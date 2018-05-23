package regex.keyboard.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexRulesDTO;
import regex.keyboard.domain.regexKeyboard.entity.RegexRulesE;

@Service
public interface RegexRulesService {
    List<RegexRulesDTO> selectAllRegexRules();
}
