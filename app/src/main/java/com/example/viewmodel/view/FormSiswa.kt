package com.example.viewmodel.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJk: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    var txtNama by rememberSaveable { mutableStateOf(value = "") }
    var txtAlamat by remember { mutableStateOf(value = "") }
    var txtGender by remember { mutableStateOf(value = "") }
    var ListData: MutableList<String> = mutableListOf(txtNama,txtGender,txtAlamat)

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        OutlinedTextField(
            value = txtNama,
            onValueChange = { txtNama = it },
            label = { Text("Nama Lengkap") },
            singleLine = true
        )

        Divider(thickness = dimensionResource(id = R.dimen._1dp))

        pilihanJK.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = txtGender == item,
                        onClick = { txtGender = item }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = txtGender == item,
                    onClick = { txtGender = item }
                )
                Text(text = item)
            }
        }

        Divider(thickness = dimensionResource(id = R.dimen._1dp))

        OutlinedTextField(
            value = txtAlamat,
            onValueChange = { txtAlamat = it },
            label = { Text("Alamat Lengkap") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = txtAlamat.isNotEmpty(),
            onClick = {
                listData.add(txtNama)
                listData.add(txtGender)
                listData.add(txtAlamat)
                onSubmitButtonClicked(listData)
            }
        ) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}