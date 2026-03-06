package oop_00000075344_FaturachmanAlkahfi.week05

data class CourseScore(
    val studentId: String,
    val studentName: String,
    val course: String,
    val score: Int
)

fun toGrade(score: Int): String = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    else -> "E"
}

fun main() {
    val scores = listOf(
        CourseScore("STD-01", "Fatur", "PBO", 88),
        CourseScore("STD-02", "Nadia", "PBO", 92),
        CourseScore("STD-03", "Raka", "PBO", 76),
        CourseScore("STD-01", "Fatur", "Struktur Data", 84),
        CourseScore("STD-02", "Nadia", "Struktur Data", 95),
        CourseScore("STD-03", "Raka", "Struktur Data", 68)
    )

    println("=== Week 05 - Collection Processing ===")

    val passed = scores.filter { it.score >= 75 }
    println("Jumlah data lulus: ${passed.size}")

    val gradeSummary = scores.map {
        "${it.studentName} - ${it.course}: ${it.score} (${toGrade(it.score)})"
    }
    println("\nRingkasan nilai:")
    gradeSummary.forEach { println(it) }

    val avgByStudent = scores
        .groupBy { it.studentName }
        .mapValues { (_, value) -> value.map { it.score }.average() }
        .toList()
        .sortedByDescending { it.second }

    println("\nRata-rata per mahasiswa:")
    avgByStudent.forEach { (name, avg) ->
        println("$name: %.2f".format(avg))
    }
}
