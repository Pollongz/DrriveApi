package com.drrive.DrriveApi.security;

public class JwtProperties {

    public static final String SECRET = "DrriveGo1337";
    public static final int EXPIRATION_TIME = 5000; // 864000000 - 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
