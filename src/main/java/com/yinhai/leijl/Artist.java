package com.yinhai.leijl;

import java.util.List;

public class Artist {

    private String name;

    private List<Artist> memebers;


    private String origin;

    public Artist(String name, List<Artist> memebers, String origin) {
        this.name = name;
        this.memebers = memebers;
        this.origin = origin;
    }

    //是否是solo
    public Boolean isSolo(){
        if(this.getMemebers().size() == 0){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artist> getMemebers() {
        return memebers;
    }

    public void setMemebers(List<Artist> memebers) {
        this.memebers = memebers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


}
