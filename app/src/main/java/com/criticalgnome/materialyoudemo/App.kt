package com.criticalgnome.materialyoudemo

import android.app.Application
import com.google.android.material.color.DynamicColors

class App: Application() {
    override fun onCreate() {
        //  DynamicColors.applyToActivitiesIfAvailable(this)
        // Colors overriding, for example if we need branding colors for some elements
         DynamicColors.applyToActivitiesIfAvailable(this, R.style.MaterialYouDemo_Overlay)
        super.onCreate()
    }
}
