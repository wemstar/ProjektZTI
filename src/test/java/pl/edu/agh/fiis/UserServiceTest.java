package pl.edu.agh.fiis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.ProductCountEntity;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.bussines.entity.UserEntity;
import pl.edu.agh.fiis.bussines.entity.builder.BasketEntityBuilder;
import pl.edu.agh.fiis.bussines.entity.builder.ProductCountEntityBuilder;
import pl.edu.agh.fiis.bussines.entity.builder.ProductEntityBuilder;
import pl.edu.agh.fiis.bussines.entity.builder.UserEntityBuilder;
import pl.edu.agh.fiis.bussines.services.BasketService;
import pl.edu.agh.fiis.bussines.services.ProductService;
import pl.edu.agh.fiis.bussines.services.UserService;
import pl.edu.agh.fiis.rest.dto.TokenResponse;
import pl.edu.agh.fiis.rest.dto.UserDTO;
import pl.edu.agh.fiis.utils.StringConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

/**
 * Created by wemstar on 2016-01-08.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjektZTIApplication.class)
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;



    @Test
    public void crudUserTest() {
        ProductEntity productEntity1 = productService.createProduct(new ProductEntityBuilder()
                .name("Węgiela")
                .description("Coś czarnego")
                .value(20.0)
                .build());
        ProductEntity productEntity2 = productService.createProduct(new ProductEntityBuilder()
                .name("Brąz")
                .description("Coś czarnego")
                .value(20.0)
                .build());
        BasketEntity basket = new BasketEntityBuilder()
                .products(new HashSet<>(Arrays.asList(new ProductCountEntity[]{
                        new ProductCountEntityBuilder()
                                .count(2)
                                .product(productEntity1)
                                .build()
                })))
                .build();
        UserEntity userEntity = new UserEntityBuilder()
                .id(5L)
                .login("sylweik")
                .password("macura")
                .role(new HashSet<>(Arrays.asList(new String[]{StringConstants.ROLE_DOMAIN_USER})))
                .basket(basket)
                .build();
        basket.setUser(userEntity);
        userEntity = userService.createUser(userEntity);
        assertThat(userEntity.getId(),is(not(nullValue())));
        assertThat(userEntity.getLogin(),is(equalTo("sylweik")));
        assertThat(userEntity.getPassword(),is(not(equalTo("macura"))));


        userEntity.getBasket().setProducts(
                new HashSet<>(Arrays.asList(new ProductCountEntity[]{
                                new ProductCountEntityBuilder()
                                        .count(1)
                                        .product(productEntity2)
                                        .build()
                        }
                )));
        userService.updateUser(userEntity);
        assertThat(userEntity.getBasket().getProducts().toArray(new ProductCountEntity[]{})[0].getProduct().getName(),is(equalTo("Brąz")));

    }

}
