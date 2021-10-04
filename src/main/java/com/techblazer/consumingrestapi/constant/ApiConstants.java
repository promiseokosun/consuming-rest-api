package com.techblazer.consumingrestapi.constant;

public enum ApiConstants {
//    public static final String GITHUB_USER_API = "https://api.github.com/users";


    GITHUB_USER_API("https://api.github.com/users");

    private String url;

    ApiConstants(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
