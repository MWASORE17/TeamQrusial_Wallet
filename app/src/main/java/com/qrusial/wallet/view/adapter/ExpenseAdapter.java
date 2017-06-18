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
import com.qrusial.wallet.model.entity.ExpenseHistory;

import java.util.ArrayList;

/**
 * Created by Ferik Enedy on 06/17/2017.
 */

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.SingleItemRowHolder> {

    private Context context;
    private ArrayList<ExpenseHistory>expenseHistoryArrayList;
    public ExpenseAdapter(Context context, ArrayList<ExpenseHistory> expenseHistoryArrayList) {
        this.context = context;
        this.expenseHistoryArrayList = expenseHistoryArrayList;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_expense, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, final int i) {
        NumberFormat nf = NumberFormat.getInstance();
        DecimalFormat df = (DecimalFormat)nf;
        df.applyPattern(",###");
        holder.tv_expense.setText(String.valueOf("- IDR. " + df.format(expenseHistoryArrayList.get(i).getExpenseNominal())));
        holder.tv_category.setText(expenseHistoryArrayList.get(i).getKategori());
    }


    @Override
    public int getItemCount() {
        return (null != expenseHistoryArrayList ? expenseHistoryArrayList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tv_expense;
        protected TextView tv_category;


        public SingleItemRowHolder(View view) {
            super(view);
            this.tv_expense = (TextView) view.findViewById(R.id.tv_expense);
            this.tv_category = (TextView) view.findViewById(R.id.tv_expenseKategori);
        }

    }
}


