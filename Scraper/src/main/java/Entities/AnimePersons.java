package Entities;

import javax.persistence.*;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "anime_people", schema = "anime_proj", catalog = "")
public class AnimePersons {
    private int idAnimePerson;
    private Anime anime;
    private PersonRoles personrole;
    private People person;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnime_people", nullable = false)
    public int getIdAnimePerson() {
        return idAnimePerson;
    }

    public void setIdAnimePerson(int idAnimePerson) {
        this.idAnimePerson = idAnimePerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimePersons that = (AnimePersons) o;

        if (idAnimePerson != that.idAnimePerson) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idAnimePerson;
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
    public PersonRoles getPersonrole() {
        return personrole;
    }

    public void setPersonrole(PersonRoles personrole) {
        this.personrole = personrole;
    }

    @ManyToOne
    @JoinColumn(name = "people", referencedColumnName = "id", nullable = false)
    public People getPerson() {
        return person;
    }

    public void setPerson(People person) {
        this.person = person;
    }
}
