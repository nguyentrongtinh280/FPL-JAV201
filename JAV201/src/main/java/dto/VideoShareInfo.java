package dto;

import java.util.Date;

public class VideoShareInfo {

    private String title;
    private Long shareCount;
    private Date firstShareDate;
    private Date lastShareDate;

    public VideoShareInfo(String title, Long shareCount, Date firstShareDate, Date lastShareDate) {
        this.title = title;
        this.shareCount = shareCount;
        this.firstShareDate = firstShareDate;
        this.lastShareDate = lastShareDate;
    }

    public VideoShareInfo() {
    }

    public Date getLastShareDate() {
        return lastShareDate;
    }

    public void setLastShareDate(Date lastShareDate) {
        this.lastShareDate = lastShareDate;
    }

    public Date getFirstShareDate() {
        return firstShareDate;
    }

    public void setFirstShareDate(Date firstShareDate) {
        this.firstShareDate = firstShareDate;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
