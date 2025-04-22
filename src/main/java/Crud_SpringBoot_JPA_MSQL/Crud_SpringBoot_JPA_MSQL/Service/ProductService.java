package Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Service;

import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Models.Product;
import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    //inyectamos el repositorio
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //todos los productos
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //producto por id
    public Optional<Product> getfindById(Long Id){
        return productRepository.findById(Id);
    }

    //nuevo producto
    public Product createdProduct(Product product){
        return productRepository.save(product);
    }

    //actualizar producto
    public Optional<Product> updatedProduct(Long Id, Product productDetails){
        return productRepository.findById(Id)
                .map(product -> {
                    product.setName(productDetails.getName());
                    product.setPrice(productDetails.getPrice());
                    return productRepository.save(product);
                });
    }

    //eliminar producto
    public boolean deletedProduct(Long Id){
        return productRepository.findById(Id)
                .map(product -> {
                    productRepository.delete(product);
                    return true;
                }).orElse(false);
    }
}
