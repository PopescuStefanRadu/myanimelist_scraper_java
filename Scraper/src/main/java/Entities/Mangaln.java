package Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
public class Mangaln {
    private int id;
    private String type;
    private String title;
    private Collection<Adaptation> adaptations;

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
    @Column(name = "type", nullable = true, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Title", nullable = true, length = 45)
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

        Mangaln mangaln = (Mangaln) o;

        if (id != mangaln.id) return false;
        if (type != null ? !type.equals(mangaln.type) : mangaln.type != null) return false;
        if (title != null ? !title.equals(mangaln.title) : mangaln.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "mangaln")
    public Collection<Adaptation> getAdaptations() {
        return adaptations;
    }

    public void setAdaptations(Collection<Adaptation> adaptations) {
        this.adaptations = adaptations;
    }
}
