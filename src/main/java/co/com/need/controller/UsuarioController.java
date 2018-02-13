package co.com.need.controller;

import co.com.need.dto.LoginResponseDTO;
import co.com.need.util.StatusEnum;
import javax.ws.rs.core.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @RequestMapping(value = "/users/{nombre}", method = RequestMethod.GET,
        produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<LoginResponseDTO> users(@PathVariable("nombre") String nombre) {
        LoginResponseDTO dto = new LoginResponseDTO();
        dto.setCodeStatus(StatusEnum.CODE_SUCCESS.get());
        dto.setDescStatus(StatusEnum.DESC_SUCCESS.get());
        dto.setToken("Prueba usuario");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
