package oop_00000075344_FaturachmanAlkahfi.week07

class Weapon private constructor(
    val item: GameItem,
    val durability: Int
) {
    companion object {
        fun forgeStarterSword(): Weapon {
            return Weapon(
                GameItem("Pedang Kayu Bapuk", 5, ItemRarity.COMMON),
                50
            )
        }

        fun forgeEpicSword(): Weapon {
            return Weapon(
                GameItem("Dragonfang Greatsword", 80, ItemRarity.EPIC),
                180
            )
        }
    }
}
