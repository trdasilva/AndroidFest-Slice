package br.com.tomaz.androidfest_slice

import android.net.Uri
import androidx.slice.Slice
import androidx.slice.SliceProvider
import br.com.tomaz.androidfest_slice.sliceTemplates.*

class SliceProviderExample : SliceProvider() {

    override fun onCreateSliceProvider(): Boolean {
        return true
    }

    /**
     * Construct the Slice and bind data if available.
     */
    override fun onBindSlice(sliceUri: Uri): Slice? {
        val context = context ?: return null
        return when {
            sliceUri.path == "/headerSlice" -> HeaderSliceBuilder.build(context, sliceUri)
            sliceUri.path == "/rowSlice" -> RowSliceBuilder.build(context, sliceUri)
            sliceUri.path == "/gridSlice" -> GridSliceBuilder.build(context, sliceUri)
            sliceUri.path == "/delayedSlice" -> ContentDelayedSliceBuilder.build(context, sliceUri)
            else -> ErrorSliceBuilder.build(context, sliceUri)
        }
    }
}
