package oop_00000075344_FaturachmanAlkahfi.week01

fun main() {
    val name = "alvinJK"
    val score = 80

    println("Nama: $name, Nilai: $score")
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }

    println("Grade kamu: $grade")
}
