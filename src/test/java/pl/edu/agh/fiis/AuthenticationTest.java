package pl.edu.agh.fiis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.fiis.rest.dto.TokenResponse;
import pl.edu.agh.fiis.utils.StringConstants;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

/**
 * Created by wemstar on 2016-01-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjektZTIApplication.class)
@WebIntegrationTest
public class AuthenticationTest {


    @Test
    public void contextLoads() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add(StringConstants.USER_HEADER, "user");
        headers.add(StringConstants.PASSWORD_HEADER, "user");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity request = new HttpEntity(null, headers);
        TokenResponse tokenResponse = restTemplate.postForObject("http://localhost:8888/rest/authenticate",request, TokenResponse.class);
        assertThat(tokenResponse.getToken(),not(isEmptyString()));
    }
}
