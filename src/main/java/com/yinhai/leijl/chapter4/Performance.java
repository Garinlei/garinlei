package com.yinhai.leijl.chapter4;

import com.yinhai.leijl.Artist;

import java.util.stream.Stream;

public interface Performance {

        String getName();

        Stream<Artist> getMusicians();

        //使用Stream.concat连接流
        default Stream<Artist> getAllMusicians(){
            return getMusicians()
                    .flatMap(artist -> Stream.concat(Stream.of(artist),artist.getMemebers().stream()));
        }
}
