import Entities.*;
import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * Created by popes on 31.07.2016.
 */


public class MainApp {

    public static String dir = System.getProperty("user.dir");

    public static void main(String[] args) {
        //  1 -> 33242
        System.getProperties().list(System.out);

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessions = cfg.buildSessionFactory();
        Session session = sessions.openSession();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();

            Anime anime = new Anime();
            Collection<AnimeGenres> animeGenres = new ArrayList<>();
            Collection<AnimeAltTitle> altTitles = new ArrayList<>();

            Document doc = Jsoup.connect("http://myanimelist.net/anime/1").get();
//            Document doc = Jsoup.connect("http://myanimelist.net/anime/33019/").get();

            // Title
            Element titleE = doc.select("span[itemprop='name']").first();
            Element descriptionE = doc.select("span[itemprop='description']").first();
            anime.setTitle(titleE.text());
            anime.setDescription(descriptionE.text());

            // TODO this select can return sth unexpected
            Element sideE = doc.select("*[class='borderClass']").first();

            //Alt titles
            Elements altTitlesE = sideE.select("*[class=spaceit_pad]");
            for (Element altTitleE : altTitlesE) {
                Element spanE = altTitleE.select("span").first();

                AnimeAltTitle altTitle = new AnimeAltTitle();

                altTitle.setType(spanE.text().replace(":", ""));

                spanE.remove();
                altTitle.setTitle(altTitleE.text());
                altTitle.setAnime(anime);
                altTitles.add(altTitle);
            }
            anime.setAnimealttitles(altTitles);

            //Type
            // TODO very shoddy
            Elements propertiesE = doc.select("*[class=dark_text]");
            for (Element propE : propertiesE) {
                Element parPropE = propE.parent();

//                System.out.println(parPropE.toString());
                System.out.println(propE.text());
                String propType = propE.text();
                switch (propType) {
                    case "Type:":
                        Animetype animetype = null;
                        String type = parPropE.select("a").first().text();
                        try {
                            Query qu = em.createQuery("select at from Animetype at where at.type=:type").setParameter("type", type);
                            animetype = (Animetype) qu.getSingleResult();
                        } catch (Exception ignored) {
                            ignored.printStackTrace();
                        }
                        if (animetype == null) {
                            animetype = new Animetype();
                            animetype.setType(type);
                            em.persist(animetype);
                        }
                        anime.setAnimetype(animetype);
                        break;
                    case "Episodes:":
                        propE.remove();
                        try {
                            anime.setEpisodes(Integer.parseInt(parPropE.text()));
                        } catch (Exception ignored) {
                        }
                        break;
                    case "Status:":
                        propE.remove();
                        anime.setStatus(parPropE.text());
                        break;
                    case "Aired:":
                        propE.remove();
                        String rawDate = parPropE.text();
                        String[] rawDates = rawDate.split("to");
                        DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
                        try {
                            rawDates[0] = rawDates[0].trim();
                            Date startDate = df.parse(rawDates[0]);
                            anime.setStartDate(new java.sql.Date(startDate.getTime()));
                        } catch (Exception ignored) {
                        }

                        try {
                            rawDates[1] = rawDates[1].trim();
                            Date finishDate = df.parse(rawDates[1]);
                            anime.setFinishDate(new java.sql.Date(finishDate.getTime()));
                        } catch (Exception ignored) {
                        }
                        break;
                    case "Premiered:":
                        try {
                            anime.setPremiereSeason(parPropE.select("a").first().text());
                        } catch (Exception ignored) {
                            ignored.printStackTrace();
                        }
                        break;
                    case "Source:":
                        propE.remove();
                        String source = parPropE.text();
                        anime.setSource(source);
                        break;
                    case "Duration:":
                        propE.remove();
                        String duration = parPropE.text();
                        anime.setDuration(duration);
                        break;
                    case "Rating:":
                        propE.remove();
                        String ratingStr = parPropE.text();
                        Rating rating = null;
                        try {
                            Query qu = em.createQuery("SELECT rat FROM Rating rat WHERE rat.rating=:rating")
                                    .setParameter("rating", ratingStr);
                            rating = (Rating) qu.getSingleResult();
                        } catch (Exception ignored) {
                        }
                        if (rating == null && !ratingStr.equals("None")) {
                            rating = new Rating();
                            rating.setRating(ratingStr);
                            anime.setRating(rating);
                            em.persist(rating);
                        }
                        anime.setRating(rating);
                        break;
                    case "Broadcast:":
                        propE.remove();
                        String broadcast = parPropE.text();
                        if (!broadcast.equals("Unknown")) {
                            anime.setBroadcast(broadcast);
                        }
                        break;
                    case "Genres:":
                        Elements genresE = parPropE.select("a");
                        for (Element genreE : genresE) {
                            Genre genre = MainApp.getSetGenres(genreE.text(), em);
                            AnimeGenres animeGenre = new AnimeGenres();
                            animeGenre.setGenre(genre);
                            animeGenre.setAnime(anime);
                            animeGenres.add(animeGenre);
                        }
                        break;
                }
            }


            em.persist(anime);
            for (AnimeGenres ag : animeGenres){
                em.persist(ag);
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo persist
    public static void getPics(String url, EntityManager em, Anime anime) {
        Document doc = new Document(url);
        Elements imagesE = doc.select("td[valign='top']").select("img[src*='images/anime']");
        for (Element imageE : imagesE) {
            String sImage = imageE.attr("src");
            try {
                //Download file
                URL imageUrl = new URL("asd");
                Double random = Math.random() * 256;
                String subDir = Integer.toString(random.intValue());
                File subDirFile = new File(dir + "\\" + subDir);
                subDirFile.mkdir();
                String imageName = Integer.toString(subDirFile.listFiles().length + 1) + ".jpg";
                File imageFile = new File(subDirFile.getPath() + "\\" + imageName);
                FileUtils.copyURLToFile(imageUrl, imageFile);

                //Save data in database
                AnimeImage image = new AnimeImage();
                em.getTransaction().begin();
                image.setPath(subDir + "\\" + imageName);
                image.setAnime(anime);
                em.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Genre getSetGenres(String genreStr, EntityManager em) {
        Genre genre = null;
        Query qu = em.createQuery("SELECT genr FROM Genre genr WHERE genr.title=:title")
                .setParameter("title", genreStr);
        try {
            genre = (Genre) qu.getSingleResult();
        } catch (Exception ignored) {
        }
        if (genre == null) {
            genre = new Genre();
            genre.setTitle(genreStr);
            em.persist(genre);
        }
        return genre;
    }
}
