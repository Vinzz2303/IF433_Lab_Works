package oop_00000075344_FaturachmanAlkahfi.week06

class SmartHomeHub {
    val devices = mutableListOf<SmartDevice>()

    fun addDevice(device: SmartDevice) {
        devices += device
        println("Perangkat ${device.name} ditambahkan ke hub.")
    }

    fun turnOffAllSwitches() {
        println("Mematikan semua perangkat switchable...")
        for (device in devices) {
            if (device is Switchable) {
                device.turnOff()
            }
        }
    }

    fun activateSecurityMode() {
        println("Mengaktifkan security mode...")
        for (device in devices) {
            if (device is Recordable) {
                device.startRecord()
            }
            if (device is SmartSpeaker) {
                device.playMusic("Sirine Peringatan")
            }
        }
    }
}
