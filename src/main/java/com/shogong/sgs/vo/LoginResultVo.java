package com.shogong.sgs.vo;

public class LoginResultVo {

    String USER_TOKEN;
    String login_Message;

    public String getUSER_TOKEN() {
        return USER_TOKEN;
    }

    public void setUSER_TOKEN(String uSER_TOKEN) {
        USER_TOKEN = uSER_TOKEN;
    }

    public String getLogin_Message() {
        return login_Message;
    }

    public void setLogin_Message(String login_Message) {
        this.login_Message = login_Message;
    }
}