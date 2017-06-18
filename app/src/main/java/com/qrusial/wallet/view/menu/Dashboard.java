package com.qrusial.wallet.view.menu;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.ExpenseHistory;
import com.qrusial.wallet.model.entity.IncomeHistory;
import com.qrusial.wallet.model.entity.User;
import com.qrusial.wallet.model.session.SessionManager;

import org.w3c.dom.Text;


/**
 * Created by Ferik Enedy on 01/06/2017.
 */

public class Dashboard extends AppCompatActivity{

    private IncomeHistory incomeHistory;
    private ExpenseHistory expenseHistory;
    public Dashboard(){
        incomeHistory = new IncomeHistory();
        expenseHistory = new ExpenseHistory();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        init();
        event();

    }
    TextView tv_orang;
    TextView tv_money;
    TextView tv_bnykPengeluaran;
    TextView tv_bnykPemasukan;
    public void init(){
        tv_orang = (TextView)findViewById(R.id.namaOrang);
        User userLogined = SessionManager.with(this).getuserloggedin();
        tv_orang.setText(userLogined.getEmail());

        tv_money = (TextView)findViewById(R.id.totalMoney);
        NumberFormat nf = NumberFormat.getInstance();
        DecimalFormat df = (DecimalFormat)nf;
        df.applyPattern(",###");
        tv_money.setText(String.valueOf(df.format(incomeHistory.Totz() - expenseHistory.Tot())));

        tv_bnykPengeluaran = (TextView)findViewById(R.id.exCount);
        tv_bnykPengeluaran.setText(String.valueOf(ExpenseHistory.arrayRecordExpense.size()));

        tv_bnykPemasukan = (TextView)findViewById(R.id.inCount);
        tv_bnykPemasukan.setText(String.valueOf(IncomeHistory.arrayRecordIncome.size()));
    }
    public void event(){
//        int color1 = Integer.parseInt("bdbdbd", 16)+0xFF000000;
        if(tv_money.length()>6){
            tv_money.setTextColor(Color.parseColor("#00ff00"));
        }
        else if (tv_money.length()<5){
            tv_money.setTextColor(Color.parseColor("#0000ff"));
        }

    }
}