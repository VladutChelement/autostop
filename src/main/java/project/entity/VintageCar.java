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

public class VintageCar {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "vCar_id")
        private Integer id;
        @Column(nullable = false)
        private String model;
        @Column(nullable = false)
        private String colour;
        @Column(nullable = false)
        private Integer price;
        @Column(nullable = false)
        private String brand;
        @Column(nullable = false)
        private Integer year;
        //    @Column(nullable = false)
//    private Integer usage;
        private String picture;
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




    }

