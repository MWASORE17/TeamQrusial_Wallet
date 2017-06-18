package com.qrusial.wallet.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.ExpenseHistory;
import com.qrusial.wallet.view.adapter.ExpenseAdapter;

/**
 * Created by Ferik Enedy on 01/06/2017.
 */

public class ExpenseFragment extends Fragment {

    private RecyclerView recycleView;
    private ExpenseAdapter adapter;

    public ExpenseFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_expense, container,false);
        showListExpense(_view);

        return _view;
    }

    public void showListExpense(View view){
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView);

        adapter = new ExpenseAdapter(getActivity(),ExpenseHistory.arrayRecordExpense);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.setNestedScrollingEnabled(false);
        recycleView.setHasFixedSize(true);
        recycleView.setAdapter(adapter);
    }
}
