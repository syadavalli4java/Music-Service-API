package com.java.music.model;

import java.util.ArrayList;
import java.util.List;
public class Results
{
    private String country;

    private List<String> genre;

    private List<String> format;

    private List<String> style;

    private int id;

    private List<String> label;

    private String type;

    private List<String> barcode;

    private int master_id;

    private String master_url;

    private String uri;

    private String catno;

    private String title;

    private String thumb;

    private String cover_image;

    private String resource_url;

    private Community community;

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setGenre(List<String> genre){
        this.genre = genre;
    }
    public List<String> getGenre(){
        return this.genre;
    }
    public void setFormat(List<String> format){
        this.format = format;
    }
    public List<String> getFormat(){
        return this.format;
    }
    public void setStyle(List<String> style){
        this.style = style;
    }
    public List<String> getStyle(){
        return this.style;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setLabel(List<String> label){
        this.label = label;
    }
    public List<String> getLabel(){
        return this.label;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setBarcode(List<String> barcode){
        this.barcode = barcode;
    }
    public List<String> getBarcode(){
        return this.barcode;
    }
    public void setMaster_id(int master_id){
        this.master_id = master_id;
    }
    public int getMaster_id(){
        return this.master_id;
    }
    public void setMaster_url(String master_url){
        this.master_url = master_url;
    }
    public String getMaster_url(){
        return this.master_url;
    }
    public void setUri(String uri){
        this.uri = uri;
    }
    public String getUri(){
        return this.uri;
    }
    public void setCatno(String catno){
        this.catno = catno;
    }
    public String getCatno(){
        return this.catno;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setThumb(String thumb){
        this.thumb = thumb;
    }
    public String getThumb(){
        return this.thumb;
    }
    public void setCover_image(String cover_image){
        this.cover_image = cover_image;
    }
    public String getCover_image(){
        return this.cover_image;
    }
    public void setResource_url(String resource_url){
        this.resource_url = resource_url;
    }
    public String getResource_url(){
        return this.resource_url;
    }
    public void setCommunity(Community community){
        this.community = community;
    }
    public Community getCommunity(){
        return this.community;
    }
}
