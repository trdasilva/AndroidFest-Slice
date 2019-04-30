package br.com.tomaz.androidfest_slice

import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.util.Log
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

    override fun onMapIntentToUri(intent: Intent): Uri {

        val intentPath = intent?.data?.path ?: "/"
        val uriWithoutPathSlash = intentPath.replace("/", "")

        val uri = buildUriWithAuthority(uriWithoutPathSlash)

        Log.d("SliceProvider", "onMapIntentToUri(): \nintentPath: $intentPath \nuri:$uri")

        return uri
    }

    private fun buildUriWithAuthority(path: String): Uri {
        return Uri.Builder()
            .scheme(ContentResolver.SCHEME_CONTENT)
            .authority(context.packageName)
            .appendPath(path)
            .build()
    }
}
