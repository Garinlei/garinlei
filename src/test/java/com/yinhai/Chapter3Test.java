package com.yinhai;

import com.yinhai.leijl.*;
import com.yinhai.leijl.chapter2And3.Chapter3;
import com.yinhai.leijl.chapter2And3.Question3;
import org.junit.Test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Chapter3Test {

    /**
     * 用于测试stream的api
     */
    @Test
    public void testStreamApiMap() {

        List<String> collect = Stream.of("a", "b", "c")
                .collect(toList());
        assertEquals(asList("a", "b", "c"), collect);
        //3.3.2map操作
        //(1)使用for循环
        List<String> collected = new ArrayList<>();
        for (String string : asList("a", "b", "ljl")) {
            String upperCase = string.toUpperCase();
            collected.add(upperCase);
        }
        assertEquals(asList("A", "B", "LJL"), collected);
        //（2）使用map 将一种流中的值转换从另一个流
        List<String> collected2 = Stream.of("a","c","f")
                                        .map(String::toUpperCase)
                                        .collect(toList());

        assertEquals(asList("A","C","F"),collected2);

        //（3）flatMap将多个Stream连接成一个Stream
        List<Integer> collect3 = Stream.of(asList(1,2),asList(3,4))
                                       .flatMap(numbers -> numbers.stream())
                                       .collect(toList());
        assertEquals(asList(1,2,3,4),collect3);

        //(4)max,min求最大最小值
        List<User> users = asList(new User("ljl","20","a"),
                                  new User("yyh","30","aa"),
                                  new User("dyh","40","aaaa"));
        User minUser = users.stream()
                            .max(Comparator.comparing(user -> user.getAdd().length()))
                            .get();
        assertEquals(users.get(2),minUser);
    }


    @Test
    public void testReduce(){
        //使用reduce操作进行求和
        int count = Stream.of(1,3,6)
                          .reduce(0,(a,e)->a + e);
        assertEquals(10,count);

        //整合操作
        Album1 album = new Album1(new User("The ljl","","China"), "China");
        Set<String> orginals = album.getMusicians()
                                    .filter(artist -> artist.getName().startsWith("The"))
                                    .map(artist -> artist.getAdd())
                                    .collect(Collectors.toSet());
        assertEquals(new HashSet<>(asList("China")),orginals);
    }


    /**
     * 测试findLongTracks的代码重构
     */
    @Test
    public void testFindLongTracks(){
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
        Set<String> longTracks = Chapter3.findLongTracks(albums);
        Set<String> longTracks1 = Chapter3.findLongTracks1(albums);
        Set<String> longTracks2 = Chapter3.findLongTracks2(albums);
        Set<String> longTracks3 = Chapter3.findLongTracks3(albums);
        Set<String> longTracks4 = Chapter3.findLongTracks4(albums);


        assertEquals(longTracks,longTracks4);
    }


    /**
     * 测试章节三的练习题
     */
    @Test
    public void testQuestions3(){
        int i = Question3.addUp(Stream.of(1, 3,4));
        assertEquals(8,i);
        //构建Artist
       /* User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);*/
        Artist artist1 = new Artist("ljl1",new ArrayList<>(),"China");
        Artist artist2 = new Artist("ljl2",new ArrayList<>(),"USA");
        List<Artist> artists = new ArrayList<>();
        artists.add(artist1);
        artists.add(artist2);
        List<String> list = Question3.getNamesAndNation(artists);
        int i2 = Question3.getTotalMembers(artists);
        assertEquals(asList("ljl1","China","ljl2","USA"),list);

        assertEquals(3,i2);

        //第六题
        int coun1 = Question3.getCountLowerLeters("aaAAAcc");
        assertEquals(4,coun1);

        //第七题
        String a1 = "aaa";
        String a2 = "aaCEEE";
        String a3 = "a";
        List<String> strings = new ArrayList<>();
        strings.add(a1);
        strings.add(a2);
        strings.add(a3);
        Optional<String> leters = Question3.getMostLowerLeters(strings);

        assertEquals(a1,leters.get());
    }
}
