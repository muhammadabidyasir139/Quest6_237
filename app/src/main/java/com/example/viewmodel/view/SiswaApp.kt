package com.example.viewmodel.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SiswaApp(
    viewModel:SiswaViewModel = SiswaViewModel()
){
    val uiState by viewModel.statusUI.collectAsState()
    val navController = rememberNavController()
    val context = LocalContext.current

    Scaffold { padding ->

        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(padding)
        )

        {
            composable(Navigasi.Formulir.name) {

                val pilihanJK = JenisJK.map { id ->
                    id
                }

                FormSiswa(
                    pilihanJK = pilihanJK,
                    onSubmitButtonClicked = {
                        viewModel.setSiswa(it)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
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