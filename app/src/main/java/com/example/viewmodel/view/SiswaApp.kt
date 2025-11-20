package com.example.viewmodel.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viewmodel.Navigasi
import com.example.viewmodel.model.DataJk
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
            composable(route = Navigasi.Formulir.name) {

                val pilihanJk = DataJk.jenisK

                FormSiswa(
                    pilihanJk = pilihanJk,
                    onSubmitButtonClicked = { listData ->
                        viewModel.setSiswa(listData)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            // Halaman Detail
            composable(route = Navigasi.Detail.name) {

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
