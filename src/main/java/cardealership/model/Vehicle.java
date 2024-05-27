package cardealership.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table()
@ToString
public class Vehicle {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @OneToMany
    @JoinColumn(name = "vehicleId", referencedColumnName = "id")
    private Set<VehicleSpecific> vehiclesSpecific;
}

