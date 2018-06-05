package regex.keyboard.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import regex.keyboard.infra.dataobject.RegexDO;

@Repository
public interface RegexRepository extends JpaRepository<RegexDO, Long> {
    RegexDO findByRegexContent(String regexContent);

}
