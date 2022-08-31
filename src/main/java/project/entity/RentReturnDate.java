package project.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter

public class RentReturnDate {

    @Id
    @GeneratedValue
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private final LocalDate rentDate = LocalDate.now();

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate returnDate =  LocalDate.now();

    @OneToMany(mappedBy = "rentReturnDate")
    private Set<Car> cars;

}
