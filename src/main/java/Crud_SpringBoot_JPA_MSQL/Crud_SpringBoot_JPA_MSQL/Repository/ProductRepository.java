package Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Repository;

import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
