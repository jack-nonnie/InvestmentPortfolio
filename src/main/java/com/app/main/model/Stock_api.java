package com.app.main.model;

import java.io.Serializable;

public class Stock_api{ 
  private String o;
  private String h;
  private String l;
  private String c;
  private String pc;
  private String d;
  private String dp;
  private String t;
  public Stock_api(String o, String h, String l, String c, String pc, String d, String dp, String t){
    this.o = o;
    this.h = h;
    this.l = l;
    this.c = c;
    this.pc = pc;
    this.d = d;
    this.dp = dp;
    this.t = t;
  }
  public Stock_api(String open, String high, String low, String current, String prev) {
    this.o = open;
    this.h = high;
    this.l = low;
    this.c = current;
    this.pc = prev;

  }
  public void setD(String d){
    this.d = d;
  }
  public void setDp(String dp){
    this.dp = dp;
  }
  public void setT(String t){
    this.t = t;
  }
  public void setPc(String prev) {
    this.pc = prev;
  }

  public void setC(String current) {
    this.c = current;
  }

  public void setL(String low) {
    this.l = low;
  }

  public void setH(String high) {
    this.h = high;
  }

  public void setO(String open) {
    this.o = open;
  }

  public void setPrices(String open, String high, String low, String current, String prev) {
    this.o = open;
    this.h = high;
    this.l = low;
    this.c = current;
    this.pc = prev;
  }

  public String getO() {
    return this.o;
  }
  public String getT(){
    return this.t;
  }
  public String getD(){
    return this.d;
  }
  public String getDp(){
    return this.dp;
  }

  public String getH() {
    return this.h;
  }

  public String getL() {
    return this.l;
  }

  public String getC() {
    return this.c;
  }

  public String getPc() {
    return this.pc;
  }

  @Override
  public String toString() {
    return "Opening Price: " + o + " Daily High Price: " + this.h + " Daily Low Price " + this.l
        + " Current Price: " + this.c + " Yesterday Closing Price: " + this.pc;
  }

  /*
   * @Override
   * public boolean equals(Object other) {
   * if (other instanceof Stock_api) {
   * Stock_api o = (Stock_api) other;
   * if (this.ticker.equals(o.ticker)) {
   * return true;
   * }
   * }
   * return false;
   * }
   */
}