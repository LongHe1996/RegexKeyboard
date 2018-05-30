package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.UserE;

public class UserDTO {
    private UserE userE;
    private String message;
    private Boolean isSuccess;

    public UserDTO(UserE userE, String message, Boolean isSuccess) {
        this.userE = userE;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public UserE getUserE() {
        return userE;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}
