package oop_00000075344_FaturachmanAlkahfi.week08

fun runMockUnitTest() {
    val expectedProfile = UserProfile(
        id = "USR-TEST",
        fullName = "Mock Tester",
        email = "tester@umn.ac.id",
        phoneNumber = null,
        bio = null
    )
    val actualProfile: UserProfile? = expectedProfile

    val verifiedProfile = actualProfile!!
    check(verifiedProfile.fullName == "Mock Tester") {
        "Mock unit test gagal: nama profil tidak sesuai"
    }
    println("Mock unit test berhasil untuk ${verifiedProfile.fullName}")
}
