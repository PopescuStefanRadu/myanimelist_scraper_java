package Entities;

import javax.persistence.*;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "anime_characters", schema = "anime_proj", catalog = "")
public class AnimeCharacters {
    private int id;
    private Anime anime;
    private Characterroles role;
    private Character character;

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

        AnimeCharacters that = (AnimeCharacters) o;

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
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    public Characterroles getRole() {
        return role;
    }

    public void setRole(Characterroles role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "character", referencedColumnName = "id", nullable = false)
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
