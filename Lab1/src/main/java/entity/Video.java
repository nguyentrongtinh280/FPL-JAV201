package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Video", schema = "dbo")
public class Video {

    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Poster", length = 255)
    private String poster;

    @Column(name = "Views", nullable = false)
    private int views;

    @Lob
    @Column(name = "Description")
    private String description;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;


    public Video(String description, String id, String title, String poster, int views, boolean active, List<Favorite> favorites) {
        this.description = description;
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.views = views;
        this.active = active;
        this.favorites = favorites;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }
}
