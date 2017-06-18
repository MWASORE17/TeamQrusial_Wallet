package com.qrusial.wallet.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.IncomeHistory;
import com.qrusial.wallet.view.adapter.IncomeAdapter;

/**
 * Created by Ferik Enedy on 01/06/2017.
 */

public class IncomeFragment extends Fragment {

    private RecyclerView irecycleView;
    private IncomeAdapter adapter;

    public IncomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_income, container, false);
        showListIncome(_view);

        return _view;
    }

    public void showListIncome(View view) {
        irecycleView = (RecyclerView) view.findViewById(R.id.irecycleview);
        adapter = new IncomeAdapter(getActivity(), IncomeHistory.arrayRecordIncome);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        irecycleView.setLayoutManager(linearLayoutManager);
        irecycleView.setNestedScrollingEnabled(false);
        irecycleView.setHasFixedSize(true);
        irecycleView.setAdapter(adapter);


    }
}