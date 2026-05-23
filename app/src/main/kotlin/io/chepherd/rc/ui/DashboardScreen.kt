package io.chepherd.rc.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import io.chepherd.rc.protocol.SessionState
import io.chepherd.rc.style.ChepherdFont
import io.chepherd.rc.style.ChepherdSpace
import io.chepherd.rc.style.Palette

@Composable
fun DashboardScreen() {
    val sessions = remember { mutableStateListOf<SessionState>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Palette.background)
            .padding(ChepherdSpace.s4),
        verticalArrangement = Arrangement.spacedBy(ChepherdSpace.s3),
    ) {
        Text(
            text = "SESSIONS",
            color = Palette.title,
            style = ChepherdFont.titleMono.copy(fontWeight = FontWeight.Bold),
        )
        if (sessions.isEmpty()) {
            Text(
                text = "no sessions yet",
                color = Palette.timestamp,
                style = ChepherdFont.bodyMono.copy(fontSize = ChepherdFont.sm),
            )
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(ChepherdSpace.s2)) {
                items(sessions, key = { it.uuid }) { s ->
                    SessionRow(session = s)
                }
            }
        }
    }
}
