package com.example.soccernews.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.soccernews.domain.News;

import java.util.List;


@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(News news); //save é a variável q indica o termo para salvar no DB

    @Query("SELECT * FROM news WHERE favorite = 1") //busca os favoritos
    LiveData<List<News>> loadFavoriteNews(); //método assincrono


}
