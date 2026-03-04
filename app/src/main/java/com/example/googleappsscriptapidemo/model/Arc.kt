package com.example.googleappsscriptapidemo.model

/**
 * Data class amb el mateix número de columnes,
 * mateix nom de columnes i mateix tipus de dades
 * que les columnes originals que hi ha al document de Google Sheets
 */
data class Arc(
    val arc: String,
    val startOnEpisode: Int,
    val totalEpisodes: Int,
    val totalMinutes: Int,
    val totalPages: Int
)