package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.Car;
import project.entity.CarType;
import project.entity.VintageCar;

import java.util.Set;

public interface VintageCarRepository extends JpaRepository<VintageCar, Long> {

    Set<VintageCar> findByCarType(CarType carType);
}