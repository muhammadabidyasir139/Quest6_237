package com.example.viewmodel.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viewmodel.R
import com.example.viewmodel.model.Siswa

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
                title = { Text(text = stringResource(id = R.string.data_siswa)) }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items.forEach { (label, value) ->
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = label.uppercase(),
                        fontSize = 16.sp
                    )
                    Text(
                        text = value,
                        fontSize = 16.sp
                    )
                    Divider(
                        thickness = dimensionResource(id = R.dimen.thickness_divider)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBackButtonClicked
            ) {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }
}
