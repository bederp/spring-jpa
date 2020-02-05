package pl.connectis.springjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "marathons")
public class Movie extends BaseEntity{

    private String title;
    @Enumerated(EnumType.STRING)
    private MovieCategory category;
    private Integer length;
    private String description;
    private Integer requiredAge;

    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Marathon> marathons = new ArrayList<>();

    public Movie updateMovie(String title, MovieCategory category, Integer length, String description, Integer requiredAge) {
        setTitle(title);
        setCategory(category);
        setLength(length);
        setDescription(description);
        setRequiredAge(requiredAge);
        return this;
    }


}
