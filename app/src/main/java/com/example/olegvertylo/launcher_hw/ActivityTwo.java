package com.example.olegvertylo.launcher_hw;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ActivityTwo extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        onClickList(null);

        List<PackageInfo> apps = getPackageManager().getInstalledPackages(0);
        List<String> componentList = new ArrayList<String>();
        String appname = "";
        for (int i =0;i<apps.size();i++){
            PackageInfo p = apps.get(i);
            appname = p.applicationInfo.loadLabel(getPackageManager()).toString();
            componentList.add(appname);
        }
        String []aps = new String[componentList.size()];
        aps = componentList.toArray(aps);
        mAdapter = new SomeAdapter (aps);
        mRecyclerView.setAdapter(mAdapter);


    }

    public void onClickGrid(View view) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public void onClickList(View view) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}
