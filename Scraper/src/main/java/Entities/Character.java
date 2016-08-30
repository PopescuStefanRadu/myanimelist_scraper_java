package Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "characters", schema = "anime_proj", catalog = "")
public class Character {
    private int id;
    private String name;
    private String role;
    private Collection<AnimeCharacters> animeCharacters;

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
    @Column(name = "Name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Role", nullable = true, length = 45)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (id != character.id) return false;
        if (name != null ? !name.equals(character.name) : character.name != null) return false;
        if (role != null ? !role.equals(character.role) : character.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "character")
    public Collection<AnimeCharacters> getAnimeCharacters() {
        return animeCharacters;
    }

    public void setAnimeCharacters(Collection<AnimeCharacters> animeCharacters) {
        this.animeCharacters = animeCharacters;
    }
}
