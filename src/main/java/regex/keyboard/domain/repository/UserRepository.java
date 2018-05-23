package regex.keyboard.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import regex.keyboard.infra.dataobject.UserDO;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
    UserDO findByUserId(Long userId);
    UserDO findByUserName(String userName);
}
