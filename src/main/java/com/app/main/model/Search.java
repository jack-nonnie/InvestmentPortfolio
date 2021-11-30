package com.app.main.model;

public class Search {
    private String str;
    public Search(){
        this.str = "";
    }
    public Search(String str){
        this.str = str;
    }
    public String getStr(){
        return this.str;
    }
    public void setStr(String str){
        this.str = str;
    }
}
