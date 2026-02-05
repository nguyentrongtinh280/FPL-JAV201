package entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Favorite", schema = "dbo")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;

    @Temporal(TemporalType.DATE)
    private Date likeDate;

    public Favorite(Long id, Date likeDate, Video video, User user) {
        this.id = id;
        this.likeDate = likeDate;
        this.video = video;
        this.user = user;
    }

    public Favorite() {
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}
