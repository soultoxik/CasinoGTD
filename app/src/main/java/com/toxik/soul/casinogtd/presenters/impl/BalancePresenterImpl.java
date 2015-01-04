package com.toxik.soul.casinogtd.presenters.impl;

import android.view.View;
import android.widget.TextView;

import com.toxik.soul.casinogtd.domain.managers.BalanceManager;
import com.toxik.soul.casinogtd.presenters.BalancePresenter;

/**
 * Created by maxim on 04.01.15.
 */
public class BalancePresenterImpl implements BalancePresenter {
    private TextView balanceView;
    private BalanceManager balanceManager;

    public BalancePresenterImpl(View view, BalanceManager balanceManager) {
        this.balanceManager = balanceManager;
        this.balanceView = (TextView) view;
        setTextBalance();
    }

    @Override
    public void changeBalance(int change) {
        this.balanceManager.changeBalance(change);
        setTextBalance();
    }

    private void setTextBalance() {
        this.balanceView.setText(
                String.valueOf(
                        this.balanceManager.getBalance()));
    }
}
