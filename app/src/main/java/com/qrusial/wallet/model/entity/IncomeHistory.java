package com.qrusial.wallet.model.entity;

import java.util.ArrayList;

/**
 * Created by Agus Manto on 06/06/2017.
 */


public class IncomeHistory {
    private String kategoriIncome;
    private int incomeNominal;
    public static ArrayList<IncomeHistory> arrayRecordIncome = new ArrayList<>();

    public IncomeHistory(){}

    public IncomeHistory(String kategoriIncome, int incomeNominal){
        this.kategoriIncome = kategoriIncome;
        this.incomeNominal = incomeNominal;

    }

    public String getKategori(){return kategoriIncome;}
    public void setKategori(String kategori){this.kategoriIncome = kategoriIncome;}

    public int getIncomeNominal(){return incomeNominal;}

    public int Totz(){
        int totz = 0;
        for(int i = 0; i < arrayRecordIncome.size();i++){
            totz += arrayRecordIncome.get(i).getIncomeNominal();
        }
        return totz;
    }
}
