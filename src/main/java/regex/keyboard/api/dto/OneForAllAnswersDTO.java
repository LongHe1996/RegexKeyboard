package regex.keyboard.api.dto;

public class OneForAllAnswersDTO {
    private Long id;
    private String answerContent;
    private String nickName;
    private Long questionId;
    private String putTime;
    private Boolean isAccepted;

    public OneForAllAnswersDTO(Long id, String answerContent, String nickName, Long questionId, String putTime, Boolean isAccepted) {
        this.id = id;
        this.answerContent = answerContent;
        this.nickName = nickName;
        this.questionId = questionId;
        this.putTime = putTime;
        this.isAccepted = isAccepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getPutTime() {
        return putTime;
    }

    public void setPutTime(String putTime) {
        this.putTime = putTime;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }
}
