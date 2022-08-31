package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.Car;
import project.entity.CarType;

import java.util.Set;


public interface CarRepository extends JpaRepository<Car, Long> {
    Set<Car> findByCarType(CarType carType);
}


