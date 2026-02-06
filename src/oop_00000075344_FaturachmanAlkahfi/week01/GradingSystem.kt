package oop_00000075344_FaturachmanAlkahfi.week01

fun main() {
    var name: String = "alvinJK"
    var score: Int = 80

    // Concatenation gaya lama
    println("Nama: " + name + ", Nilai: " + score)
}

fun main()  {
    // REFACTOR: Gunakan val dan hapus tipe data eksplisit
    val name = "alvinJK"
    var score = 80

    //REFACTOR: SString Templaye ($name)
    println("Nama: $name, Nilai: $score")
}