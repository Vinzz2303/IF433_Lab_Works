package oop_00000075344_FaturachmanAlkahfi.week06

class Gopay(
    private val phoneNumber: String
) : PaymentMethod {
    override fun pay(amount: Double) {
        println("Pembayaran Rp%.0f menggunakan GoPay (%s) berhasil.".format(amount, phoneNumber))
    }
}

class CreditCard(
    private val maskedNumber: String
) : PaymentMethod {
    override fun pay(amount: Double) {
        println("Pembayaran Rp%.0f menggunakan kartu kredit %s berhasil.".format(amount, maskedNumber))
    }
}
