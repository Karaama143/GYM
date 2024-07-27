package Gym_management;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "gym")
public class Gym {
    @Id
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    private String location;

}
