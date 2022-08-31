package project.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data
@Entity

public class Car
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;
    @Column(name = "model")
    private String model;
    @Column(name = "colour")
    private String colour;
    @Column(name = "price")
    private String price;
    @Column(name = "brand")
    private String brand;
    @Column(name = "year")
    private Integer year;
//    @Column(nullable = false)
//    private Integer usage;
@Column(name = "picture")
    private String picture;

//    @Column
//    private boolean available;
//
//    @Column(nullable = false)
//    private boolean sold;
//
    @ManyToOne
    (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "id"))
    private MyUser myUser;




    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = CarType.class)
    private Set<CarType> carType;

    @ManyToOne
    private RentReturnDate rentReturnDate;


}