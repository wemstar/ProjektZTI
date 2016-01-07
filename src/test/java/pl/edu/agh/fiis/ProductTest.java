package pl.edu.agh.fiis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.agh.fiis.bussines.dao.ProductDAO;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.bussines.entity.builder.ProductEntityBuilder;
import pl.edu.agh.fiis.bussines.services.ProductService;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by wemstar on 2016-01-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjektZTIApplication.class)
@WebAppConfiguration
public class ProductTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDAO productDAO;

    @Test
    public void productCRUDTest() {

        ProductEntity productEntity = new ProductEntityBuilder().name("Papaja").value(20.0).description("Warzywo").build();
        productEntity = productService.createProduct(productEntity);
        assertThat(productEntity.getId(),is(not(nullValue())));

        productEntity.setDescription("Owoc");
        productEntity.setValue(30.0);

        productService.updatePoduct(productEntity);
        ProductEntity stored = productDAO.findOne(productEntity.getId());

        assertThat(stored.getDescription(),is(equalTo("Owoc")));
        assertThat(stored.getValue(),is(equalTo(30.0)));


    }
}
