package Entities;

import javax.persistence.*;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "relatedanime", schema = "anime_proj", catalog = "")
public class RelatedAnime {
    private int id;
    private AnimeRelationship animeRelationship;
    private Anime anime;
    private Anime relatedAnime;

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

        RelatedAnime that = (RelatedAnime) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Relationship", referencedColumnName = "id", nullable = false)
    public AnimeRelationship getAnimeRelationship() {
        return animeRelationship;
    }

    public void setAnimeRelationship(AnimeRelationship animeRelationship) {
        this.animeRelationship = animeRelationship;
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
    @JoinColumn(name = "RelatedAnime", referencedColumnName = "id", nullable = false)
    public Anime getRelatedAnime() {
        return relatedAnime;
    }

    public void setRelatedAnime(Anime relatedAnime) {
        this.relatedAnime = relatedAnime;
    }
}
