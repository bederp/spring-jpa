package pl.connectis.springjpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity {

    private String seat;
    private BigDecimal price;

    @ManyToOne(optional = false)
    private Session sessions;

}
