package tu.comsci.laptopstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tu.comsci.laptopstore.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
