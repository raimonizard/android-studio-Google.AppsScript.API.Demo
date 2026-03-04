package com.example.googleappsscriptapidemo.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.googleappsscriptapidemo.model.Arc

/**
 * Funció composable que crea una composable Card per a cada objecte Arc rebut per paràmetre.
 * @author RIS
 * @param arc de tipus Arc
 */
@Composable
fun ArcCard(arc: Arc) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = arc.arc,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("🎬 Inici episodi: ${arc.startOnEpisode}")
            Text("📺 Total episodis: ${arc.totalEpisodes}")
            Text("⏱ Total minuts: ${arc.totalMinutes}")
            Text("📖 Total pàgines: ${arc.totalPages}")
        }
    }
}