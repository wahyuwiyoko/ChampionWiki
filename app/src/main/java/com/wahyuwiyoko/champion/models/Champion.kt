package com.wahyuwiyoko.champion.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Champion(
    val name: String,
    val subtitle: String,
    val avatar: Int
) : Parcelable