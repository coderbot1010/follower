package com.coderbot.follower.utils

import android.content.ContentResolver
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import java.io.ByteArrayOutputStream

@Composable
fun gallery(listener: (Uri) -> Unit) = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) {
    listener(it ?: Uri.EMPTY)
}

@Composable
fun camera(contentResolver: ContentResolver = LocalContext.current.contentResolver, listener: (Uri) -> Unit) = rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) {
    if (it != null) listener(getUriFromBitmap(contentResolver, it))
    else listener(Uri.EMPTY)
}

private fun getUriFromBitmap(contentResolver: ContentResolver, image: Bitmap): Uri
{
    val bytes = ByteArrayOutputStream()
    image.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    return Uri.parse(MediaStore.Images.Media.insertImage(contentResolver, image, "Title", null))
}

private fun getUriFromExtra(contentResolver: ContentResolver, image: Bitmap): String
{
    val bytes = ByteArrayOutputStream()
    image.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    return getRealPathFromURI(contentResolver, Uri.parse(MediaStore.Images.Media.insertImage(contentResolver, image, "Title", null)))
}

private fun getRealPathFromURI(contentResolver: ContentResolver, uri: Uri): String
{
    var path = ""
    val cursor = contentResolver.query(uri, null, null, null, null)
    if (cursor != null)
    {
        cursor.moveToFirst()
        val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
        path = cursor.getString(idx)
        cursor.close()
    }
    return path
}