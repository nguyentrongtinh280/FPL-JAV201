package dao;

import dto.VideoFavoriteInfo;
import entity.Video;

import java.util.List;

public interface VideoDAO {
    void createVideo(Video video);
    void updateVideo(Video video);
    void deleteVideo (String videoId);
    List<Video> getAllVideos();
    Video getVideoById(String videoId);

    List<Video> findActiveVideos();
    List<Video> findByTitle(String title);

    List<VideoFavoriteInfo> findTop10MostFavoriteVideos();
    List<Video> findVideosWithNoFavorite();
}
