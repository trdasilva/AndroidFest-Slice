package br.com.tomaz.androidfest_slice

import android.app.Application
import android.net.Uri
import androidx.slice.SliceManager

class SliceApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SliceManager.getInstance(this)
            .grantSlicePermission(
                "com.google.android.googlequicksearchbox",
                Uri.parse("content://br.com.tomaz.androidfest_slice")
            )

        SliceManager.getInstance(this)
            .grantSlicePermission(
                "com.google.android.gms",
                Uri.parse("content://br.com.tomaz.androidfest_slice")
            )
    }
}