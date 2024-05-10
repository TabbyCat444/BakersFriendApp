package com.example.thebakersfriend

import android.icu.text.DecimalFormat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainViewModel(private val MainRepository: MainRepository) {
    var uiState by mutableStateOf(MainUiState())
        private set

    var menuState by mutableStateOf(ConversionMenuState())
        private set

    fun menuClickHandler(menu: ConversionMenu) {
        when (menu) {
            ConversionMenu.DryLeft -> {
                menuState = menuState.copy(isDryLeftExpanded = true)
            }

            ConversionMenu.DryRight -> {
                menuState = menuState.copy(isDryRightExpanded = true)
            }

            ConversionMenu.WetLeft -> {
                menuState = menuState.copy(isWetLeftExpanded = true)
            }

            ConversionMenu.WetRight -> {
                menuState = menuState.copy(isWetRightExpanded = true)
            }
        }
    }

    fun dismissMenuClickHandler(menu: ConversionMenu) {
        when (menu) {
            ConversionMenu.DryLeft -> {
                menuState = menuState.copy(isDryLeftExpanded = false)
            }

            ConversionMenu.DryRight -> {
                menuState = menuState.copy(isDryRightExpanded = false)
            }

            ConversionMenu.WetLeft -> {
                menuState = menuState.copy(isWetLeftExpanded = false)
            }

            ConversionMenu.WetRight -> {
                menuState = menuState.copy(isWetRightExpanded = false)
            }
        }
    }

    fun enumToString(string: String) =
        string.mapIndexed { index, c ->
            val newC = if (index == 0) {
                c.uppercaseChar()
            } else if (!c.isLetter()) {
                ' '
            } else
                c.lowercaseChar()

            newC
        }.joinToString("")

    fun updateDryUnit(index: Int, isLeft: Boolean) {
        val unit = when (index) {
            0 -> Unit.DRY_CUP
            1 -> Unit.TABLESPOON
            2 -> Unit.TEASPOON
            else -> Unit.DRY_CUP
        }

        uiState = if (isLeft) {
            uiState.copy(dryLeft = unit)
        } else {
            uiState.copy(dryRight = unit)
        }
    }

    fun updateWetUnit(index: Int, isLeft: Boolean) {
        val unit = when (index) {
            0 -> Unit.GALLON
            1 -> Unit.QUART
            2 -> Unit.PINT
            3 -> Unit.WET_CUP
            4 -> Unit.FLUID_OUNCE
            else -> Unit.GALLON
        }

        uiState = if (isLeft) {
            uiState.copy(wetLeft = unit)
        } else {
            uiState.copy(wetRight = unit)
        }
    }

    fun getDryOutput() =
        DecimalFormat("0.00").format(uiState.dryOutput)

    fun getWetOutput() =
        DecimalFormat("0.00").format(uiState.wetOutput)

    fun dryInputHandler(s: String) {
        val num: Double

        try {
            val builder = StringBuilder()
            if (uiState.dryInput == 0.0) {
                s.forEach { c: Char ->
                    if (c != '0' && c != '.')
                        builder.append(c)
                }
            } else {
                builder.append(s)
            }

            num = builder.toString().toDouble()
        } catch (e: NumberFormatException) {
            return
        }

        val output = MainRepository.convertUnit(num, uiState.dryLeft, uiState.dryRight)
        uiState = uiState.copy(dryInput = num, dryOutput = output)

    }

    fun wetInputHandler(s: String) {
        val num: Double

        try {
            val builder = StringBuilder()
            if (uiState.wetInput == 0.0) {
                s.forEach { c: Char ->
                    if (c != '0' && c != '.')
                        builder.append(c)
                }
            } else {
                builder.append(s)
            }

            num = builder.toString().toDouble()
        } catch (e: NumberFormatException) {
            return
        }

        val output = MainRepository.convertUnit(num, uiState.wetLeft, uiState.wetRight)
        uiState = uiState.copy(wetInput = num, wetOutput = output)
    }
}