package Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
public class People {
    private int id;
    private String givenName;
    private Date birthday;
    private String website;
    private String more;
    private Collection<AnimePersons> animePersons;

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
    @Column(name = "givenName", nullable = true, length = 45)
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "website", nullable = true, length = 100)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "more", nullable = true, length = 45)
    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (id != people.id) return false;
        if (givenName != null ? !givenName.equals(people.givenName) : people.givenName != null) return false;
        if (birthday != null ? !birthday.equals(people.birthday) : people.birthday != null) return false;
        if (website != null ? !website.equals(people.website) : people.website != null) return false;
        if (more != null ? !more.equals(people.more) : people.more != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (givenName != null ? givenName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (more != null ? more.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "person")
    public Collection<AnimePersons> getAnimePersons() {
        return animePersons;
    }

    public void setAnimePersons(Collection<AnimePersons> animePersons) {
        this.animePersons = animePersons;
    }
}
