package com.cassbana.cashat

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.lokalise.sdk.Lokalise

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        forcePortrait()
        initLokalise()
    }

    private fun forcePortrait() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
    }

    private fun initLokalise() {
        Lokalise.init(
            this,
            getString(R.string.lokalise_sdk_token),
            getString(R.string.lokalise_project_id)
        )
        Lokalise.isPreRelease = true //BuildConfig.ENV_TYPE != EnvType.PROD
        Lokalise.updateTranslations()
    }
}