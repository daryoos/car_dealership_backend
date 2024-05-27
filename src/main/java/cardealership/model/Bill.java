package cardealership.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table()
@ToString
public class Bill {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private Float price;

    @Column(name = "date")
    private Date date;

    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Long userId;

    @JoinColumn(name = "vehicleSpecificId", referencedColumnName = "id")
    private Long vehicleSpecificId;

    @JoinColumn(name = "warrantyId", referencedColumnName = "id")
    private Long warrantyId;

    @Column(name = "cart")
    private Boolean cart;
}
