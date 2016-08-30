package Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "licensors", schema = "anime_proj", catalog = "")
public class Licensor {
    private int id;
    private String licensor;
    private Collection<AnimeLicensors> animeLicensors;

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
    @Column(name = "Licensor", nullable = true, length = 45)
    public String getLicensor() {
        return licensor;
    }

    public void setLicensor(String licensor) {
        this.licensor = licensor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Licensor licensor1 = (Licensor) o;

        if (id != licensor1.id) return false;
        if (licensor != null ? !licensor.equals(licensor1.licensor) : licensor1.licensor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (licensor != null ? licensor.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "licensor")
    public Collection<AnimeLicensors> getAnimeLicensors() {
        return animeLicensors;
    }

    public void setAnimeLicensors(Collection<AnimeLicensors> animeLicensors) {
        this.animeLicensors = animeLicensors;
    }
}
