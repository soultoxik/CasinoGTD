package com.toxik.soul.casinogtd.domain.modules;

import android.view.View;

import com.toxik.soul.casinogtd.domain.managers.BalanceManager;
import com.toxik.soul.casinogtd.presenters.BalancePresenter;
import com.toxik.soul.casinogtd.presenters.impl.BalancePresenterImpl;
import com.toxik.soul.casinogtd.view.MainActivity;
import com.toxik.soul.casinogtd.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by maxim on 04.01.15.
 */
@Module(
        complete = false,
        library = true
)
public class BalanceModule {
    @Provides
    @Singleton
    public View provideView(MainActivity mainActivity) {
        return mainActivity.findViewById(R.id.balanceView);
    }

    @Provides
    @Singleton
    public BalancePresenter provideBalancePresenter(View view, BalanceManager balanceManager) {
        return new BalancePresenterImpl(view, balanceManager);
    }

}
