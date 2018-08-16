package com.yzx.crimepj.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                         //唯一标识符
    private String userName;                    //用户名
    private String password;                    //密码
    private String email;                       //实名/匿名举报：显示/不显示邮箱
    private String personType;                  //用户类型：user、LEA、admin
//    private Boolean isVip;                    //是否为会员-->用户都需要注册，但是当选择实名举报时，提示需要登录，登陆后才可以功能 edit personal detail/view case progress
//
//    public Boolean getVip() {
//        return isVip;
//    }
//
//    public void setVip(Boolean vip) {
//        isVip = vip;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }
}
