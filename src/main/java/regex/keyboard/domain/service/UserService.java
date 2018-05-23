package regex.keyboard.domain.service;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexKeyboard.entity.UserE;

@Service
public interface UserService {
    UserDTO create(UserE userE);
    String deleteById(Long id);
    UserDTO update(UserE userE);
    UserDTO selectByUserId(Long userId);
    UserDTO selectById(Long id);
}
