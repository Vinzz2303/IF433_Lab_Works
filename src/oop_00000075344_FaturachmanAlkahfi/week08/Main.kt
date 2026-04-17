package oop_00000075344_FaturachmanAlkahfi.week08

fun main() {
    println("=== Week 08 - Advanced Null Safety ===")

    val primaryProfile = UserProfile(
        id = "USR-01",
        fullName = "Fatur Alkahfi",
        email = "fatur@umn.ac.id",
        phoneNumber = null,
        bio = "Mahasiswa IF433"
    )
    val guestProfile: UserProfile? = null

    sendProfileNotification(primaryProfile)
    sendProfileNotification(guestProfile)

    val completeOrder = Order(
        orderId = "ORD-1001",
        customer = Customer(
            name = "Alicia",
            address = Address(
                street = "Jl. Scientia Boulevard",
                city = "Tangerang",
                postalCode = "15810"
            )
        ),
        notes = "Kirim sore"
    )

    val incompleteOrder = Order(
        orderId = "ORD-1002",
        customer = Customer(
            name = "Budi",
            address = null
        ),
        notes = null
    )

    val shippingCity = completeOrder.customer?.address?.city ?: "Kota tidak tersedia"
    val fallbackCity = incompleteOrder.customer?.address?.city ?: "Kota tidak tersedia"
    println("Kota pengiriman order lengkap: $shippingCity")
    println("Kota pengiriman order tidak lengkap: $fallbackCity")

    completeOrder.customer?.address?.city?.let { city ->
        println("Order ${completeOrder.orderId} akan diproses ke kota $city")
    }
    incompleteOrder.customer?.address?.city?.let { city ->
        println("Order ${incompleteOrder.orderId} akan diproses ke kota $city")
    }

    val mixedItems: List<Any?> = listOf(
        "Laptop",
        404,
        null,
        "Mouse",
        true,
        "Keyboard"
    )

    println("Hanya item bertipe String:")
    for (item in mixedItems) {
        val textItem = item as? String
        textItem?.let {
            println("- $it")
        }
    }

    val preferredUsername = mixedItems[1] as? String ?: "guest-user"
    println("Username fallback dari safe cast: $preferredUsername")

    val mandatoryEmail = requireNotNull(primaryProfile.email) {
        "Email utama wajib tersedia untuk mengirim notifikasi"
    }
    println("Email tervalidasi dengan requireNotNull: $mandatoryEmail")

    val trustedCustomerName = LegacyJavaAPI.fetchCustomerName("CUST-01")!!
    println("Nama customer dari Java API: ${trustedCustomerName.uppercase()}")

    runMockUnitTest()

    // Trial crash dari modul disimpan sebagai contoh, jangan aktifkan saat run normal.
    val emergencyContact: String? = null
    // println(emergencyContact!!.length)
    println("Contoh fatal crash dengan !! disiapkan di komentar: $emergencyContact")
}
