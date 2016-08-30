package Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "animerelationships")
public class AnimeRelationship {
    private int id;
    private String title;
    private Collection<RelatedAnime> relatedanime;

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
    @Column(name = "title", nullable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimeRelationship that = (AnimeRelationship) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "animeRelationship")
    public Collection<RelatedAnime> getRelatedanime() {
        return relatedanime;
    }

    public void setRelatedanime(Collection<RelatedAnime> relatedanime) {
        this.relatedanime = relatedanime;
    }
}
