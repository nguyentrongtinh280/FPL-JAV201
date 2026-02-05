package dto;

public class VideoFavoriteInfo {

    private String title;
    private Long favoriteCount;

    public VideoFavoriteInfo(String title, Long favoriteCount) {
        this.title = title;
        this.favoriteCount = favoriteCount;
    }

    public VideoFavoriteInfo() {
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
