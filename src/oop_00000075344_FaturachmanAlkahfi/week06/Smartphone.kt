package oop_00000075344_FaturachmanAlkahfi.week06

class Smartphone : Camera, Phone {
    override fun capture() {
        println("Smartphone memilih dua implementasi capture:")
        super<Camera>.capture()
        super<Phone>.capture()
    }
}
