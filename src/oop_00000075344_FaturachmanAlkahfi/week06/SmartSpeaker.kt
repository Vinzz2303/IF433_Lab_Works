package oop_00000075344_FaturachmanAlkahfi.week06

class SmartSpeaker(
    override val id: String,
    override val name: String
) : SmartDevice, Switchable {
    override fun turnOn() {
        println("Smart speaker $name aktif.")
    }

    override fun turnOff() {
        println("Smart speaker $name dimatikan.")
    }

    fun playMusic(song: String) {
        println("Memutar lagu $song dari Spotify.")
    }
}
