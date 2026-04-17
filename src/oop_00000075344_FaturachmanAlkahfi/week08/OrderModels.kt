package oop_00000075344_FaturachmanAlkahfi.week08

data class Address(
    val street: String,
    val city: String?,
    val postalCode: String?
)

data class Customer(
    val name: String,
    val address: Address?
)

data class Order(
    val orderId: String,
    val customer: Customer?,
    val notes: String?
)
