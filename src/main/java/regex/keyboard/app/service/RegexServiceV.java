package regex.keyboard.app.service;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexResultDTO;

@Service
public interface RegexServiceV {
    public RegexResultDTO buildRegex(String regexDescribe);
}
