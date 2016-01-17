package pl.edu.agh.fiis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.agh.fiis.bussines.dao.ProductDAO;
import pl.edu.agh.fiis.bussines.dao.UserDAO;
import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.ProductCountEntity;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.bussines.entity.UserEntity;
import pl.edu.agh.fiis.bussines.entity.builder.BasketEntityBuilder;
import pl.edu.agh.fiis.bussines.entity.builder.ProductCountEntityBuilder;
import pl.edu.agh.fiis.bussines.entity.builder.ProductEntityBuilder;
import pl.edu.agh.fiis.bussines.entity.builder.UserEntityBuilder;
import pl.edu.agh.fiis.bussines.services.OrderService;
import pl.edu.agh.fiis.bussines.services.ProductService;
import pl.edu.agh.fiis.bussines.services.UserService;
import pl.edu.agh.fiis.rest.dto.OrderDTO;
import pl.edu.agh.fiis.rest.dto.TokenResponse;
import pl.edu.agh.fiis.utils.StringConstants;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by wemstar on 2016-01-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjektZTIApplication.class)
@WebIntegrationTest
public class OrderTest {


    @Autowired
    private ProductService productService;

    @Test
    public void productCRUDTest() {
        ProductEntity productEntity1 = productService.createProduct(new ProductEntityBuilder()
                .name("Węgiel")
                .description("Coś czarnego")
                .value(20.0)
                .build());

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add(StringConstants.USER_HEADER, "user");
        headers.add(StringConstants.PASSWORD_HEADER, "user");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity request = new HttpEntity(null, headers);
        TokenResponse tokenResponse = restTemplate.postForObject("http://localhost:8888/rest/authenticate",request, TokenResponse.class);
        assertThat(tokenResponse.getToken(),not(isEmptyString()));

        headers = new LinkedMultiValueMap<String, String>();
        headers.add(StringConstants.TOKEN_HEADER, tokenResponse.getToken());
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        request = new HttpEntity(null, headers);
        String url = "http://localhost:8888/rest/basket/"+productEntity1.getId()+"/5";
        restTemplate.postForObject(url,request, Void.class);
        url = "http://localhost:8888/rest/order";
        restTemplate.put(url,request);

        HttpEntity<OrderDTO[]> order = restTemplate.exchange(url,HttpMethod.GET,request,OrderDTO[].class);

        request = new HttpEntity(null, headers);
        url = "http://localhost:8888/rest/basket/"+productEntity1.getId()+"/5";
        restTemplate.postForObject(url,request, Void.class);
        url = "http://localhost:8888/rest/order";
        restTemplate.put(url,request);

        order = restTemplate.exchange(url,HttpMethod.GET,request,OrderDTO[].class);

    }


}
