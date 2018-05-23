package regex.keyboard.domain.regexKeyboard.entity;

import java.util.Date;

/**
 * @Description: entity, user.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 12:17
 */
public class UserE {
    private Long id;
    private Long userId;
    private String userName;
    private String drowssap;
    private Date registerTime;

    public UserE() {
    }

    public UserE(Long id, Long userId, String userName, String drowssap, Date registerTime) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.drowssap = drowssap;
        this.registerTime = registerTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDrowssap() {
        return drowssap;
    }

    public void setDrowssap(String drowssap) {
        this.drowssap = drowssap;
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
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", drowssap='" + drowssap + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}
