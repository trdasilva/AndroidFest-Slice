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

class RowSliceBuilder {

    companion object {
        fun build(context: Context, sliceUri: Uri): androidx.slice.Slice {
            return ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .setHeader {
                    it.title = "Slice with row"
                }
                .addRow {
                    it.title = "Our first row"
                    it.setTitleItem(createActivityAction(context, R.drawable.ic_list_black_48dp))
                    it.addEndItem(createActivityAction(context, R.drawable.ic_assignment_returned_black_48dp))
                    it.addEndItem(createActivityAction(context, R.drawable.ic_assignment_turned_in_black_48dp))
                }.build()
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