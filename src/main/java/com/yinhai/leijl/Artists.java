package com.yinhai.leijl;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }


    public Optional<Artist> getArtist(int index){
        if(index < 0 || index >= artists.size()){
            //返回一个空的Optional对象
            return Optional.empty();
        }
        //返回一个Optional对象
        return Optional.of(artists.get(index));
    }

    /*public Optional<String> getArtistName(int index){
        if (index < 0 || index >= artists.size()){
            return (Optional<String>) Optional.empty().orElse("unknown");
        }
        return Optional.of(artists.get(index).getName());
    }*/

    public String getArtistName(int index){
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName).orElse("unknown");
    }
}
