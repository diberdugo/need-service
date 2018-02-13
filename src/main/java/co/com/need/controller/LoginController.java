package co.com.need.controller;

import co.com.need.business.TokenBusiness;
import co.com.need.dto.LoginDTO;
import co.com.need.dto.LoginResponseDTO;
import co.com.need.util.StatusEnum;
import javax.ws.rs.core.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/autenticar", method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<LoginResponseDTO> autenticar(@Validated @RequestBody LoginDTO login, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(new LoginResponseDTO(), HttpStatus.BAD_REQUEST);
        } else {
            LoginResponseDTO dto = new LoginResponseDTO();
            dto.setCodeStatus(StatusEnum.CODE_SUCCESS.get());
            dto.setDescStatus(StatusEnum.DESC_SUCCESS.get());
            dto.setToken(TokenBusiness.generarToken(login.getUsername()));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
    }
}
