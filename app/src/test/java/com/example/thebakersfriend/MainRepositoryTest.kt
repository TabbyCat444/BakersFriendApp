package com.example.thebakersfriend

import org.junit.Assert.assertEquals
import org.junit.Test

class MainRepositoryTest {
    private val repository: MainRepository = MainRepository()

    // ~~~ DRY CONVERSIONS ~~~ //
    // Dry Cup conversions
    @Test
    fun testConvertCupsToTablespoons() {
        val value = 1.0
        val fromUnit = Unit.DRY_CUP
        val toUnit = Unit.TABLESPOON

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(16.0, convertedValue, 0.001)

        println("$value Cup(s) = $convertedValue Tablespoon(s).")
    }

    @Test
    fun testConvertCupsToTeaspoons() {
        val value = 1.0
        val fromUnit = Unit.DRY_CUP
        val toUnit = Unit.TEASPOON

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(48.0, convertedValue, 0.001)

        println("$value Cup(s) = $convertedValue Teaspoon(s).")
    }

    // Tablespoon conversions
    @Test
    fun testConvertTablespoonsToCups() {
        val value = 16.0
        val fromUnit = Unit.TABLESPOON
        val toUnit = Unit.DRY_CUP

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Tablespoon(s) = $convertedValue Cup(s).")
    }

    @Test
    fun testConvertTablespoonsToTeaspoons() {
        val value = 1.0
        val fromUnit = Unit.TABLESPOON
        val toUnit = Unit.TEASPOON

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(3.0, convertedValue, 0.001)

        println("$value Tablespoon(s) = $convertedValue Teaspoon(s).")
    }

    // Teaspoon conversions
    @Test
    fun testConvertTeaspoonsToCups() {
        val value = 48.0
        val fromUnit = Unit.TEASPOON
        val toUnit = Unit.DRY_CUP

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Teaspoon(s) = $convertedValue Cup(s).")
    }

    @Test
    fun testConvertTeaspoonsToTablespoons() {
        val value = 3.0
        val fromUnit = Unit.TEASPOON
        val toUnit = Unit.TABLESPOON

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Teaspoon(s) = $convertedValue Tablespoon(s).")
    }

    // ~~~ WET CONVERSIONS ~~~ //
    // Gallon conversions
    @Test
    fun testConvertGallonsToQuarts() {
        val value = 1.0
        val fromUnit = Unit.GALLON
        val toUnit = Unit.QUART

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(4.0, convertedValue, 0.001)

        println("$value Gallon(s) = $convertedValue Quart(s).")
    }

    @Test
    fun testConvertGallonsToPints() {
        val value = 1.0
        val fromUnit = Unit.GALLON
        val toUnit = Unit.PINT

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(8.0, convertedValue, 0.001)

        println("$value Gallon(s) = $convertedValue Pint(s).")
    }

    @Test
    fun testConvertGallonsToCups() {
        val value = 1.0
        val fromUnit = Unit.GALLON
        val toUnit = Unit.WET_CUP

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(16.0, convertedValue, 0.001)

        println("$value Gallon(s) = $convertedValue Cup(s).")
    }

    @Test
    fun testConvertGallonsToFluidOunces() {
        val value = 1.0
        val fromUnit = Unit.GALLON
        val toUnit = Unit.FLUID_OUNCE

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(128.0, convertedValue, 0.001)

        println("$value Gallon(s) = $convertedValue Fluid Ounce(s).")
    }

    // Quart Conversions
    @Test
    fun testConvertQuartsToGallons() {
        val value = 4.0
        val fromUnit = Unit.QUART
        val toUnit = Unit.GALLON

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Quart(s) = $convertedValue Gallon(s).")
    }

    @Test
    fun testConvertQuartsToPints() {
        val value = 1.0
        val fromUnit = Unit.QUART
        val toUnit = Unit.PINT

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(2.0, convertedValue, 0.001)

        println("$value Quart(s) = $convertedValue Pint(s).")
    }

    @Test
    fun testConvertQuartsToCups() {
        val value = 1.0
        val fromUnit = Unit.QUART
        val toUnit = Unit.WET_CUP

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(4.0, convertedValue, 0.001)

        println("$value Quart(s) = $convertedValue Cup(s).")
    }

    @Test
    fun testConvertQuartsToFluidOunces() {
        val value = 1.0
        val fromUnit = Unit.QUART
        val toUnit = Unit.FLUID_OUNCE

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(32.0, convertedValue, 0.001)

        println("$value Quart(s) = $convertedValue Fluid Ounce(s).")
    }

    // Pint Conversions
    @Test
    fun testConvertPintsToGallons() {
        val value = 8.0
        val fromUnit = Unit.PINT
        val toUnit = Unit.GALLON

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Pint(s) = $convertedValue Gallon(s).")
    }

    @Test
    fun testConvertPintsToQuarts() {
        val value = 2.0
        val fromUnit = Unit.PINT
        val toUnit = Unit.QUART

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Pint(s) = $convertedValue Quart(s).")
    }

    @Test
    fun testConvertPintsToCups() {
        val value = 1.0
        val fromUnit = Unit.PINT
        val toUnit = Unit.WET_CUP

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(2.0, convertedValue, 0.001)

        println("$value Pint(s) = $convertedValue Cup(s).")
    }

    @Test
    fun testConvertPintsToFluidOunces() {
        val value = 1.0
        val fromUnit = Unit.PINT
        val toUnit = Unit.FLUID_OUNCE

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(16.0, convertedValue, 0.001)

        println("$value Pint(s) = $convertedValue Fluid Ounce(s).")
    }

    // Wet Cup Conversions
    @Test
    fun testConvertCupsToGallons() {
        val value = 16.0
        val fromUnit = Unit.WET_CUP
        val toUnit = Unit.GALLON

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Cup(s) = $convertedValue Gallon(s).")
    }

    @Test
    fun testConvertCupsToQuarts() {
        val value = 4.0
        val fromUnit = Unit.WET_CUP
        val toUnit = Unit.QUART

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Cup(s) = $convertedValue Quart(s).")
    }

    @Test
    fun testConvertCupsToPints() {
        val value = 2.0
        val fromUnit = Unit.WET_CUP
        val toUnit = Unit.PINT

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Cup(s) = $convertedValue Pint(s).")
    }

    @Test
    fun testConvertCupsToFluidOunces() {
        val value = 1.0
        val fromUnit = Unit.WET_CUP
        val toUnit = Unit.FLUID_OUNCE

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(8.0, convertedValue, 0.001)

        println("$value Cup(s) = $convertedValue Fluid Ounce(s).")
    }

    // Fluid Ounce Conversions
    @Test
    fun testConvertFluidOuncesToGallons() {
        val value = 128.0
        val fromUnit = Unit.FLUID_OUNCE
        val toUnit = Unit.GALLON

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Fluid Ounce(s) = $convertedValue Gallon(s).")
    }

    @Test
    fun testConvertFluidOuncesToQuarts() {
        val value = 32.0
        val fromUnit = Unit.FLUID_OUNCE
        val toUnit = Unit.QUART

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Fluid Ounce(s) = $convertedValue Quart(s).")
    }

    @Test
    fun testConvertFluidOuncesToPints() {
        val value = 16.0
        val fromUnit = Unit.FLUID_OUNCE
        val toUnit = Unit.PINT

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Fluid Ounce(s) = $convertedValue Pint(s).")
    }

    @Test
    fun testConvertFluidOuncesToCups() {
        val value = 8.0
        val fromUnit = Unit.FLUID_OUNCE
        val toUnit = Unit.WET_CUP

        val convertedValue = repository.convertUnit(value, fromUnit, toUnit)

        assertEquals(1.0, convertedValue, 0.001)

        println("$value Fluid Ounce(s) = $convertedValue Cup(s).")
    }
}