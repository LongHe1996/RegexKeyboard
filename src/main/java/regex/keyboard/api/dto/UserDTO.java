package regex.keyboard.api.dto;

import regex.keyboard.domain.regexkeyboard.entity.UserE;

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

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}
