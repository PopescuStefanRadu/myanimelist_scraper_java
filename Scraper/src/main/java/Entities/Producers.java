package Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
public class Producers {
    private int id;
    private String title;
    private Collection<AnimeProducers> animeProducer;

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

        Producers producers = (Producers) o;

        if (id != producers.id) return false;
        if (title != null ? !title.equals(producers.title) : producers.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "producer")
    public Collection<AnimeProducers> getAnimeProducer() {
        return animeProducer;
    }

    public void setAnimeProducer(Collection<AnimeProducers> animeProducer) {
        this.animeProducer = animeProducer;
    }
}
