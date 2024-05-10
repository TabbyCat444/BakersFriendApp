package com.example.thebakersfriend

class MainRepository {

    private val conversions = mapOf(
        // Dry Units
        Unit.DRY_CUP to mapOf(Unit.TABLESPOON to 16.0, Unit.TEASPOON to 48.0),
        Unit.TABLESPOON to mapOf(Unit.DRY_CUP to 0.0625, Unit.TEASPOON to 3.0),
        Unit.TEASPOON to mapOf(Unit.DRY_CUP to 0.0208333, Unit.TABLESPOON to 0.333),

        // Wet Units
        Unit.GALLON to mapOf(Unit.QUART to 4.0, Unit.PINT to 8.0, Unit.WET_CUP to 16.0, Unit.FLUID_OUNCE to 128.0),
        Unit.QUART to mapOf(Unit.GALLON to 0.25, Unit.PINT to 2.0, Unit.WET_CUP to 4.0, Unit.FLUID_OUNCE to 32.0),
        Unit.PINT to mapOf(Unit.GALLON to 0.125, Unit.QUART to 0.5, Unit.WET_CUP to 2.0, Unit.FLUID_OUNCE to 16.0),
        Unit.WET_CUP to mapOf(Unit.GALLON to 0.0625, Unit.QUART to 0.25, Unit.PINT to 0.5, Unit.FLUID_OUNCE to 8.0),
        Unit.FLUID_OUNCE to mapOf(
            Unit.GALLON to 0.0078125,
            Unit.QUART to 0.03125,
            Unit.PINT to 0.0625,
            Unit.WET_CUP to 0.125
        ),
    )

    fun convertUnit(value: Double, fromUnit: Unit, toUnit: Unit): Double {
        val conversionFactor =
            (conversions[fromUnit] as Map<Unit, Double>)[toUnit] ?: throw IllegalArgumentException()

        return value * conversionFactor

    }
}