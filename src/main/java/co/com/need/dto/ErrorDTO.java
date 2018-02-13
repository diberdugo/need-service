package co.com.need.dto;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codeStatus;

    private String descStatus;

    public ErrorDTO() {
        /* no-code */
    }

    public ErrorDTO(String codeStatus, String descStatus) {
        this.codeStatus = codeStatus;
        this.descStatus = descStatus;
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
