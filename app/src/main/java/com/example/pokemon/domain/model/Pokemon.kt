package com.example.pokemon.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    var id: Int = -1,
    var name: String = "",
    var experience: Int = -1,
    var height: Int = -1,
    var weight: Int = -1,
    var type: String = "",
    var hpStat: Int = -1,
    var attackStat: Int = -1,
    var defenseStat: Int = -1,
    var image: String = ""
) : Parcelable
