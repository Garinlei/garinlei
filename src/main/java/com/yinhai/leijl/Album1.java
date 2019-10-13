package com.yinhai.leijl;

import java.util.stream.Stream;

public class Album1 {

    private User artist;

    private String nationality;

    public Album1(User artist, String nationality) {
        this.artist = artist;
        this.nationality = nationality;
    }

    public User getArtist() {
        return artist;
    }

    public void setArtist(User artist) {
        this.artist = artist;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Stream<User> getMusicians(){
        return Stream.of(this.artist);
    }
}
