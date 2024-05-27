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
public class Warranty {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private Float price;

    @Column(name = "years")
    private Integer years;

    @Column(name = "endDate")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "billId", referencedColumnName = "id")
    private Bill bill;
}
