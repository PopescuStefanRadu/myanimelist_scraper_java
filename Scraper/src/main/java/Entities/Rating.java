package Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
public class Rating {
    private int id;
    private String rating;
    private Collection<Anime> anime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rating", nullable = true, length = 45)
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating1 = (Rating) o;

        if (id != rating1.id) return false;
        if (rating != null ? !rating.equals(rating1.rating) : rating1.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "rating")
    public Collection<Anime> getAnime() {
        return anime;
    }

    public void setAnime(Collection<Anime> anime) {
        this.anime = anime;
    }
}
