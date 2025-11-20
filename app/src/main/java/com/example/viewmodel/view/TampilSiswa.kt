package com.example.viewmodel.view

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