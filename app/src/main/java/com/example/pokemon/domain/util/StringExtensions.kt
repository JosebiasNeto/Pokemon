package com.example.pokemon.domain.util

fun String.capitalizeEveryFirstChar() : String {
    var result = ""
    if (this != " " && this.isNotEmpty()) for(i in this.indices){
        if(i == 0) result = this.substring(0, 0) + this[i].uppercase() + this.substring(1)
        else if(i == this.length - 2) break
        else if(this[i].toString() == " ") result = result.substring(0, i+1) + this[i+1].uppercase() + result.substring(i+2)
    }
    return result
}