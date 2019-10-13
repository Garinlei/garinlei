package com.yinhai.leijl.chapter4;

import com.yinhai.leijl.Album;
import com.yinhai.leijl.Artist;
import com.yinhai.leijl.Track;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 第四章 类库
 */
public class Chapter4 {

    //统计曲目长度
    //IntSummaryStatistics 用于统计数组中元素的最大值，最小值，平均值，个数，元素总和
    public static void getTrackLength(Album album){
        IntSummaryStatistics trackLengthStates =
                album.getTracks().stream()
                                 .mapToInt(track -> track.getLength())
                                 .summaryStatistics();
        System.out.printf("Max: %d, Min:%d, Ave: %f, Sum:%d",trackLengthStates.getMax(),
                                                             trackLengthStates.getMin(),
                                                             trackLengthStates.getAverage(),
                                                             trackLengthStates.getSum());
    }

    public static void main(String[] args) {
        //构建Tracks
        Track track1 = new Track("曲目1", 50);
        Track track2 = new Track("曲目2", 60);
        Track track3 = new Track("曲目3", 61);
        Track track4 = new Track("曲目4", 62);
        List<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);
        tracks.add(track4);
        //构建Artist
        Artist artist1 = new Artist("ljl1",new ArrayList<>(),"China");
        Artist artist2 = new Artist("ljl2",new ArrayList<>(),"USA");
        List<Artist> artists = new ArrayList<>();
        artists.add(artist1);
        artists.add(artist2);
        //构建albums
        Album album1 = new Album("yyh1", tracks, artists);
        Album album2 = new Album("yyh2", tracks, artists);
        Album album3 = new Album("yyh3", tracks, artists);
        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        getTrackLength(album1);
    }
}

