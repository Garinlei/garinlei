package com.yinhai.leijl;

/**
 * 专辑中的一首歌
 */
public class Track {

    private String name;

    private Integer length;



    public Track(String name,Integer length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
