package br.com.tomaz.androidfest_slice.sliceTemplates

import android.content.Context
import android.net.Uri
import androidx.slice.Slice
import androidx.slice.builders.ListBuilder

class HeaderSliceBuilder {

    companion object {
        fun build(context: Context, sliceUri: Uri): Slice {
            return ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .setHeader {
                    it.title = "Hello world"
                }
                .build()
        }
    }
}