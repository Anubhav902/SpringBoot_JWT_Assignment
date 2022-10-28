package com.springboot.jwt.json.mongodb.springboot_jwt_json.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {
    public static final String Token_Secrete = "always_put_random_string_like_anu123";

    public String createToken(ObjectId userId){
        try {
            Algorithm algorithm = Algorithm.HMAC256(Token_Secrete);

            String token = JWT.
                    create().
                    withClaim("userId",userId.toString()).
                    withClaim("createdAt",new Date()).
                    sign(algorithm);
            return token;
        }
        catch(UnsupportedEncodingException exception){
            exception.printStackTrace();
        }
        catch (JWTCreationException exception){
            exception.printStackTrace();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public String getUserIdFromToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(Token_Secrete);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            System.out.println(decodedJWT.getClaim("userId").asString());
            return decodedJWT.getClaim("userId").asString();
        }
        catch(UnsupportedEncodingException exception){
            exception.printStackTrace();
        }
        catch(JWTDecodeException exception){
            System.out.println("Wrong Token/Token is Expired.");
        }
        return null;
    }

    public boolean isTokenValid(String token){
        String userId = this.getUserIdFromToken(token);
        return userId != null;
    }
}