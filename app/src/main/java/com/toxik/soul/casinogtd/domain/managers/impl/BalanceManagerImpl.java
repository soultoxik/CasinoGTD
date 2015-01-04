package com.toxik.soul.casinogtd.domain.managers.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.toxik.soul.casinogtd.R;
import com.toxik.soul.casinogtd.domain.managers.BalanceManager;

/**
 * Created by maxim on 05.01.15.
 */
public class BalanceManagerImpl implements BalanceManager {
    private SharedPreferences pref;
    private String valString;

    public BalanceManagerImpl(Context context) {
        this.pref = context.getSharedPreferences(
                context.getString(R.string.balance_pref), Context.MODE_PRIVATE);
        this.valString = context.getString(R.string.balance);
    }

    @Override
    public int getBalance() {
        int balance = pref.getInt(valString, 0);
        return balance;
    }

    @Override
    public void changeBalance(int change) {
        SharedPreferences.Editor prefEditor = pref.edit();
        prefEditor.putInt(this.valString, getBalance() + change);
        prefEditor.commit();
    }



}
