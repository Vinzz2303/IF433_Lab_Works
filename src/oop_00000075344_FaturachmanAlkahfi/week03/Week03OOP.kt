package oop_00000075344_FaturachmanAlkahfi.week03

interface Taxable {
    fun calculateTax(): Double
}

interface Payable {
    fun calculatePay(): Double
}

abstract class Employee(
    val id: String,
    val name: String
) : Taxable, Payable {
    abstract fun role(): String

    fun printSlip() {
        val grossPay = calculatePay()
        val tax = calculateTax()
        val netPay = grossPay - tax

        println("ID         : $id")
        println("Nama       : $name")
        println("Jabatan    : ${role()}")
        println("Gaji Kotor : %.2f".format(grossPay))
        println("Pajak      : %.2f".format(tax))
        println("Gaji Bersih: %.2f".format(netPay))
        println()
    }
}

class FullTimeEmployee(
    id: String,
    name: String,
    private val monthlySalary: Double
) : Employee(id, name) {

    override fun role(): String = "Full-time Employee"

    override fun calculatePay(): Double = monthlySalary

    override fun calculateTax(): Double = monthlySalary * 0.1
}

class PartTimeEmployee(
    id: String,
    name: String,
    private val hoursWorked: Int,
    private val hourlyRate: Double
) : Employee(id, name) {

    override fun role(): String = "Part-time Employee"

    override fun calculatePay(): Double = hoursWorked * hourlyRate

    override fun calculateTax(): Double = calculatePay() * 0.05
}

fun main() {
    val employees: List<Employee> = listOf(
        FullTimeEmployee("EMP-001", "Fatur", 8_000_000.0),
        PartTimeEmployee("EMP-002", "Nadia", 80, 50_000.0),
        FullTimeEmployee("EMP-003", "Raka", 10_000_000.0)
    )

    println("=== Payroll Week 03 ===")
    for (employee in employees) {
        employee.printSlip()
    }
}
