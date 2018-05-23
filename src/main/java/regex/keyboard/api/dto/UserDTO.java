package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.UserE;

public class UserDTO {
    private UserE userE;
    private String message;

    public UserDTO(UserE userE, String message) {
        this.userE = userE;
        this.message = message;
    }

}
