package Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Repository;

import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByNameIgnoreCase(String username);
}
