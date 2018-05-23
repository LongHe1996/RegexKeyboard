package regex.keyboard.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexDTO;
import regex.keyboard.domain.regexKeyboard.convertor.RegexConvertor;
import regex.keyboard.domain.regexKeyboard.entity.RegexE;
import regex.keyboard.domain.repository.RegexRepository;
import regex.keyboard.domain.service.RegexService;
import regex.keyboard.infra.dataobject.RegexDO;

@Service
public class RegexServiceImpl implements RegexService {
    @Autowired
    private RegexRepository regexRepository;
    @Autowired
    private RegexConvertor regexConvertor;
    @Override
    public RegexDTO create(RegexE regexE) {
        RegexDO regexDO = regexConvertor.entityToDo(regexE);
        //1.regexContent重复
        if (regexRepository.findByRegexContent(regexDO.getRegexContent())!=null) {
            return new RegexDTO(null, "error.create.regex.content.exist.");
        }
        RegexDO saveRegexDO = regexRepository.save(regexDO);
        return new RegexDTO(regexConvertor.doToEntity(saveRegexDO), "success.create.regex:" + saveRegexDO);
    }
}
