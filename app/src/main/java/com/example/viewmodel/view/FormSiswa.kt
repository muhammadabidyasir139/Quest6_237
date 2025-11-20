package com.example.viewmodel.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.viewmodel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJk: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by rememberSaveable { mutableStateOf("") }
    var txtGender by rememberSaveable { mutableStateOf("") }

    val listData = mutableListOf<String>()

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Input Nama
        OutlinedTextField(
            value = txtNama,
            onValueChange = { txtNama = it },
            label = { Text("Nama Lengkap") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))

        // Pilihan Jenis Kelamin
        pilihanJk.forEach { item ->
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

        Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))

        // Input Alamat
        OutlinedTextField(
            value = txtAlamat,
            onValueChange = { txtAlamat = it },
            label = { Text("Alamat Lengkap") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Tombol Submit
        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = txtAlamat.isNotEmpty() && txtNama.isNotEmpty() && txtGender.isNotEmpty(),
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
