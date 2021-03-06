package Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "genres", schema = "anime_proj", catalog = "")
public class Genre {
    private int id;
    private String title;
    private String description;
    private Collection<AnimeGenres> animeGenres;

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
    @Column(name = "title", nullable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != genre.id) return false;
        if (title != null ? !title.equals(genre.title) : genre.title != null) return false;
        if (description != null ? !description.equals(genre.description) : genre.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "genre")
    public Collection<AnimeGenres> getAnimeGenres() {
        return animeGenres;
    }

    public void setAnimeGenres(Collection<AnimeGenres> animeGenres) {
        this.animeGenres = animeGenres;
    }
}
