package co.com.need.business;

import co.com.need.util.Constantes;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;

public class TokenBusiness {

    public static String generarToken(String usuario) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 1);

        String jwt = Jwts.builder()
            .setSubject("users/TzMUocMF4p")
            .setExpiration(calendar.getTime())
            .claim("name", usuario)
            .signWith(
                SignatureAlgorithm.HS256,
                Constantes.CLAVE_JWT)
            .compact();
        return jwt;
    }
}
