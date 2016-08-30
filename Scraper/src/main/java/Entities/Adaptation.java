package Entities;

import javax.persistence.*;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "adaptations", schema = "anime_proj", catalog = "")
public class Adaptation {
    private int id;
    private Anime anime;
    private Mangaln mangaln;

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

        Adaptation that = (Adaptation) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "anime", referencedColumnName = "id", nullable = false)
    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    @ManyToOne
    @JoinColumn(name = "adaptation", referencedColumnName = "id", nullable = false)
    public Mangaln getMangaln() {
        return mangaln;
    }

    public void setMangaln(Mangaln mangaln) {
        this.mangaln = mangaln;
    }
}
