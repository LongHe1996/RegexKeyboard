package regex.keyboard.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexRulesNatureDTO;

@Service
public interface RegexRulesNatureService {
    List<RegexRulesNatureDTO> selectAllNature();
}
