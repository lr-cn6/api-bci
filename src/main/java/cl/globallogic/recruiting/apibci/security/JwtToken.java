package cl.globallogic.recruiting.apibci.security;

import cl.globallogic.recruiting.apibci.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtToken {

    @Autowired
    private JwtProperties jwtProperties;

    public String build(User u){
        return Jwts.builder()
                .setSubject(u.getEmail())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExp()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

}
