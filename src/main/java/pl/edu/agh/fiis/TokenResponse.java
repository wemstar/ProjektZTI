package pl.edu.agh.fiis;

/**
 * Created by wemstar on 2015-12-22.
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
