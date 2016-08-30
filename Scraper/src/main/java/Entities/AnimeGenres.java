package Entities;

import javax.persistence.*;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "anime_genres", schema = "anime_proj", catalog = "")
public class AnimeGenres {
    private int id;
    private Anime anime;
    private Genre genre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimeGenres that = (AnimeGenres) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "Anime", referencedColumnName = "id", nullable = false)
    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    @ManyToOne
    @JoinColumn(name = "Genre", referencedColumnName = "id", nullable = false)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
