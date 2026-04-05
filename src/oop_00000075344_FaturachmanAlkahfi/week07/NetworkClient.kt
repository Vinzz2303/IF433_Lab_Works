package oop_00000075344_FaturachmanAlkahfi.week07

class NetworkClient private constructor(
    private val baseUrl: String
) {
    fun get(endpoint: String) {
        println("GET $baseUrl$endpoint")
    }

    companion object {
        fun create(baseUrl: String): NetworkClient {
            return NetworkClient(baseUrl)
        }
    }
}
