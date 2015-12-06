package pl.edu.agh.fiis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.fiis.builder.dto.ProductDTOBuilder;
import pl.edu.agh.fiis.dao.ProductDAO;
import pl.edu.agh.fiis.dto.ProductDTO;
import pl.edu.agh.fiis.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2015-12-06.
 */
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public List<ProductDTO> getAll() {
        return ProductDTOBuilder.convertEntities(productDAO.findAll());
    }
}
