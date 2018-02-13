package co.com.need.configuration;

import co.com.need.exception.ExpiredTokenException;
import co.com.need.exception.InvalidTokenException;
import co.com.need.util.Constantes;
import co.com.need.util.StatusEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityHandlerInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
        throws Exception {
        /* no-code */
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
        throws Exception {
        /* no-code */
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg) throws Exception {
        String token = request.getHeader("Authorization");

        if (token != null) {
            try {
                String[] authParts = token.split("\\s+");
                String authInfo = authParts[1];

                Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(Constantes.CLAVE_JWT))
                    .parseClaimsJws(authInfo).getBody();
                claims.getId();
                claims.getSubject();
                claims.getIssuer();
                claims.getExpiration();
            } catch (ExpiredJwtException e) {
                throw new ExpiredTokenException(StatusEnum.DESC_EXPIRED_TOKEN.get());
            } catch (Exception e) {
                throw new InvalidTokenException(StatusEnum.DESC_INVALID_TOKEN.get());
            }

            return true;
        } else {
            throw new InvalidTokenException(StatusEnum.DESC_INVALID_TOKEN.get());
        }
    }

}
