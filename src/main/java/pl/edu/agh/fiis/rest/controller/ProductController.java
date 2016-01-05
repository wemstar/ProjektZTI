package pl.edu.agh.fiis.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.fiis.annotation.DomainUser;
import pl.edu.agh.fiis.rest.dto.builder.ProductDTOBuilder;
import pl.edu.agh.fiis.bussines.dao.ProductDAO;
import pl.edu.agh.fiis.rest.dto.ProductDTO;

import java.util.List;

/**
 * Created by wemstar on 2015-12-06.
 */
@RestController
@RequestMapping(path = "/product")
@DomainUser
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public List<ProductDTO> getAll() {
        return ProductDTOBuilder.convertEntities(productDAO.findAll());
    }

    @RequestMapping(path = "/name/{name}",method = RequestMethod.GET)
    public List<ProductDTO> getProductByName(@PathVariable String name) {
        return ProductDTOBuilder.convertEntities(productDAO.findByName(name));
    }

    @RequestMapping(path = "id/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return new ProductDTOBuilder(productDAO.findOne(id)).build();
    }
}
