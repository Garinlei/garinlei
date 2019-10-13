package com.yinhai;

import com.yinhai.leijl.Album;
import com.yinhai.leijl.Artist;
import com.yinhai.leijl.Track;
import com.yinhai.leijl.chapter5.Chapter5;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Chapter5Test {


    /**
     * 测试averagingInt函数
     */
    @Test
    public void testAve(){
        Track track1 = new Track("曲目1", 50);
        Track track2 = new Track("曲目2", 60);
        Track track3 = new Track("曲目3", 61);
        Track track4 = new Track("曲目4", 62);
        List<Track> tracks1 = new ArrayList<>();
        List<Track> tracks2 = new ArrayList<>();
        List<Track> tracks3 = new ArrayList<>();
        tracks1.add(track1);
        tracks2.add(track1);
        tracks2.add(track2);
        tracks3.add(track1);
        tracks3.add(track2);
        tracks3.add(track3);
        //tracks3.add(track4);
        //构建albums
        Album album1 = new Album("yyh1", tracks1, new ArrayList<>());
        Album album2 = new Album("yyh2", tracks2, new ArrayList<>());
        Album album3 = new Album("yyh3", tracks3, new ArrayList<>());
        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        double v = Chapter5.aveTracks(albums);
        Assert.assertEquals("2",v);
    }

    /**
     * 测试数据分块函数partitioningBy
     */
    @Test
    public void testPartitioningBy(){
        Artist artist1 = new Artist("yyh1",new ArrayList<>(),"China");
        Artist artist2 = new Artist("yyh2",new ArrayList<>(),"China");
        List<Artist> members = new ArrayList<>();
        members.add(artist1);
        members.add(artist2);
        Artist artist3 = new Artist("yyh3",members,"China");
        Artist artist4 = new Artist("yyh4",new ArrayList<>(),"China");
        List<Artist> artists = new ArrayList<>();
        artists.add(artist3);
        artists.add(artist4);
        artists.add(artist1);
        Map<Boolean, List<Artist>> map = Chapter5.bandAndSolo(artists.stream());
        System.out.println(map.toString());
    }

}
