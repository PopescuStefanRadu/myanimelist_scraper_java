package Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by popes on 06.08.2016.
 */
@Entity
public class Anime {
    private int id;
    private String title;
    private Integer episodes;
    private String status;
    private Date startDate;
    private Date finishDate;
    private String premiereSeason;
    private String source;
    private String duration;
    private String description;
    private String broadcast;
    private Rating rating;
    private Animetype animetype;
    private Collection<AnimeGenres> animeGenres;
    private Collection<AnimeAltTitle> animealttitles;
    private Collection<RelatedAnime> animerelations;
    private Collection<RelatedAnime> relatedanime;
    private Collection<Statistic> statistics;
    private Collection<Adaptation> adaptations;
    private Collection<AnimeCharacters> animeCharacters;
    private Collection<AnimeLicensors> animeLicensors;
    private Collection<AnimePersons> animePeoples;
    private Collection<AnimeProducers> animeProducers;
    private Collection<AnimeStudios> animeStudios;
    private Collection<AnimeImage> animeImages;

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
    @Column(name = "Title", nullable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Episodes", nullable = true)
    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    @Basic
    @Column(name = "Status", nullable = true, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "StartDate", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "FinishDate", nullable = true)
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "PremiereSeason", nullable = true, length = 100)
    public String getPremiereSeason() {
        return premiereSeason;
    }

    public void setPremiereSeason(String premiereSeason) {
        this.premiereSeason = premiereSeason;
    }

    @Basic
    @Column(name = "Source", nullable = true, length = 45)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "Duration", nullable = true, length = 100)
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 3000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "broadcast", nullable = true, length = 45)
    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anime anime = (Anime) o;

        if (id != anime.id) return false;
        if (title != null ? !title.equals(anime.title) : anime.title != null) return false;
        if (episodes != null ? !episodes.equals(anime.episodes) : anime.episodes != null) return false;
        if (status != null ? !status.equals(anime.status) : anime.status != null) return false;
        if (startDate != null ? !startDate.equals(anime.startDate) : anime.startDate != null) return false;
        if (finishDate != null ? !finishDate.equals(anime.finishDate) : anime.finishDate != null) return false;
        if (premiereSeason != null ? !premiereSeason.equals(anime.premiereSeason) : anime.premiereSeason != null)
            return false;
        if (source != null ? !source.equals(anime.source) : anime.source != null) return false;
        if (duration != null ? !duration.equals(anime.duration) : anime.duration != null) return false;
        if (description != null ? !description.equals(anime.description) : anime.description != null) return false;
        if (broadcast != null ? !broadcast.equals(anime.broadcast) : anime.broadcast != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (episodes != null ? episodes.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        result = 31 * result + (premiereSeason != null ? premiereSeason.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (broadcast != null ? broadcast.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Rating", referencedColumnName = "id")
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @ManyToOne
    @JoinColumn(name = "Type", referencedColumnName = "id")
    public Animetype getAnimetype() {
        return animetype;
    }

    public void setAnimetype(Animetype animetype) {
        this.animetype = animetype;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<AnimeGenres> getAnimeGenres() {
        return animeGenres;
    }

    public void setAnimeGenres(Collection<AnimeGenres> animeGenres) {
        this.animeGenres = animeGenres;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<AnimeAltTitle> getAnimealttitles() {
        return animealttitles;
    }

    public void setAnimealttitles(Collection<AnimeAltTitle> animealttitles) {
        this.animealttitles = animealttitles;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<RelatedAnime> getAnimerelations() {
        return animerelations;
    }

    public void setAnimerelations(Collection<RelatedAnime> animerelations) {
        this.animerelations = animerelations;
    }

    @OneToMany(mappedBy = "relatedAnime")
    public Collection<RelatedAnime> getRelatedanime() {
        return relatedanime;
    }

    public void setRelatedanime(Collection<RelatedAnime> relatedanime) {
        this.relatedanime = relatedanime;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(Collection<Statistic> statistics) {
        this.statistics = statistics;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<Adaptation> getAdaptations() {
        return adaptations;
    }

    public void setAdaptations(Collection<Adaptation> adaptations) {
        this.adaptations = adaptations;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<AnimeCharacters> getAnimeCharacters() {
        return animeCharacters;
    }

    public void setAnimeCharacters(Collection<AnimeCharacters> animeCharacters) {
        this.animeCharacters = animeCharacters;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<AnimeLicensors> getAnimeLicensors() {
        return animeLicensors;
    }

    public void setAnimeLicensors(Collection<AnimeLicensors> animeLicensors) {
        this.animeLicensors = animeLicensors;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<AnimePersons> getAnimePeoples() {
        return animePeoples;
    }

    public void setAnimePeoples(Collection<AnimePersons> animePeoples) {
        this.animePeoples = animePeoples;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<AnimeProducers> getAnimeProducers() {
        return animeProducers;
    }

    public void setAnimeProducers(Collection<AnimeProducers> animeProducers) {
        this.animeProducers = animeProducers;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<AnimeStudios> getAnimeStudios() {
        return animeStudios;
    }

    public void setAnimeStudios(Collection<AnimeStudios> animeStudios) {
        this.animeStudios = animeStudios;
    }

    @OneToMany(mappedBy = "anime")
    public Collection<AnimeImage> getAnimeImages() {
        return animeImages;
    }

    public void setAnimeImages(Collection<AnimeImage> animeImages) {
        this.animeImages = animeImages;
    }
}
