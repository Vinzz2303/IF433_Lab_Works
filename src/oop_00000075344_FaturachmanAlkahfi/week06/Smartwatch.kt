package oop_00000075344_FaturachmanAlkahfi.week06

class Smartwatch(
    brand: String
) : Watch(brand), Chargeable, Connectable {
    override fun showTime() {
        println("Smartwatch $brand menampilkan waktu digital.")
    }
}
