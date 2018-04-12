package io.com.zenotirecyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.btn_next)
    Button next;
    private ArrayList<String> data = new ArrayList<>();
    AdapterExample adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupViews();

        List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.list));
        data.addAll(Lines);
        adapter.notifyDataSetChanged(); // here i am just notifying the data I am not sending latest data to Adapter

    }

    private void setupViews() {

        adapter = new AdapterExample(data, R.layout.item_example );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false));
    }

    @OnClick(R.id.btn_next)
    void onNextClicked(){
        List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.updated_list));
        data.addAll(Lines);
        adapter.notifyDataSetChanged();

    }
}
