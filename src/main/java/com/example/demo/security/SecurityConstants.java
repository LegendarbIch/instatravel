package com.example.demo.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SecurityConstants {

    public static final String  SING_UP_URLS = "/api/auth/**";
    public static final Key SECRET = Keys.hmacShaKeyFor(Decoders.BASE64.decode("OvenSuperPuperDuperMegaSecretKeyGenJWTForKirillChichin"));
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000_000;

}
