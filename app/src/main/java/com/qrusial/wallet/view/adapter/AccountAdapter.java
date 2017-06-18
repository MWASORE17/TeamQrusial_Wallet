package com.qrusial.wallet.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agus Manto on 28/05/2017.
 */

public class AccountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Account> accounts;
    public List<Account> getUsers() {
        return accounts;
    }
    public void setUsers(List<Account> users) {
        this.accounts = accounts;
    }

    public AccountAdapter() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dashboard, parent, false);
        return new ItemUserViewHolder(_view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemUserViewHolder _holder = (ItemUserViewHolder) holder;
        final Account _account = this.accounts.get(position);
        _holder.account.setText(_account.getAccount());
        _holder.value.setText(_account.getValue());
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    private class ItemUserViewHolder extends RecyclerView.ViewHolder {
        private TextView account, value;

        public ItemUserViewHolder(View itemView) {
            super(itemView);
        }
    }
}
