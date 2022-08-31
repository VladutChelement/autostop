package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.Form;



public interface FormRepository extends JpaRepository<Form, Long> {

}