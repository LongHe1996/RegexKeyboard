package regex.keyboard.domain.regexkeyboard.entity;

import java.util.Date;

/**
 * @Description: entity, user.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 12:17
 */
public class UserE {
    private Long id;
    private String userName;
    private String nickName;
    private String email;
    private String drowssap;
    private String bio;
    private Date registerTime;

    public UserE() {
    }

    public UserE(Long id, String userName, String nickName, String email, String drowssap, String bio, Date registerTime) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.drowssap = drowssap;
        this.bio = bio;
        this.registerTime = registerTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDrowssap() {
        return drowssap;
    }

    public void setDrowssap(String drowssap) {
        this.drowssap = drowssap;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "UserE{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", drowssap='" + drowssap + '\'' +
                ", bio='" + bio + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}
