package com.example.projectakhirintann

import android.app.Application
import android.app.usage.UsageEvents.Event.NONE
import com.example.projectakhirintann.core.di.networkModule
import com.example.projectakhirintann.core.di.repositoryModule
import com.example.projectakhirintann.di.useCaseModule
import com.example.projectakhirintann.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.logging.Level

class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(org.koin.core.logger.Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}