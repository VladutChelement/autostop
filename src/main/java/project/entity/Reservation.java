package project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.Type;

import java.util.Date;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Builder
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rent")
    private Long idrent;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_car", nullable = false)
//    private Car car;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Type(type = "date")
//    @Column(name = "data_from")
//    private Date dataFrom;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Type(type = "date")
//    @Column(name = "data_to")
//    private Date dataTo;
//
//    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
//    @JoinColumn(name = "localization_start", referencedColumnName = "id_localization")
//    private Localization localizationStart;
//
//    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
//    @JoinColumn(name = "localization_end", referencedColumnName = "id_localization")
//    private Localization localizationEnd;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;
//
//    @Column(name = "price")
//
//    private float price;
//
//
//
//    public Reservation(Car car, User user, Date dataFrom, Date dataTo, Localization localizationStart, Localization localizationEnd, float price) {
//        this.car = car;
//        this.user = user;
//        this.dataFrom = dataFrom;
//        this.dataTo = dataTo;
//        this.localizationStart = localizationStart;
//        this.localizationEnd = localizationEnd;
//        this.price = price;
//    }

}
