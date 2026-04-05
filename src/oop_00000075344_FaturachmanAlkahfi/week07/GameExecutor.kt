package oop_00000075344_FaturachmanAlkahfi.week07

fun processEvent(event: BattleState) {
    when (event) {
        is BattleState.MonsterEncounter -> {
            println("Musuh muncul: ${event.monsterName}. Bersiap bertarung!")
        }

        is BattleState.LootDropped -> {
            val (name, damage, rarity) = event.item
            println("Loot ditemukan: $name dengan damage $damage dan rarity $rarity.")
        }

        is BattleState.GameOver -> {
            println("Game Over: ${event.reason}")
        }

        BattleState.SafeZone -> {
            println("Pemain berada di Safe Zone. HP dapat dipulihkan.")
        }
    }
}
