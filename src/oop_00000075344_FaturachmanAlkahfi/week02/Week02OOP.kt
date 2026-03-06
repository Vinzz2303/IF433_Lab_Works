package oop_00000075344_FaturachmanAlkahfi.week02

open class Person(
    val id: String,
    val name: String
)

open class Student(
    id: String,
    name: String,
    val major: String,
    private var score: Int
) : Person(id, name) {

    fun updateScore(newScore: Int) {
        require(newScore in 0..100) { "Nilai harus di antara 0 sampai 100." }
        score = newScore
    }

    fun getScore(): Int = score

    open fun getStudyType(): String = "Mahasiswa Reguler"

    fun getGrade(): String = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "E"
    }

    fun getStatus(): String = if (score >= 75) "Lulus" else "Tidak Lulus"

    open fun printSummary() {
        println("[$id] $name - $major")
        println("Tipe Studi : ${getStudyType()}")
        println("Nilai      : $score")
        println("Grade      : ${getGrade()}")
        println("Status     : ${getStatus()}")
        println()
    }
}

class ExchangeStudent(
    id: String,
    name: String,
    major: String,
    score: Int,
    private val originUniversity: String
) : Student(id, name, major, score) {

    override fun getStudyType(): String = "Mahasiswa Pertukaran"

    override fun printSummary() {
        super.printSummary()
        println("Asal Univ  : $originUniversity")
        println()
    }
}

fun main() {
    val students: List<Student> = listOf(
        Student("STD-001", "Fatur", "Informatika", 88),
        Student("STD-002", "Rina", "Sistem Informasi", 72),
        ExchangeStudent("EX-003", "Kenji", "Teknik Komputer", 93, "Kyoto Institute")
    )

    println("=== Rekap Nilai Mahasiswa ===")
    for (student in students) {
        student.printSummary()
    }

    val mutableStudent = Student("STD-004", "Alya", "Informatika", 65)
    mutableStudent.updateScore(79)
    println("=== Update Nilai ===")
    mutableStudent.printSummary()
}
