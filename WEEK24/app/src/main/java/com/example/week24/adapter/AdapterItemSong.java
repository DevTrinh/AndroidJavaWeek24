//package com.example.week24.adapter;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.week24.R;
//import com.example.week24.item.ItemSongMusic;
//
//import java.util.List;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//public class AdapterItemSong extends RecyclerView.Adapter<AdapterItemSong.ItemSongViewHolder> {
//
//    private List<ItemSongMusic> listSong;
//    private final Context context;
//
//    public AdapterItemSong(Context context) {
//        this.context = context;
//    }
//
//    public void setData(List<ItemSongMusic> listSong) {
//        this.listSong = listSong;
//        notifyDataSetChanged();
//    }
//
//
//    @NonNull
//    @Override
//    public ItemSongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_song_music, parent, false);
//        return new ItemSongViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ItemSongViewHolder holder, int position) {
//        ItemSongMusic itemSongMusic = listSong.get(position);
//        if (itemSongMusic == null) {
//            return;
//        }
//        holder.tvMusician.setText(listSong.get(position).getNameMusician());
//        holder.tvSong.setText(listSong.get(position).getNameSong());
//        holder.ivSong.setImageResource(listSong.get(position).getAvtSong());
//    }
//
//    @Override
//    public int getItemCount() {
//        if (listSong != null) {
//            return listSong.size();
//        }
//        return 0;
//    }
//
//    public static class ItemSongViewHolder extends RecyclerView.ViewHolder {
//
//        private final CircleImageView ivSong;
//        private final TextView tvSong;
//        private final TextView tvMusician;
//
//        @SuppressLint("CutPasteId")
//        public ItemSongViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ivSong = itemView.findViewById(R.id.ci_avt_item_list_song);
//            tvMusician = itemView.findViewById(R.id.tv_name_musician_list);
//            tvSong = itemView.findViewById(R.id.tv_name_musician_list);
//        }
//
//    }
//}