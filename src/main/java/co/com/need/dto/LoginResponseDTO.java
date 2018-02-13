package co.com.need.dto;

import java.io.Serializable;

public class LoginResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    private String codeStatus;

    private String descStatus;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getDescStatus() {
        return descStatus;
    }

    public void setDescStatus(String descStatus) {
        this.descStatus = descStatus;
    }

}
