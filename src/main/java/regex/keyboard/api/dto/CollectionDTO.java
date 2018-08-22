package regex.keyboard.api.dto;

import regex.keyboard.domain.regexkeyboard.entity.CollectionE;

public class CollectionDTO {
    private CollectionE collectionE;
    private String message;
    private Boolean isSuccess;

    public CollectionDTO(CollectionE collectionE, String message, Boolean isSuccess) {
        this.collectionE = collectionE;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public void setCollectionE(CollectionE collectionE) {
        this.collectionE = collectionE;
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

    public CollectionE getCollectionE() {
        return collectionE;
    }

    public String getMessage() {
        return message;
    }
}
