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

public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "from_id")
    private Integer id;

    private String name;

    private Integer telephone;

    private Integer offer;

    private String mesage;


}