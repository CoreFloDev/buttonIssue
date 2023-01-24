/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.derivedstatecrash.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonColors
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import com.example.derivedstatecrash.presentation.theme.DerivedStateCrashTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp(listOf("a","b","c","d"))
        }
    }
}

@Composable
fun WearApp(data: List<String>) {
    DerivedStateCrashTheme {
        /* If you have enough items in your list, use [ScalingLazyColumn] which is an optimized
         * version of LazyColumn for wear devices with some added features. For more information,
         * see d.android.com/wear/compose.
         */
        val listState = rememberLazyListState(0)
        val selectedIndex by remember(listState) { derivedStateOf { listState.firstVisibleItemIndex } }

        LazyRow(
            modifier = Modifier
                .height(72.dp)
                .fillMaxWidth(),
            state = listState
        ) {
            itemsIndexed(data) { index, item ->
                Button(
                    modifier = Modifier.size(72.dp),
                    onClick = {  },
                    enabled = index == selectedIndex
                ) {
                    Text(text = item)
                }
            }
        }
    }
}
