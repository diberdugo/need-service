package co.com.need.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Size(min=1)
    private String username;

    @NotNull
    @Size(min=1)
    private String password;
    
    public LoginDTO() {
        
    }
    
    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
