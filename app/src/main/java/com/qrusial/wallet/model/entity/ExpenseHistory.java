package com.qrusial.wallet.model.entity;

import java.util.ArrayList;

import static com.qrusial.wallet.model.entity.IncomeHistory.arrayRecordIncome;

/**
 * Created by Ferik Enedy on 16/06/2017.
 */

public class ExpenseHistory {
    private String kategori;
    private int expenseNominal;
    public static ArrayList<ExpenseHistory> arrayRecordExpense = new ArrayList<>();

    public ExpenseHistory(){}

    public ExpenseHistory(String kategori, int expenseNominal){
        this.kategori = kategori;
        this.expenseNominal = expenseNominal;

    }

    public String getKategori(){return kategori;}
    public void setKategori(String kategori){this.kategori = kategori;}

    public int getExpenseNominal(){return expenseNominal;}

    public int Tot(){
        int totz = 0;
        for(int i = 0; i < arrayRecordExpense.size();i++){
            totz += arrayRecordExpense.get(i).getExpenseNominal();
        }
        return totz;
    }

}
