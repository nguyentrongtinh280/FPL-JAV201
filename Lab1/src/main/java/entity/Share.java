package entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Share", schema = "dbo")
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId", nullable = false)
    private Video video;

    @Column(name = "Emails", nullable = false, length = 255)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "ShareDate", nullable = false)
    private Date shareDate;

    public Share(User user, Long id, Video video, String email, Date shareDate) {
        this.user = user;
        this.id = id;
        this.video = video;
        this.email = email;
        this.shareDate = shareDate;
    }

    public Share() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }
}