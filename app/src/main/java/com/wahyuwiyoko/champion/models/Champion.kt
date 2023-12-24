package com.wahyuwiyoko.champion.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Champion(
    val name: String,
    val subtitle: String,
    val avatar: Int,
    val banner: Int,
    val description: String,
    val ability: Int,
    val url: String
) : Parcelable