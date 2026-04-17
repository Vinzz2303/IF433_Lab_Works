package oop_00000075344_FaturachmanAlkahfi.week08

fun main() {
    println("=== Week 08 Task - E-Commerce API Parser ===")

    val rawApiData: List<Map<String, Any?>> = listOf(
        mapOf("id" to "E01", "name" to "Laptop", "type" to "ELECTRONIC", "warranty" to 24),
        mapOf("id" to "C01", "name" to "T-Shirt", "type" to "CLOTHING", "size" to "XL"),
        mapOf("id" to "E02", "name" to "Mouse", "type" to "ELECTRONIC", "warranty" to "Not An Integer"),
        mapOf("name" to "Ghost Item", "type" to "CLOTHING"),
        mapOf("id" to "X01", "name" to "Unknown", "type" to "FOOD")
    )

    val parser = ApiParser()

    for (raw in rawApiData) {
        try {
            parser.parseProduct(raw)?.let { product ->
                parser.checkout(product)
            } ?: println("Skip product dengan tipe tidak dikenal: ${raw["name"]}")
        } catch (exception: IllegalArgumentException) {
            println("Warning: ${exception.message}. Raw data: $raw")
        }
    }
}
