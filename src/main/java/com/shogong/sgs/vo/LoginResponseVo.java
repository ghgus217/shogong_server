package com.shogong.sgs.vo;

public class LoginResponseVo{

    String USER_TOKEN;
    boolean LOGIN_STATUS;

	public String getUSER_TOKEN() {
		return USER_TOKEN;
	}
	public void setUSER_TOKEN(String uSER_TOKEN) {
		USER_TOKEN = uSER_TOKEN;
    }
    
    public boolean isLOGIN_STATUS() {
        return LOGIN_STATUS;
    }

    public void setLOGIN_STATUS(boolean lOGIN_STATUS) {
        LOGIN_STATUS = lOGIN_STATUS;
    }
}