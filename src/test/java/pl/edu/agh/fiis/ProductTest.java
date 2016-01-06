package pl.edu.agh.fiis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.fiis.rest.dto.ProductDTO;
import pl.edu.agh.fiis.rest.dto.TokenResponse;
import pl.edu.agh.fiis.utils.StringConstants;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

/**
 * Created by wemstar on 2016-01-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjektZTIApplication.class)
@WebIntegrationTest
public class ProductTest {

    RestTemplate restTemplate = new TestRestTemplate();

    @Test
    @WithMockUser(username="user",authorities={"ROLE_DOMAIN_USER"})
    public void productTest() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

       // List<ProductDTO> products = restTemplate.getForObject("http://localhost:8888/rest/product/all", List.class);

    }
}
