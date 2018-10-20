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

class ErrorSliceBuilder {

    companion object {
        fun build(context: Context, sliceUri: Uri): androidx.slice.Slice {
            return ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .addRow(
                    ListBuilder.RowBuilder()
                        .setTitle("URI found.")
                        .setPrimaryAction(createActivityAction(context))
                )
                .build()
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