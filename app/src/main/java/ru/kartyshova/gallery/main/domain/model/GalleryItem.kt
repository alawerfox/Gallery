package ru.kartyshova.gallery.main.domain.model

import com.google.gson.annotations.SerializedName

data class GalleryItem(
     @SerializedName("id")
     val imageId: String,

    @SerializedName("title")
    val imageTitle: String,

     @SerializedName("content")
     val imageContent: String,

     @SerializedName("photoUrl")
     val photoUrl: String,

     @SerializedName("publicationDate")
     val publicationDate: Long

     )