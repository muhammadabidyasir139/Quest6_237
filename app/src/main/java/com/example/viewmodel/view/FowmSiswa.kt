package com.example.viewmodel.view

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

@OptIn(..markerClass = ExperimentalMaterial3Api::class)
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

    Scaffold { modifier = Modifier,
    topBar = { TopAppBar(title = {Text(text = stringResource(id = "Form Pendaftaran"), color = Color.White)}) }}
}