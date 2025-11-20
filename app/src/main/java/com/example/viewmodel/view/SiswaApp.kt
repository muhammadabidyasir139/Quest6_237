package com.example.viewmodel.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*
import com.example.viewmodel.viewmodel.JenisJK
import com.example.viewmodel.viewmodel.Navigasi
import com.example.viewmodel.viewmodel.SiswaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    viewModel: SiswaViewModel = SiswaViewModel()
) {
    val uiState by viewModel.statusUI.collectAsState()
    val navController = rememberNavController()
    val context = LocalContext.current

    Scaffold { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(paddingValues)
        ) {

            // Halaman Form
            composable(Navigasi.Formulir.name) {

                val pilihanJK = JenisJK.map { it } // langsung map tanpa rename

                FormSiswa(
                    pilihanJK = pilihanJK,
                    onSubmitButtonClicked = { listData ->
                        viewModel.setSiswa(listData)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            // Halaman Detail
            composable(Navigasi.Detail.name) {

                TampilSiswa(
                    statusUiSiswa = uiState,
                    onBackButtonClicked = {
                        navController.popBackStack(
                            route = Navigasi.Formulir.name,
                            inclusive = false
                        )
                    }
                )
            }
        }
    }
}
