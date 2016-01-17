package pl.edu.agh.fiis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.fiis.rest.dto.TokenResponse;
import pl.edu.agh.fiis.rest.dto.UserDTO;
import pl.edu.agh.fiis.utils.StringConstants;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

/**
 * Created by wemstar on 2016-01-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjektZTIApplication.class)
@WebIntegrationTest
public class CreateUserTest {

    @Test
    public void createUser() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        UserDTO user = new UserDTO();
        user.setLogin("admin");
        user.setPassword("admin");
        user.setEmail("email");
        HttpEntity<UserDTO> requestEntity = new HttpEntity<UserDTO>(user);
        restTemplate.put("http://localhost:8888/rest/user",requestEntity);
        //restTemplate.put("http://localhost:8888/rest/user","");

    }

}
