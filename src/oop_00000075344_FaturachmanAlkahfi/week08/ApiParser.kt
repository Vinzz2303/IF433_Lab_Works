package oop_00000075344_FaturachmanAlkahfi.week08

class ApiParser {
    fun parseProduct(rawJson: Map<String, Any?>): Product? {
        val id = requireNotNull(rawJson["id"] as? String) { "API Invalid: Missing ID" }
        val name = requireNotNull(rawJson["name"] as? String) { "API Invalid: Missing Name" }
        val type = rawJson["type"] as? String

        return when (type) {
            "ELECTRONIC" -> {
                val warrantyMonths = rawJson["warranty"] as? Int ?: 12
                Electronic(id, name, warrantyMonths)
            }
            "CLOTHING" -> {
                val size = rawJson["size"] as? String ?: "All Size"
                Clothing(id, name, size)
            }
            else -> null
        }
    }

    fun checkout(product: Product) {
        when (product) {
            is Electronic -> {
                println("Checkout electronic: ${product.name} (Warranty ${product.warrantyMonths} bulan)")
                val transactionId = JavaPaymentService.processPayment(product.id)!!
                println("Transaction ID: $transactionId")
            }
            is Clothing -> {
                println("Checkout clothing: ${product.name} (Size ${product.size})")
                val transactionId = JavaPaymentService.processPayment(product.id)!!
                println("Transaction ID: $transactionId")
            }
        }
    }
}
