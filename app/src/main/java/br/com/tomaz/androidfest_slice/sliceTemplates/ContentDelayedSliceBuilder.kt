package br.com.tomaz.androidfest_slice.sliceTemplates

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.builders.ListBuilder
import androidx.slice.builders.SliceAction
import br.com.tomaz.androidfest_slice.MainActivity
import br.com.tomaz.androidfest_slice.R
import java.util.*
import kotlin.concurrent.schedule

class ContentDelayedSliceBuilder {

    companion object {
        private lateinit var updateSliceUri: Uri
        private var titleText = "Loading data"

        fun build(context: Context, sliceUri: Uri): androidx.slice.Slice {
            updateSliceUri = sliceUri
            Timer("SettingUp", false).schedule(2000) { updateSliceContent(context) }
            return ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .setHeader {
                    it.title = "Content Delayed Slice"
                }
                .addRow {
                    it.title = titleText
                    it.primaryAction = createActivityAction(context)
                }.build()
        }

        private fun updateSliceContent(context: Context) {
            titleText = "Updated!"
            context.contentResolver.notifyChange(updateSliceUri, null)
        }

        private fun createActivityAction(context: Context): SliceAction {
            return SliceAction.create(
                PendingIntent.getActivity(
                    context, 0, Intent(context, MainActivity::class.java), 0
                ),
                IconCompat.createWithResource(context, R.drawable.ic_launcher_foreground),
                ListBuilder.ICON_IMAGE,
                "Open App"
            )
        }
    }
}