package regex.keyboard.api.dto;

public class RegexResultDTO {
    private String regexStr;
    private String message;
    private Boolean isSuccess;

    public RegexResultDTO(String regexStr, String message, Boolean isSuccess) {
        this.regexStr = regexStr;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public String getRegexStr() {
        return regexStr;
    }

    public void setRegexStr(String regexStr) {
        this.regexStr = regexStr;
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
