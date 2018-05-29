package regex.keyboard.infra.dataobject;

import java.util.Date;
import javax.persistence.*;

/**
 * @Description: dataobject ,record the registered user information
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:40
 */
@Entity
@Table(name = "user")
public class UserDO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    private String nickName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String drowssap;
    private String bio;
    private Date registerTime;

    public UserDO() {
    }

    public UserDO(Long id,String userName, String nickName, String email, String drowssap, String bio, Date registerTime) {
        this.id=id;
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
}
