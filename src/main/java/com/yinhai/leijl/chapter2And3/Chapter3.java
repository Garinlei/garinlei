package com.yinhai.leijl.chapter2And3;

import com.yinhai.leijl.Album;
import com.yinhai.leijl.Track;
import com.yinhai.leijl.User;

import java.util.*;
import java.util.stream.Collectors;


public class Chapter3 {

    public static  void main(String[] args){
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0;i<3;i++){
            User user = new User();
            user.setName("ljl"+i);
            user.setAge("22");
            user.setAdd("四川"+i);
            list.add(user);
        }
        for (int i = 0;i < 4;i++){
            User user = new User();
            user.setAdd("成都"+i);
            user.setName("xiaohong"+i);
            user.setAge("21");
            list.add(user);
        }

        //使用for循环来计算来自成都的人
        int count = 0;
        for (User user : list){
            if (user.isFrom("成都")){
                count++;
            }
        }

        //使用迭代器计算来自成都的人
        count=0;
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.isFrom("成都")){
                count++;
            }
        }

        //使用内部迭代计算来自成都的人(流的方式)
        long count1 = list.stream()
                          .filter(user -> user.isFrom("成都"))
                          .count();
        System.out.println(count1);
        //流的实现机制
        //1.只过滤不计数
        /*list.stream()
            .filter(user -> {
                System.out.println(user.getName());
                return user.isFrom("成都");
            });*/
        //2.加上最终方法..及早求值操作
        long count2 = list.stream()
             .filter(user -> {
                 System.out.println(user.getName());
                 return user.isFrom("成都");
             })
             .count();
        System.out.println(count2);
    }

    //找出长度大于一分钟的曲目
    public static Set<String> findLongTracks(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums){
            for (Track track : album.getTracks()){
                if(track.getLength()>60){
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    //重构findLongTracks
    public static Set<String> findLongTracks1(List<Album> albums){
        Set<String > trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .forEach(track -> {
                                if (track.getLength()>60){
                                    String name = track.getName();
                                    trackNames.add(name);
                                }
                            });
                });
        return trackNames;
    }

    //重构findLongTracks2
    public static Set<String> findLongTracks2(List<Album> albums){
        Set<String > trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .stream().filter(track ->
                            track.getLength()>60)
                            .map(track -> track.getName())
                            .forEach(name -> trackNames.add(name));

                });
        return trackNames;
    }

    //重构findLongTracks3
    public static Set<String> findLongTracks3(List<Album> albums){
        Set<String > trackNames = new HashSet<>();
        albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track -> track.getLength()>60)
                .map(track -> track.getName())
                .forEach(name -> trackNames.add(name));
        return trackNames;
    }

    //重构findLongTracks4
    public static Set<String> findLongTracks4(List<Album> albums){
        return albums.stream()
                     .flatMap(album -> album.getTracks().stream())
                     .filter(track -> track.getLength() > 60)
                     .map(track -> track.getName())
                     .collect(Collectors.toSet());
    }

}
