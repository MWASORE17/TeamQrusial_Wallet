package com.qrusial.wallet.view.adapter;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.IncomeHistory;

import java.util.ArrayList;

/**
 * Created by Ferik Enedy on 06/17/2017.
 */

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.SingleItemRowHolder> {

    private Context context;
    private ArrayList<IncomeHistory>incomeHistoryArrayList;
    public IncomeAdapter(Context context, ArrayList<IncomeHistory> incomeHistoryArrayList) {
        this.context = context;
        this.incomeHistoryArrayList = incomeHistoryArrayList;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_income, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, final int i) {
        NumberFormat nf = NumberFormat.getInstance();
        DecimalFormat df = (DecimalFormat)nf;
        df.applyPattern(",###");
        holder.tv_income.setText(String.valueOf("IDR. " + df.format(incomeHistoryArrayList.get(i).getIncomeNominal())));
        holder.tv_category.setText(incomeHistoryArrayList.get(i).getKategori());
    }


    @Override
    public int getItemCount() {
        return (null != incomeHistoryArrayList? incomeHistoryArrayList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tv_income;
        protected TextView tv_category;


        public SingleItemRowHolder(View view) {
            super(view);
            this.tv_income = (TextView) view.findViewById(R.id.tv_income);
            this.tv_category = (TextView) view.findViewById(R.id.tv_incomeKategori);
        }

    }
}