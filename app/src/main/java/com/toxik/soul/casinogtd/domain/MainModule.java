package com.toxik.soul.casinogtd.domain;

import com.toxik.soul.casinogtd.domain.modules.BalanceModule;
import com.toxik.soul.casinogtd.domain.modules.ManagersModule;
import com.toxik.soul.casinogtd.view.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by maxim on 04.01.15.
 */
@Module(
        injects = MainActivity.class,
        includes = {
                BalanceModule.class,
                ManagersModule.class
        }
)
public class MainModule {
    private MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    @Provides
    @Singleton
    public MainActivity provideMainActivity() {
        return this.mainActivity;
    }

}
