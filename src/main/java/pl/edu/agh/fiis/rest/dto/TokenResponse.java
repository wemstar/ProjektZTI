package pl.edu.agh.fiis.rest.dto;

/**
 * Created by wemstar on 2015-12-22.
 * Klasa transportująca token
 */
public class TokenResponse {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public TokenResponse() {
    }

    public TokenResponse(String token) {
        this.token = token;
    }
}
