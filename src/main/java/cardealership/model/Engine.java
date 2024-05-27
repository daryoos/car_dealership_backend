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
public class Engine {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "capacity")
    private Float capacity;

    @Column(name = "combustion")
    private String combustion;

    @Column(name = "horsePower")
    private Integer horsePower;

    @Column(name = "price")
    private Float price;

    @OneToMany
    @JoinColumn(name = "engineId", referencedColumnName = "id")
    private Set<VehicleSpecific> vehiclesSpecific;
}
