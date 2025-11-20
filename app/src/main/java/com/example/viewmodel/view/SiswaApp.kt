package com.example.viewmodel.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SiswaApp(
    viewModel:SiswaViewModel = SiswaViewModel()
){
    val uiState by viewModel.statusUI.collectAsState()
    val navController = rememberNavController()
    val context = LocalContext.current

}