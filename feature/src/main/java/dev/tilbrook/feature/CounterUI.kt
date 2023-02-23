package dev.tilbrook.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksActivityViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterPage() {
    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            val viewMode: CounterViewModel = mavericksActivityViewModel()
            val state by viewMode.collectAsState()
            Button(onClick = viewMode::add, modifier = Modifier.align(Alignment.Center)) {
                Text("Count: ${state.count}")
            }
        }
    }
}