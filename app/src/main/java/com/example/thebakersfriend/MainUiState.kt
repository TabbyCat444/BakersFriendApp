package com.example.thebakersfriend

data class MainUiState(
    val dryInput: Double = 0.0,
    val dryOutput: Double = 0.0,
    val dryLeft: Unit = Unit.DRY_CUP,
    val dryRight: Unit = Unit.TEASPOON,

    val wetInput: Double = 0.0,
    val wetOutput: Double = 0.0,
    val wetLeft: Unit = Unit.GALLON,
    val wetRight: Unit = Unit.QUART

)