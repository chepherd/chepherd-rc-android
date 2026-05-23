package io.chepherd.rc.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RootView() {
    var signedIn by remember { mutableStateOf(false) }
    if (signedIn) {
        DashboardScreen()
    } else {
        SignInScreen(onSignedIn = { signedIn = true })
    }
}
