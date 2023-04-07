package com.example.pokemon.domain.util

object AppMath {
    fun getMinValue(a: Double, b: Double): Double = if(a > b) b else a
}