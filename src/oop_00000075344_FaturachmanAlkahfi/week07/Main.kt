package oop_00000075344_FaturachmanAlkahfi.week07

fun main() {
    println("=== Week 07 - Special Classes & Static Members ===")

    DatabaseManager.connect()
    val client = NetworkClient.create("https://api.umn.ac.id")
    client.get("/status")

    val regularUserA = RegularUser(1, "Fatur")
    val regularUserB = RegularUser(1, "Fatur")
    println("Regular class equality: ${regularUserA == regularUserB}")
    println("Regular user A: $regularUserA")

    val userA = User(1, "Fatur")
    val userB = User(1, "Fatur")
    println("Data class equality: ${userA == userB}")
    println("Data user A: $userA")

    val upgradedUser = userA.copy(name = "Fatur A.")
    val (userId, userName) = upgradedUser
    println("Copy data class: $upgradedUser")
    println("Destructuring user -> id=$userId, name=$userName")

    val appState = AppState.LOADING
    println("AppState saat ini: $appState")

    val response: ApiResponse = ApiResponse.Success("Data profil berhasil dimuat")
    val uiMessage = when (response) {
        is ApiResponse.Success -> "UI sukses: ${response.data}"
        is ApiResponse.Error -> "UI error: ${response.message}"
        ApiResponse.Loading -> "Tampilkan Spinner"
    }
    println(uiMessage)

    println("\n=== RPG Task ===")
    GameManager.startGame()
    GameManager.startGame()

    println("Drop chance LEGENDARY: ${ItemRarity.LEGENDARY.dropChance}%")

    val starterWeapon = Weapon.forgeStarterSword()
    println(
        "Senjata awal: ${starterWeapon.item.name}, damage ${starterWeapon.item.damage}, " +
            "rarity ${starterWeapon.item.rarity}, durability ${starterWeapon.durability}"
    )

    val upgradedSword = starterWeapon.item.copy(
        name = "Pedang Kayu Bapuk +1",
        damage = 25
    )
    println("Hasil upgrade blacksmith: $upgradedSword")

    processEvent(BattleState.SafeZone)
    processEvent(BattleState.MonsterEncounter("Goblin Nakal"))
    processEvent(BattleState.LootDropped(upgradedSword))
    processEvent(BattleState.GameOver("Terkena jebakan racun"))
}
