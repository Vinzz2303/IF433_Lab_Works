package oop_00000075344_FaturachmanAlkahfi.week07

enum class ItemRarity(
    val dropChance: Int
) {
    COMMON(70),
    UNCOMMON(20),
    RARE(7),
    EPIC(3),
    LEGENDARY(1)
}

data class GameItem(
    val name: String,
    val damage: Int,
    val rarity: ItemRarity
)
