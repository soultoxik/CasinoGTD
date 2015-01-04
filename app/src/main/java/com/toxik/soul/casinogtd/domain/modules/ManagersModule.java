package com.toxik.soul.casinogtd.domain.modules;

import com.toxik.soul.casinogtd.domain.managers.BalanceManager;
import com.toxik.soul.casinogtd.domain.managers.impl.BalanceManagerImpl;
import com.toxik.soul.casinogtd.view.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by maxim on 05.01.15.
 */
@Module(
        library = true,
        complete = false
)
public class ManagersModule {
    @Provides
    @Singleton
    public BalanceManager provideBalanceManager(MainActivity mainActivity) {
        return new BalanceManagerImpl(mainActivity.getApplicationContext());
    }

}
