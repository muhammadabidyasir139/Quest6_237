package com.example.viewmodel.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUiSiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {

    val items = listOf(
        "Nama Lengkap" to statusUiSiswa.nama,
        "Jenis Kelamin" to statusUiSiswa.gender,
        "Alamat" to statusUiSiswa.alamat
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.data_siswa)) }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
        ){

            items.forEach { (label, value) ->
                Column {
                    Text(text = label.uppercase(), fontSize = 16.sp)
                    Text(text = value, fontSize = 16.sp)
                    Divider(thickness = dimensionResource(id = R.dimen._1dp))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = onBackButtonClicked) {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }
    }