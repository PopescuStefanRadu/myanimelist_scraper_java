package Entities;

import javax.persistence.*;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
@Table(name = "statistics", schema = "anime_proj", catalog = "")
public class Statistic {
    private int id;
    private Double score;
    private Integer ranked;
    private Integer popularity;
    private Integer members;
    private Integer noPeopleScored;
    private Integer favorites;
    private Anime anime;

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
    @Column(name = "Score", nullable = true, precision = 0)
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "Ranked", nullable = true)
    public Integer getRanked() {
        return ranked;
    }

    public void setRanked(Integer ranked) {
        this.ranked = ranked;
    }

    @Basic
    @Column(name = "Popularity", nullable = true)
    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    @Basic
    @Column(name = "Members", nullable = true)
    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    @Basic
    @Column(name = "noPeopleScored", nullable = true)
    public Integer getNoPeopleScored() {
        return noPeopleScored;
    }

    public void setNoPeopleScored(Integer noPeopleScored) {
        this.noPeopleScored = noPeopleScored;
    }

    @Basic
    @Column(name = "Favorites", nullable = true)
    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statistic statistic = (Statistic) o;

        if (id != statistic.id) return false;
        if (anime != statistic.anime) return false;
        if (score != null ? !score.equals(statistic.score) : statistic.score != null) return false;
        if (ranked != null ? !ranked.equals(statistic.ranked) : statistic.ranked != null) return false;
        if (popularity != null ? !popularity.equals(statistic.popularity) : statistic.popularity != null) return false;
        if (members != null ? !members.equals(statistic.members) : statistic.members != null) return false;
        if (noPeopleScored != null ? !noPeopleScored.equals(statistic.noPeopleScored) : statistic.noPeopleScored != null)
            return false;
        if (favorites != null ? !favorites.equals(statistic.favorites) : statistic.favorites != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (ranked != null ? ranked.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (members != null ? members.hashCode() : 0);
        result = 31 * result + (noPeopleScored != null ? noPeopleScored.hashCode() : 0);
        result = 31 * result + (favorites != null ? favorites.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "anime", referencedColumnName = "id", nullable = false)
    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }
}
