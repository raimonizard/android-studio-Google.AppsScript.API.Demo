package com.example.googleappsscriptapidemo.api

import com.example.googleappsscriptapidemo.model.Arc
import com.example.googleappsscriptapidemo.model.GetResponse
import com.example.googleappsscriptapidemo.model.PostRequest
import com.example.googleappsscriptapidemo.model.PostResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Interface que declara la signatura dels mètodes
 * referents als endpoints de la API de JS.
 */
interface AssistenciaApiService {
    /**
     * GET totes les dades de la pestanya "Full 1" del Google Sheets
     * @author RIS
     */
    @GET("exec")
    suspend fun getDadesArc(
        @Query("apiKey") apiKey: String, // Envia la API_KEY que consta a secrets.properties
        @Query("type") type: String = "arc" // A través d'un atribut com 'type' podem atacar a diferents endpoints de tipus GET. Només cal capturar l'atribut e.parameter.type des de la funció doGet(e) de JS i respondre amb les dades desitjades.
    ): GetResponse<List<Arc>>

    /**
     * POST per registrar entrada/sortida
     * @author RIS
     */
    @POST("exec")
    suspend fun inserirFila(
        @Body body: PostRequest
    ): PostResponse
}