package com.example.googleappsscriptapidemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googleappsscriptapidemo.model.Arc
import com.example.googleappsscriptapidemo.model.PostResponse
import com.itb.ihub_login.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class OnePieceViewModel: ViewModel() {
    // Variables per a peticions GET
    private val _arcs = MutableStateFlow<List<Arc>>(emptyList())
    val arc: StateFlow<List<Arc>> = _arcs.asStateFlow()

    private val _registres = MutableStateFlow<List<Arc>>(emptyList())
    val registres: StateFlow<List<Arc>> = _registres.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    // Variables per a peticions POST
    private val _missatgeResposta = MutableStateFlow<PostResponse?>(null)
    val missatgeResposta: StateFlow<PostResponse?> = _missatgeResposta

    private val _email = MutableStateFlow<String>("")
    val email: StateFlow<String> = _email

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading: StateFlow<Boolean> = _loading

    fun toggleLoading() {
        _loading.value = !_loading.value
    }

    fun setLoading(status: Boolean) {
        _loading.value = status
    }

    fun carregarDades(apiKey: String) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val resposta = RetrofitInstance.api.getDadesArc(apiKey)
                if (resposta.status == "ok" && resposta.data != null) {
                    _arcs.value = resposta.data
                    println("✅ Assistents rebuts: ${resposta.data}") // <── AFEGIT
                } else {
                    _error.value = resposta.error ?: "Error desconegut"
                }
            } catch (e: Exception) {
                _error.value = e.message
                println("❌ Error carregarDades: ${e.message}")
            } finally {
                _loading.value = false
            }
        }
    }

    // Funció genèrica d’enviament
    private suspend fun enviarRegistre(email: String, accio: String, apiKey: String): PostResponse {
        TODO()
        /*
        _loading.value = true
        return try {
            val body = PostRequest(email, accio, apiKey)
            val resposta = RetrofitInstance.api.enviarRegistre(body)

            // 🛰️ Log per depuració
            println("🛰️ Resposta API (${accio.uppercase()}): $resposta")

            // ✅ Guarda la resposta per observar-la des de la UI
            _missatgeResposta.value = resposta

            // 🧩 Si la API retorna error dins del camp 'error', el convertim a missatge
            if (resposta.status != "ok" && resposta.message.isNullOrBlank() && !resposta.error.isNullOrBlank()) {
                resposta.copy(message = resposta.error)
            } else {
                resposta
            }

        } catch (e: Exception) {
            e.printStackTrace()
            println("❌ Error en enviarRegistre(${accio}): ${e.localizedMessage}")

            PostResponse(
                status = "error",
                message = e.localizedMessage ?: "Error de connexió amb el servidor",
                error = e.localizedMessage,
                email = email,
                hora = null
            )
        } finally {
            _loading.value = false
        }
        */
    }

    suspend fun registrarEntrada(apiKey: String, email: String): String {
        TODO()
        /*
        val resposta = enviarRegistre(email, "entrada", apiKey)
        _email.value = ""

        val missatge = resposta.message ?: resposta.error ?: "Error desconegut"

        return if (resposta.status == "ok") {
            "✅ Entrada registrada correctament a les ${resposta.hora}"
        } else {
            when {
                missatge.contains("ja ha fet entrada", ignoreCase = true) ->
                    "⚠️ Ja havies registrat una entrada anteriorment."
                missatge.contains("email no vàlid", ignoreCase = true) ->
                    "❌ El correu introduït no és vàlid."
                else -> "⚠️ Error al registrar l’entrada: $missatge"
            }
        }
        */
    }

    suspend fun registrarSortida(apiKey: String, email: String): String {
        TODO()
        /*
        val resposta = enviarRegistre(email, "sortida", apiKey)
        _email.value = ""

        val missatge = resposta.message ?: resposta.error ?: "Error desconegut"

        return if (resposta.status == "ok") {
            "👋 Sortida registrada correctament a les ${resposta.hora}"
        } else {
            when {
                missatge.contains("no ha fet entrada", ignoreCase = true) ||
                        missatge.contains("cap entrada oberta", ignoreCase = true) ->
                    "⚠️ No pots registrar la sortida sense haver fet entrada abans."

                missatge.contains("no trobat", ignoreCase = true) ->
                    "❌ El correu no s’ha trobat a la llista d’assistents."

                else -> "⚠️ Error al registrar la sortida: $missatge"
            }
        }
        */
    }

}
