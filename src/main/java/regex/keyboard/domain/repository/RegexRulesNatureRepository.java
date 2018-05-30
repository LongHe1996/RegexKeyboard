package regex.keyboard.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import regex.keyboard.infra.dataobject.RegexRulesNatureDO;

public interface RegexRulesNatureRepository extends JpaRepository<RegexRulesNatureDO,Long> {
}
