package regex.keyboard.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexRulesDTO;

@Service
public interface RegexRulesService {
    List<RegexRulesDTO> selectAllRegexRules();
}
