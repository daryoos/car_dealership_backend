package cardealership.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table()
@ToString
public class VehicleSpecific {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id", referencedColumnName = "vehicleId")
    private Long vehicleId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "color")
    private String color;

    @JoinColumn(name = "id", referencedColumnName = "engineId")
    private Long engineId;

    @Column(name = "trim")
    private String trim;

    @Column(name = "price")
    private Float price;

    @Column(name = "sold")
    private Boolean sold;

    @OneToOne
    @JoinColumn(name = "billId", referencedColumnName = "id")
    private Bill bill;
}