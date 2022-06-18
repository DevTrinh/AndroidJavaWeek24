package com.example.week24;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


public class FragmentListWithRecycler extends ListFragment {
    ArrayAdapter<? extends String> adapter;
    ArrayList<String> arrListData;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, listData());
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_list_with_recycler,
                container, false);
    }

    public List<String> listData() {
        arrListData = new ArrayList<>();
        arrListData.add("Hà Nội");
        arrListData.add("Thanh Hóa");
        arrListData.add("Hải Phòng");
        arrListData.add("Thái Nguyên");
        arrListData.add("Bắc Ninh");
        arrListData.add("Hà Giang");
        arrListData.add("Hải Dương");
        arrListData.add("Ninh Bình");
        arrListData.add("Bắc Ninh");
        arrListData.add("Nghệ An");
        arrListData.add("Hà Tĩnh");
        arrListData.add("Quảng Bình");
        arrListData.add("Quảng Trị");
        arrListData.add("Huế");
        return arrListData;
    }

    //    hold event
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        DialogByFragment dialog =
                new DialogByFragment(position, arrListData, adapter);
        dialog.show(getFragmentManager(), "DialogDelete");
        super.onListItemClick(l, v, position, id);
    }
}
