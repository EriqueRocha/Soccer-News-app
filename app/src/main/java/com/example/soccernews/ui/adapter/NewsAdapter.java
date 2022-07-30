package com.example.soccernews.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccernews.R;
import com.example.soccernews.databinding.NewsItemBinding;
import com.example.soccernews.domain.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> news;
    private NewsListener favoriteListener;

    public NewsAdapter(List<News> news, NewsListener favoriteListener){
        this.news = news;
        this.favoriteListener = favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Context context = holder.itemView.getContext();
        News news = this.news.get(position);
        holder.binding.textTitle.setText(news.title);
        holder.binding.textDescription.setText(news.description);
        Picasso.get().load(news.image).fit().into(holder.binding.imgThumb);

        //abrindo link

        holder.binding.btnOpenLink.setOnClickListener(view ->{
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(news.link));
            context.startActivity(intent);

        } );
        //compartilhando link da noticia
        holder.binding.imgShare.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, news.link);
            context.startActivity(Intent.createChooser(intent, "compartilhar via:"));

        } );
        //favoritando noticia
        holder.binding.imgFav.setOnClickListener(view -> {
            news.favorite = !news.favorite;
            this.favoriteListener.onClick(news);
            notifyItemChanged(position);
        });

        //mudando a cor do icone fav
        int favoriteColor = news.favorite? R.color.favorited : R.color.fav_default;
            holder.binding.imgFav.setColorFilter(context.getResources().getColor(favoriteColor));

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final NewsItemBinding binding;

        public  ViewHolder(NewsItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

    }
    public interface NewsListener{
        void onClick(News news);
    }

}
