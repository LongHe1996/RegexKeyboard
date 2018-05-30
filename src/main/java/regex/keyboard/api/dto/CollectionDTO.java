package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.CollectionE;

public class CollectionDTO {
    private CollectionE collectionE;
    private String message;

    public CollectionDTO(CollectionE collectionE, String message) {
        this.collectionE = collectionE;
        this.message = message;
    }

    public CollectionE getCollectionE() {
        return collectionE;
    }

    public String getMessage() {
        return message;
    }
}
