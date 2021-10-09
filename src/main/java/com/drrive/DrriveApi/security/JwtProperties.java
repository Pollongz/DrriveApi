package com.drrive.DrriveApi.security;

public class JwtProperties {

    public static final int EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SECRET = RandomKey.generateRandomKey(10);

}
