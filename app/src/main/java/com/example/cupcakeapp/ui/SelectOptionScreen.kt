package com.example.cupcakeapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcakeapp.R
import com.example.cupcakeapp.ui.theme.CupcakeAppTheme

@Composable
fun SelectOptionScreen(
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {},
    onCancel: () -> Unit = {},
    onNext: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            options.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = selectedValue == item,
                            onClick = {
                                selectedValue = item
                                onSelectionChanged(item)
                            }
                        )
                        .padding(vertical = dimensionResource(R.dimen.padding_small)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                    Text(item)
                }
            }

            Divider(
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.padding_medium))
            )

            Text(
                text = "Subtotal $24.00",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(
                        top = dimensionResource(R.dimen.padding_medium)
                    )
                    .align(Alignment.End)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onCancel,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancel")
            }
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
            Button(
                onClick = onNext,
                modifier = Modifier.weight(1f)
            ) {
                Text("Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SelectOptionPreview() {
    CupcakeAppTheme {
        SelectOptionScreen(
            options = listOf("Vanilla", "Chocolate", "Red Velvet", "Salted Caramel", "Coffee"),
            modifier = Modifier.fillMaxSize()
        )
    }
}
