package Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Controller;

import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Models.Product;
import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Service.ProductService;
import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Product> getfindByIdProduct(@PathVariable Long Id){
        return productService.getfindById(Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createdProduct(@RequestBody Product product){
        return productService.createdProduct(product);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Product> updatedProduct(@PathVariable Long Id, @RequestBody Product productDetails){
        return productService.updatedProduct(Id, productDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deletedProduct(@PathVariable Long Id){
        boolean deletProduct = productService.deletedProduct(Id);
        return deletProduct ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
