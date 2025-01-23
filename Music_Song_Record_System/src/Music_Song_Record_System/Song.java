/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Song_Record_System;
/**
 *
 * @author ANIL
 * @param <Item>
 */

public class Song<Item> {

    private String songname;
    private String artist;
    private String genre;
    private String id;
    private String year;

    Song(String songname, String artist, String id, String genre, String year) {
        this.songname = songname;
        this.artist = artist;
        this.id = id;
        this.genre = genre;
        this.year = year;
    }

    public String getSongname() {
        return songname;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getId() {
        return id;
    }

    public String getYear() {
        return year;
    }
}

