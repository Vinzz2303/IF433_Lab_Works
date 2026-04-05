package oop_00000075344_FaturachmanAlkahfi.week06

fun processCheckout(method: PaymentMethod, amount: Double) {
    println("Memproses checkout sebesar Rp%.0f".format(amount))
    method.pay(amount)
}

fun main() {
    println("=== Week 06 - Interfaces & Code Contracts ===")

    val submitButton = Button("Submit")
    submitButton.click()

    val smartwatch = Smartwatch("Samsung")
    smartwatch.showTime()
    smartwatch.charge()
    smartwatch.connectToPhone()

    val smartphone = Smartphone()
    smartphone.capture()

    processCheckout(Gopay("0812-0000-1234"), 150_000.0)
    processCheckout(CreditCard("****-****-****-7788"), 275_000.0)

    println("\n=== Smart Home Task ===")
    val lamp = SmartLamp("L-01", "Ruang Tamu")
    val speaker = SmartSpeaker("S-01", "Google Nest Dapur")
    val cctv = SmartCCTV("C-01", "Ezviz Garasi")

    val hub = SmartHomeHub()
    hub.addDevice(lamp)
    hub.addDevice(speaker)
    hub.addDevice(cctv)

    hub.activateSecurityMode()
    hub.turnOffAllSwitches()
}
