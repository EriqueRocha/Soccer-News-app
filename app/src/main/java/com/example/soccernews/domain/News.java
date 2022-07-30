package com.example.soccernews.domain;

import android.view.View;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {

    @PrimaryKey
    public int id;

    public boolean favorite;
    public String title;
    public String description;
    public String image;
    public String link;
}
