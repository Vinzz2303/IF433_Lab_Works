package oop_00000075344_FaturachmanAlkahfi.week06

interface Clickable {
    val name: String

    fun click() {
        println("$name diklik.")
    }
}

class Button(
    override val name: String
) : Clickable
