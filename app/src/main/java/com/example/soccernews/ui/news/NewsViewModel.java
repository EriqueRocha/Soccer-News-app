package com.example.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soccernews.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        news = new MutableLiveData<>();
        List<News> news = new ArrayList<>();
        news.add(new News("Noticia teste", "teste de descrição: kdhgfsidjhfao asfoasfaos sufvsfgsdg sg sfg s  shg s"));
        news.add(new News("Noticia teste", "teste de descrição: kdhgfsidjhfao asfoasfaos sufvsfgsdg sg sfg s  shg s"));
        news.add(new News("Noticia teste", "teste de descrição: kdhgfsidjhfao asfoasfaos sufvsfgsdg sg sfg s  shg s"));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}