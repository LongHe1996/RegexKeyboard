package regex.keyboard.domain.service;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexDTO;
import regex.keyboard.domain.regexKeyboard.entity.RegexE;

@Service
public interface RegexService {
    RegexDTO create(RegexE regexE);
}
