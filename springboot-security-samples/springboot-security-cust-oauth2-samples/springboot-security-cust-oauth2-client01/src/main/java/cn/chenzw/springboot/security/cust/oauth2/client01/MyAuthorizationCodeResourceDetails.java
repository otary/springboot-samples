package cn.chenzw.springboot.security.cust.oauth2.client01;

import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

public class MyAuthorizationCodeResourceDetails extends AuthorizationCodeResourceDetails {


    private String successRedirectUri;

    public String getSuccessRedirectUri() {
        return successRedirectUri;
    }

    public void setSuccessRedirectUri(String successRedirectUri) {
        this.successRedirectUri = successRedirectUri;
    }
}
