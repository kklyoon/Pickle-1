package com.charlezz.pickle

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.charlezz.pickle.fragments.detail.PickleDetailFragment
import com.charlezz.pickle.fragments.detail.PickleDetailFragmentModule
import com.charlezz.pickle.fragments.main.PickleFragment
import com.charlezz.pickle.fragments.main.PickleFragmentModule
import com.charlezz.pickle.util.PickleConstants
import com.charlezz.pickle.util.dagger.FragmentScope
import com.charlezz.pickle.util.dagger.InjectingSavedStateViewModelFactory
import com.charlezz.pickle.util.dagger.PickleScope
import com.charlezz.pickle.util.dagger.SharedViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class PickleModule {

    @Binds
    @PickleScope
    abstract fun bindsContext(activity: PickleActivity): Context

    companion object {

        @Provides
        fun provideApplication(activity: PickleActivity): Application {
            return activity.application
        }

        @Provides
        @PickleScope
        @SharedViewModelProvider
        fun provideViewModelProvider(
            activity: PickleActivity,
            factory: InjectingSavedStateViewModelFactory
        ): ViewModelProvider {
            return ViewModelProvider(activity, factory.create(activity))
        }

        @Provides
        @PickleScope
        fun provideConfig(activity:PickleActivity): Config {
            return activity.intent.getParcelableExtra(PickleConstants.KEY_CONFIG)?:Config.default
        }

    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [PickleFragmentModule::class])
    abstract fun bindsPickleFragment(): PickleFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PickleDetailFragmentModule::class])
    abstract fun bindsPickleDetailFragment():PickleDetailFragment
}
