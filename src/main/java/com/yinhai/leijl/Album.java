package com.yinhai.leijl;

import java.util.List;

/**
 * 专辑
 */
public class Album {


    private String name;

    private List<Track> tracks;

    private List<Artist> musicians;

    private Artist mainmusicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        this.name = name;
        this.tracks = tracks;
        this.musicians = musicians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return this.musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }

    public Artist getMainMusician(){
    	return mainmusicians;
	}

	public void setMainmusicians(Artist mainmusicians) {
		this.mainmusicians = mainmusicians;
	}
}
