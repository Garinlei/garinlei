package com.yinhai.leijl.chapter2And3;

import com.yinhai.leijl.Album;
import com.yinhai.leijl.Artist;
import javafx.beans.binding.StringExpression;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 第三章练习题
 */
public class Question3 {

    //求和，最大最小值可以用reduce操作
    public static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0,(acc,elements) -> acc+elements);
    }

    //flatMap操作将多个流转化成一个流
    public static List<String> getNamesAndNation(List<Artist> artists){
      return artists.stream()
                    .flatMap(artist -> Stream.of(artist.getName(),artist.getOrigin()))
                    .collect(Collectors.toList());
    }


    public static List<Album> getAlbum(List<Album> albums){
        return albums.stream()
                     .filter(album -> album.getTracks().size() <= 3)
                     .collect(Collectors.toList());
    }

    //第二题
    public static int getTotalMembers(List<Artist> artists){
        return (int) artists.stream()
                      .flatMap(artist -> artist.getMemebers().stream())
                        .count();
    }

    //第六题
    public static int getCountLowerLeters(String string){
        return (int) string.chars()
                     .filter(Character::isLowerCase)
                     .count();
    }

    //第七题
    public static Optional<String> getMostLowerLeters(List<String> strings){
        return strings.stream()
                      .max(Comparator.comparing(Question3::getCountLowerLeters));
    }

    //进阶练习一
    
}
