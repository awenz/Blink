package com.example.blink;

public class ListItem {
  private long id;
  private String name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getname() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
  }

  // Will be used by the ArrayAdapter in the ListView
  @Override
  public String toString() {
    return name;
  }
}
