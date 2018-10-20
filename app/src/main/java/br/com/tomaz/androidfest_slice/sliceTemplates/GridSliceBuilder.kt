package br.com.tomaz.androidfest_slice.sliceTemplates

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.builders.ListBuilder
import androidx.slice.builders.SliceAction
import androidx.slice.core.SliceHints
import br.com.tomaz.androidfest_slice.MainActivity
import br.com.tomaz.androidfest_slice.R

class GridSliceBuilder {

    companion object {
        fun build(context: Context, sliceUri: Uri): androidx.slice.Slice {
            return ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .setHeader {
                    it.title = "Nearby parks"
                }
                .addGridRow { grid ->
                    grid.addCell {
                        it.addImage(IconCompat.createWithResource(context, R.drawable.place1), SliceHints.LARGE_IMAGE)
                        it.addTitleText("500m")
                        it.contentIntent = createContentIntent(context)
                    }
                    grid.addCell {
                        it.addImage(IconCompat.createWithResource(context, R.drawable.place2), SliceHints.LARGE_IMAGE)
                        it.addTitleText("850m")
                        it.contentIntent = createContentIntent(context)
                    }
                    grid.addCell {
                        it.addImage(IconCompat.createWithResource(context, R.drawable.place3), SliceHints.LARGE_IMAGE)
                        it.addTitleText("3km")
                        it.contentIntent = createContentIntent(context)
                    }
                    grid.primaryAction = createActivityAction(context,R.drawable.ic_launcher_foreground)

                }
                .build()
        }

        private fun createContentIntent(context: Context): PendingIntent {
            return PendingIntent.getActivity(
                context, 0, Intent(context, MainActivity::class.java), 0
            )
        }

        private fun createActivityAction(context: Context, iconId: Int): SliceAction {
            return SliceAction.create(
                PendingIntent.getActivity(
                    context, 0, Intent(context, MainActivity::class.java), 0
                ),
                IconCompat.createWithResource(context, iconId),
                ListBuilder.ICON_IMAGE,
                "Open App"
            )
        }
    }
}