package com.qrusial.wallet.view.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qrusial.wallet.R;

import static android.R.attr.button;


/**
 * Created by Agus Manto on 21/03/2017.
 */

public class Content extends Fragment {

    public Content(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.content_main, container, false);

        Button record = (Button) _view.findViewById(R.id.addRecord);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRecord();
            }
        });

        Button mDashboard = (Button) _view.findViewById(R.id.dashboard);
        mDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dashboard();
            }
        });

        Button mRecord = (Button) _view.findViewById(R.id.record);
        mRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                record();
            }
        });

        Button mChart = (Button) _view.findViewById(R.id.chart);
        mChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chart();
            }
        });

        return _view;
    }

    public void addRecord() {
        Intent intent = new Intent(getActivity(), AddRecord.class);
        startActivity(intent);
    }

    public void dashboard() {
        Intent intent = new Intent(getActivity(), Dashboard.class);
        startActivity(intent);
    }

    public void record() {
        Intent intent = new Intent(getActivity(), Record.class);
        startActivity(intent);
    }

    public void chart() {
        Intent intent = new Intent(getActivity(), Chart.class);
        startActivity(intent);
    }
}
