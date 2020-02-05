package pl.connectis.springjpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Room extends BaseEntity{

    private String name;
    private int capacity;
    private String description;
}
