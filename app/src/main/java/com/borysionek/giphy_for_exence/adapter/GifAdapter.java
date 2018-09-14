package com.borysionek.giphy_for_exence.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.borysionek.giphy_for_exence.R;
import com.borysionek.giphy_for_exence.models.GiphyResult;
import com.bumptech.glide.Glide;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class GifAdapter extends RecyclerView.Adapter<GifAdapter.GifHolder> {

    private GiphyResult gifList;
    private Context context;

    public GifAdapter(GiphyResult gifList, Context context) {
        this.gifList = gifList;
        this.context = context;
    }

    @NonNull
    @Override
    public GifAdapter.GifHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_gif, parent, false);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                StyleableToast.makeText(context, context.getString(R.string.click_to_like), R.style.normalToast).show();
            }
        });
        v.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(final View view) {
                //TODO ADD TO FAVOURITES
                return false;
            }
        });
        return new GifHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final GifAdapter.GifHolder holder, final int position) {
        holder.tvTitle.setText(gifList.getData().get(position).getTitle());
        holder.tvAuthor.setText(gifList.getData().get(position).getUser().getDisplayName());
        holder.tvUrl.setText(gifList.getData().get(position).getUrl());
        Glide.with(context).load(gifList.getData().get(position).getImages().getOriginal().getUrl()).into(holder.ivGif);
    }

    @Override
    public int getItemCount() {
        return gifList.getData().size();
    }

    class GifHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvAuthor, tvUrl;
        ImageView ivGif;

        GifHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvAuthor = v.findViewById(R.id.tvAuthor);
            tvUrl = v.findViewById(R.id.tvUrl);
            ivGif = v.findViewById(R.id.ivGif);
        }
    }
}
