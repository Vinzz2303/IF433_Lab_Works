package oop_00000075344_FaturachmanAlkahfi.week04

class InsufficientBalanceException(message: String) : Exception(message)

class BankAccount(
    val accountNumber: String,
    val ownerName: String,
    private var balance: Double
) {
    fun deposit(amount: Double) {
        require(amount > 0) { "Nominal deposit harus lebih dari 0." }
        balance += amount
    }

    @Throws(InsufficientBalanceException::class)
    fun withdraw(amount: Double) {
        require(amount > 0) { "Nominal tarik tunai harus lebih dari 0." }
        if (amount > balance) {
            throw InsufficientBalanceException(
                "Saldo tidak cukup. Saldo saat ini: %.2f".format(balance)
            )
        }
        balance -= amount
    }

    fun getBalance(): Double = balance
}

fun transfer(from: BankAccount, to: BankAccount, amount: Double) {
    try {
        from.withdraw(amount)
        to.deposit(amount)
        println("Transfer berhasil sebesar %.2f dari %s ke %s".format(amount, from.ownerName, to.ownerName))
    } catch (e: InsufficientBalanceException) {
        println("Transfer gagal: ${e.message}")
    } catch (e: IllegalArgumentException) {
        println("Input tidak valid: ${e.message}")
    } finally {
        println("Proses transfer selesai.")
        println()
    }
}

fun main() {
    val accountA = BankAccount("001", "Fatur", 1_000_000.0)
    val accountB = BankAccount("002", "Rina", 250_000.0)

    println("=== Week 04 - Exception Handling ===")
    transfer(accountA, accountB, 300_000.0)
    transfer(accountA, accountB, 900_000.0)

    println("Saldo akhir ${accountA.ownerName}: %.2f".format(accountA.getBalance()))
    println("Saldo akhir ${accountB.ownerName}: %.2f".format(accountB.getBalance()))
}
