package com.example.thebakersfriend.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thebakersfriend.ConversionMenu
import com.example.thebakersfriend.MainViewModel

val TEXT_FIELD_MODIFIER = Modifier
    .size(width = 150.dp, height = 50.dp)
    .padding(5.dp, 0.dp)

val INPUT_BOX_MODIFIER = Modifier
    .padding(5.dp, 50.dp)

val BOX_LABEL_MODIFIER = Modifier
    .offset(x = 5.dp)

@Composable
fun MainUi(viewModel: MainViewModel) {
    MainBox(viewModel)
}

@Composable
fun MainBox(viewModel: MainViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
            ) {
                Title()
            }
            Row {
                DryBox(viewModel)
            }
            Row {
                WetBox(viewModel)
            }
        }
    }
}

@Composable
fun Title() = Row(
    horizontalArrangement = Arrangement.Center,
) {
    Text(text = "The Baker's Friend")
}

@Composable
fun DryBox(viewModel: MainViewModel) = Box(modifier = INPUT_BOX_MODIFIER) {
    Column {
        Row {
            Text(
                text = "Dry Conversions",
                modifier = BOX_LABEL_MODIFIER
            )
        }
        DryRow(viewModel)
    }
}

@Composable
fun DryRow(viewModel: MainViewModel) {
    val items = arrayListOf("Cup(s)", "Tablespoon(s)", "Teaspoon(s)")

    val dryLeft = viewModel.enumToString(string = viewModel.uiState.dryLeft.name)
    val dryRight = viewModel.enumToString(string = viewModel.uiState.dryRight.name)

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            value = viewModel.uiState.dryInput.toString(),
            onValueChange = { s: String -> viewModel.dryInputHandler(s) }, TEXT_FIELD_MODIFIER
        )
        MyDropDown(
            exposed = viewModel.menuState.isDryLeftExpanded, selectedItem = dryLeft, items = items,
            viewModel = viewModel, menu = ConversionMenu.DryLeft
        )
        Text(text = " = ${viewModel.getDryOutput()} ")
        MyDropDown(
            exposed = viewModel.menuState.isDryRightExpanded, selectedItem = dryRight, items = items,
            viewModel = viewModel, menu = ConversionMenu.DryRight
        )
    }
}

@Composable
fun WetBox(viewModel: MainViewModel) = Box(modifier = INPUT_BOX_MODIFIER) {
    Column {
        Row {
            Text(
                text = "Wet Conversions",
                modifier = BOX_LABEL_MODIFIER
            )
        }
        WetRow(viewModel)
    }
}

@Composable
fun WetRow(viewModel: MainViewModel) {
    val items = arrayListOf("Gallons", "Quarts", "Pints", "Cups", "Fluid Oz.")

    val wetLeft = viewModel.enumToString(string = viewModel.uiState.wetLeft.name)
    val wetRight = viewModel.enumToString(string = viewModel.uiState.wetRight.name)

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            value = viewModel.uiState.wetInput.toString(),
            onValueChange = { s: String -> viewModel.wetInputHandler(s) }, TEXT_FIELD_MODIFIER
        )
        MyDropDown(
            exposed = viewModel.menuState.isWetLeftExpanded, selectedItem = wetLeft, items = items,
            viewModel = viewModel, menu = ConversionMenu.WetLeft
        )
        Text(text = " = ${viewModel.getWetOutput()} ")
        MyDropDown(
            exposed = viewModel.menuState.isWetRightExpanded, selectedItem = wetRight, items = items,
            viewModel = viewModel, menu = ConversionMenu.WetRight
        )
    }
}

@Composable
fun MyDropDown(
    items: ArrayList<String>,
    exposed: Boolean,
    selectedItem: String,
    viewModel: MainViewModel,
    menu: ConversionMenu
) {
    Column {
        Text(text = selectedItem, modifier = Modifier
            .clickable {
                viewModel.menuClickHandler(menu)
            })
        DropdownMenu(exposed, onDismissRequest = { viewModel.dismissMenuClickHandler(menu) }) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(onClick = {
                    when (menu) {
                        ConversionMenu.DryLeft -> {
                            viewModel.updateDryUnit(index, true)
                            viewModel.dryInputHandler(viewModel.uiState.dryInput.toString())
                        }

                        ConversionMenu.DryRight -> {
                            viewModel.updateDryUnit(index, false)
                            viewModel.dryInputHandler(viewModel.uiState.dryInput.toString())
                        }

                        ConversionMenu.WetLeft -> {
                            viewModel.updateDryUnit(index, true)
                            viewModel.dryInputHandler(viewModel.uiState.wetInput.toString())
                        }

                        ConversionMenu.WetRight -> {
                            viewModel.updateDryUnit(index, false)
                            viewModel.dryInputHandler(viewModel.uiState.wetInput.toString())
                        }
                    }

                    viewModel.dismissMenuClickHandler(menu)
                }, text = { Text(item) })
            }
        }
    }
}
