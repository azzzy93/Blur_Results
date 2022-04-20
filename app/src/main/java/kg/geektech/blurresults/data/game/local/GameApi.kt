package kg.geektech.blurresults.data.game.local

import kg.geektech.blurresults.domain.entity.PlayerResult

class GameApi {

    private val list: ArrayList<PlayerResult> = ArrayList()

    init {
        createPlayers()
    }

    private fun createPlayers() {
        list.add(
            PlayerResult(
                id = 0,
                name = "Aziz",
                winCount = 0,
                lossCount = 0,
                total = 0
            )
        )
        list.add(
            PlayerResult(
                id = 1,
                name = "Ali",
                winCount = 0,
                lossCount = 0,
                total = 0
            )
        )
        list.add(
            PlayerResult(
                id = 2,
                name = "Shama",
                winCount = 0,
                lossCount = 0,
                total = 0
            )
        )
    }

    fun getPlayers(): List<PlayerResult> {
        return list
    }

    fun editPlayers(player: PlayerResult) {
        player.id?.let { id ->
            list[id] = player
        }
    }

}