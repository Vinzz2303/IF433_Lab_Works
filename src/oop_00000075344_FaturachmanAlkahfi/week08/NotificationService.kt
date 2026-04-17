package oop_00000075344_FaturachmanAlkahfi.week08

fun sendProfileNotification(userProfile: UserProfile?) {
    if (userProfile != null) {
        println("Mengirim notifikasi ke ${userProfile.fullName}")
        val emailLength = userProfile.email?.length ?: 0
        println("Panjang email yang terdaftar: $emailLength")
    } else {
        println("Profil pengguna tidak tersedia")
    }
}
