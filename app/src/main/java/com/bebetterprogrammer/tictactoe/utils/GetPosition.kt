package com.bebetterprogrammer.tictactoe.utils

import kotlin.random.Random
import kotlin.random.nextInt

class GetPosition {
    private fun jarvisWin(
        list: List<Int>,
        gameState: Array<Int>,
        jarvis: Int
    ): Int {
        var r: Int
        if (!list.contains(0) && !list.contains(1) && list.contains(2) && (gameState[0] == jarvis && gameState[1] == jarvis)) {
            r = 2
        } else if (!list.contains(5) && !list.contains(8) && list.contains(2) && (gameState[5] == jarvis && gameState[8] == jarvis)) {
            r = 2
        } else if (!list.contains(4) && !list.contains(6) && list.contains(2) && (gameState[4] == jarvis && gameState[6] == jarvis)) {
            r = 2
        } else if (!list.contains(1) && !list.contains(2) && list.contains(0) && (gameState[1] == jarvis && gameState[2] == jarvis)) {
            r = 0
        } else if (!list.contains(3) && !list.contains(6) && list.contains(0) && (gameState[3] == jarvis && gameState[6] == jarvis)) {
            r = 0
        } else if (!list.contains(4) && !list.contains(8) && list.contains(0) && (gameState[4] == jarvis && gameState[8] == jarvis)) {
            r = 0
        } else if (!list.contains(0) && !list.contains(2) && list.contains(1) && (gameState[0] == jarvis && gameState[2] == jarvis)) {
            r = 1
        } else if (!list.contains(4) && !list.contains(7) && list.contains(1) && (gameState[4] == jarvis && gameState[7] == jarvis)) {
            r = 1
        } else if (!list.contains(3) && !list.contains(4) && list.contains(5) && (gameState[3] == jarvis && gameState[4] == jarvis)) {
            r = 5
        } else if (!list.contains(2) && !list.contains(8) && list.contains(5) && (gameState[2] == jarvis && gameState[8] == jarvis)) {
            r = 5
        } else if (!list.contains(4) && !list.contains(5) && list.contains(3) && (gameState[4] == jarvis && gameState[5] == jarvis)) {
            r = 3
        } else if (!list.contains(0) && !list.contains(6) && list.contains(3) && (gameState[0] == jarvis && gameState[6] == jarvis)) {
            r = 3
        } else if (!list.contains(3) && !list.contains(5) && list.contains(4) && (gameState[3] == jarvis && gameState[5] == jarvis)) {
            r = 4
        } else if (!list.contains(1) && !list.contains(7) && list.contains(4) && (gameState[1] == jarvis && gameState[7] == jarvis)) {
            r = 4
        } else if (!list.contains(0) && !list.contains(8) && list.contains(4) && (gameState[0] == jarvis && gameState[8] == jarvis)) {
            r = 4
        } else if (!list.contains(2) && !list.contains(6) && list.contains(4) && (gameState[2] == jarvis && gameState[6] == jarvis)) {
            r = 4
        } else if (!list.contains(6) && !list.contains(7) && list.contains(8) && (gameState[6] == jarvis && gameState[7] == jarvis)) {
            r = 8
        } else if (!list.contains(2) && !list.contains(5) && list.contains(8) && (gameState[2] == jarvis && gameState[5] == jarvis)) {
            r = 8
        } else if (!list.contains(7) && !list.contains(8) && list.contains(6) && (gameState[7] == jarvis && gameState[8] == jarvis)) {
            r = 6
        } else if (!list.contains(0) && !list.contains(3) && list.contains(6) && (gameState[0] == jarvis && gameState[3] == jarvis)) {
            r = 6
        } else if (!list.contains(2) && !list.contains(4) && list.contains(6) && (gameState[2] == jarvis && gameState[4] == jarvis)) {
            r = 6
        } else if (!list.contains(6) && !list.contains(8) && list.contains(7) && (gameState[6] == jarvis && gameState[8] == jarvis)) {
            r = 7
        } else if (!list.contains(1) && !list.contains(4) && list.contains(7) && (gameState[1] == jarvis && gameState[4] == jarvis)) {
            r = 7
        } else if (!list.contains(0) && !list.contains(4) && list.contains(8) && (gameState[0] == jarvis && gameState[4] == jarvis)) {
            r = 8
        } else {
            r = -1
        }
        return r
    }

    private fun breakPlayer(
        list: List<Int>,
        gameState: Array<Int>,
        weapon: Int
    ): Int {
        var r: Int
        if (!list.contains(0) && !list.contains(1) && list.contains(2) && (gameState[0] == weapon && gameState[1] == weapon)) {
            r = 2
        } else if (!list.contains(5) && !list.contains(8) && list.contains(2) && (gameState[5] == weapon && gameState[8] == weapon)) {
            r = 2
        } else if (!list.contains(4) && !list.contains(6) && list.contains(2) && (gameState[4] == weapon && gameState[6] == weapon)) {
            r = 2
        } else if (!list.contains(1) && !list.contains(2) && list.contains(0) && (gameState[1] == weapon && gameState[2] == weapon)) {
            r = 0
        } else if (!list.contains(3) && !list.contains(6) && list.contains(0) && (gameState[3] == weapon && gameState[6] == weapon)) {
            r = 0
        } else if (!list.contains(4) && !list.contains(8) && list.contains(0) && (gameState[4] == weapon && gameState[8] == weapon)) {
            r = 0
        } else if (!list.contains(0) && !list.contains(2) && list.contains(1) && (gameState[0] == weapon && gameState[2] == weapon)) {
            r = 1
        } else if (!list.contains(4) && !list.contains(7) && list.contains(1) && (gameState[4] == weapon && gameState[7] == weapon)) {
            r = 1
        } else if (!list.contains(3) && !list.contains(4) && list.contains(5) && (gameState[3] == weapon && gameState[4] == weapon)) {
            r = 5
        } else if (!list.contains(2) && !list.contains(8) && list.contains(5) && (gameState[2] == weapon && gameState[8] == weapon)) {
            r = 5
        } else if (!list.contains(4) && !list.contains(5) && list.contains(3) && (gameState[4] == weapon && gameState[5] == weapon)) {
            r = 3
        } else if (!list.contains(0) && !list.contains(6) && list.contains(3) && (gameState[0] == weapon && gameState[6] == weapon)) {
            r = 3
        } else if (!list.contains(3) && !list.contains(5) && list.contains(4) && (gameState[3] == weapon && gameState[5] == weapon)) {
            r = 4
        } else if (!list.contains(1) && !list.contains(7) && list.contains(4) && (gameState[1] == weapon && gameState[7] == weapon)) {
            r = 4
        } else if (!list.contains(0) && !list.contains(8) && list.contains(4) && (gameState[0] == weapon && gameState[8] == weapon)) {
            r = 4
        } else if (!list.contains(2) && !list.contains(6) && list.contains(4) && (gameState[2] == weapon && gameState[6] == weapon)) {
            r = 4
        } else if (!list.contains(6) && !list.contains(7) && list.contains(8) && (gameState[6] == weapon && gameState[7] == weapon)) {
            r = 8
        } else if (!list.contains(2) && !list.contains(5) && list.contains(8) && (gameState[2] == weapon && gameState[5] == weapon)) {
            r = 8
        } else if (!list.contains(7) && !list.contains(8) && list.contains(6) && (gameState[7] == weapon && gameState[8] == weapon)) {
            r = 6
        } else if (!list.contains(0) && !list.contains(3) && list.contains(6) && (gameState[0] == weapon && gameState[3] == weapon)) {
            r = 6
        } else if (!list.contains(2) && !list.contains(4) && list.contains(6) && (gameState[2] == weapon && gameState[4] == weapon)) {
            r = 6
        } else if (!list.contains(6) && !list.contains(8) && list.contains(7) && (gameState[6] == weapon && gameState[8] == weapon)) {
            r = 7
        } else if (!list.contains(1) && !list.contains(4) && list.contains(7) && (gameState[1] == weapon && gameState[4] == weapon)) {
            r = 7
        } else if (!list.contains(0) && !list.contains(4) && list.contains(8) && (gameState[0] == weapon && gameState[4] == weapon)) {
            r = 8
        } else {
            r = -1
        }
        return r
    }

    fun getPos(
        list: List<Int>,
        whichLevel: Int,
        gameState: Array<Int>,
        jarvis: Int,
        weapon: Int
    ): Int {
        var r: Int
        when (whichLevel) {
            0 -> {
                r = jarvisWin(list, gameState, jarvis)
                if (r == -1) {
                    r = breakPlayer(list, gameState, weapon)
                    if (r == -1) {
                        r = list[Random.nextInt(0..list.size - 1)]
                    }
                }
                return r
            }
            1 -> {
                r = jarvisWin(list, gameState, jarvis)
                if (r == -1) {
                    r = breakPlayer(list, gameState, weapon)
                    if (r == -1) {
                        if (!list.containsAll(
                                listOf(
                                    8,
                                    4
                                )
                            ) && gameState[8] == weapon && gameState[4] == weapon && (list.contains(
                                6
                            ) || list.contains(2))
                        ) {
                            if (list.containsAll(listOf(2, 6))) {
                                r = listOf(2, 6).random()
                            } else if (list.containsAll(listOf(3, 6))) {
                                r = 6
                            } else if (list.containsAll(listOf(2, 1))) {
                                r = 2
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    6,
                                    4
                                )
                            ) && gameState[6] == weapon && gameState[4] == weapon && (list.contains(
                                0
                            ) || list.contains(8))
                        ) {
                            if (list.containsAll(listOf(0, 8))) {
                                r = listOf(0, 8).random()
                            } else if (list.containsAll(listOf(0, 1))) {
                                r = 0
                            } else if (list.containsAll(listOf(8, 5))) {
                                r = 8
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    0,
                                    4
                                )
                            ) && gameState[0] == weapon && gameState[4] == weapon && (list.contains(
                                6
                            ) || list.contains(2))
                        ) {
                            if (list.containsAll(listOf(2, 6))) {
                                r = listOf(2, 6).random()
                            } else if (list.containsAll(listOf(6, 3))) {
                                r = 6
                            } else if (list.containsAll(listOf(2, 1))) {
                                r = 2
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    2,
                                    4
                                )
                            ) && gameState[2] == weapon && gameState[4] == weapon && (list.contains(
                                0
                            ) || list.contains(8))
                        ) {
                            if (list.containsAll(listOf(0, 8))) {
                                r = listOf(0, 8).random()
                            } else if (list.containsAll(listOf(0, 1))) {
                                r = 0
                            } else if (list.containsAll(listOf(8, 5))) {
                                r = 8
                            }
                        } else {
                            r = list[Random.nextInt(0..list.size - 1)]
                        }
                    }
                }
                if (r == -1) {
                    r = list[Random.nextInt(0..list.size - 1)]
                }
                return r
            }
            2 -> {
                r = jarvisWin(list, gameState, jarvis)
                if (r == -1) {
                    r = breakPlayer(list, gameState, weapon)
                    if (r == -1) {
                        if ((!list.contains(0) && gameState[0] == weapon && list.containsAll(
                                listOf(
                                    2,
                                    4,
                                    6,
                                    8
                                )
                            )) || (!list.contains(2) && gameState[2] == weapon && list.containsAll(
                                listOf(
                                    0,
                                    4,
                                    6,
                                    8
                                )
                            )) || (!list.contains(
                                6
                            ) && gameState[6] == weapon && list.containsAll(
                                listOf(
                                    2,
                                    4,
                                    0,
                                    8
                                )
                            )) || (!list.contains(8) && gameState[8] == weapon && list.containsAll(
                                listOf(
                                    2,
                                    4,
                                    6,
                                    0
                                )
                            )) || (!list.contains(1) && gameState[1] == weapon && list.containsAll(
                                listOf(
                                    3,
                                    4,
                                    5,
                                    7
                                )
                            )) || (!list.contains(3) && gameState[3] == weapon && list.containsAll(
                                listOf(
                                    1,
                                    4,
                                    5,
                                    7
                                )
                            )) || (!list.contains(5) && gameState[5] == weapon && list.containsAll(
                                listOf(
                                    3,
                                    4,
                                    1,
                                    7
                                )
                            )) || (!list.contains(7) && gameState[7] == weapon && list.containsAll(
                                listOf(
                                    3,
                                    4,
                                    5,
                                    1
                                )
                            ))
                        ) {
                            r = 4
                        } else if ((!list.contains(4) && gameState[4] == weapon && list.containsAll(
                                listOf(
                                    0,
                                    2,
                                    6,
                                    8
                                )
                            ))
                        ) {
                            r = listOf(0, 2, 6, 8).random()
                        } else if (((!list.containsAll(
                                listOf(
                                    2,
                                    6
                                )
                            ) && gameState[2] == weapon && gameState[6] == weapon) || (!list.containsAll(
                                listOf(0, 8)
                            ) && gameState[0] == weapon && gameState[8] == weapon)) && list.containsAll(
                                listOf(
                                    3,
                                    5
                                )
                            )
                        ) {
                            r = listOf(3, 5).random()
                        } else if (!list.containsAll(
                                listOf(
                                    1,
                                    3
                                )
                            ) && gameState[1] == weapon && gameState[3] == weapon && list.contains(0)
                        ) {
                            r = 0
                        } else if (!list.containsAll(
                                listOf(5, 7)
                            ) && gameState[5] == weapon && gameState[7] == weapon && list.contains(8)
                        ) {
                            r = 8
                        } else if (!list.containsAll(
                                listOf(
                                    7,
                                    3
                                )
                            ) && gameState[7] == weapon && gameState[3] == weapon && list.contains(6)
                        ) {
                            r = 6
                        } else if (!list.containsAll(
                                listOf(
                                    1,
                                    5
                                )
                            ) && gameState[5] == jarvis && gameState[1] == jarvis && list.contains(2)
                        ) {
                            r = 2
                        } ///new code
                        else if (!list.containsAll(
                                listOf(
                                    0,
                                    4
                                )
                            ) && gameState[0] == jarvis && gameState[4] == jarvis && list.containsAll(
                                listOf(1, 2)
                            )
                        ) {
                            if (list.contains(6)) {
                                r = 2
                            } else if (list.contains(7)) {
                                r = 1
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    0,
                                    4
                                )
                            ) && gameState[0] == jarvis && gameState[4] == jarvis && list.containsAll(
                                listOf(3, 6)
                            )
                        ) {
                            if (list.contains(2)) {
                                r = 6
                            } else if (list.contains(5)) {
                                r = 3
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    2,
                                    4
                                )
                            ) && gameState[2] == jarvis && gameState[4] == jarvis && list.containsAll(
                                listOf(1, 0)
                            )
                        ) {
                            if (list.contains(8)) {
                                r = 0
                            } else if (list.contains(7)) {
                                r = 1
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    2,
                                    4
                                )
                            ) && gameState[2] == jarvis && gameState[4] == jarvis && list.containsAll(
                                listOf(5, 8)
                            )
                        ) {
                            if (list.contains(0)) {
                                r = 8
                            } else if (list.contains(3)) {
                                r = 5
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    6,
                                    4
                                )
                            ) && gameState[6] == jarvis && gameState[4] == jarvis && list.containsAll(
                                listOf(7, 8)
                            )
                        ) {
                            if (list.contains(1)) {
                                r = 7
                            } else if (list.contains(0)) {
                                r = 8
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    6,
                                    4
                                )
                            ) && gameState[6] == jarvis && gameState[4] == jarvis && list.containsAll(
                                listOf(0, 3)
                            )
                        ) {
                            if (list.contains(5)) {
                                r = 3
                            } else if (list.contains(8)) {
                                r = 0
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    8,
                                    4
                                )
                            ) && gameState[8] == jarvis && gameState[4] == jarvis && list.containsAll(
                                listOf(5, 2)
                            )
                        ) {
                            if (list.contains(3)) {
                                r = 5
                            } else if (list.contains(6)) {
                                r = 2
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    8,
                                    4
                                )
                            ) && gameState[8] == jarvis && gameState[4] == jarvis && list.containsAll(
                                listOf(6, 7)
                            )
                        ) {
                            if (list.contains(1)) {
                                r = 7
                            } else if (list.contains(2)) {
                                r = 6
                            }
                        } //player break
                        else if (!list.containsAll(
                                listOf(
                                    8,
                                    4
                                )
                            ) && gameState[8] == weapon && gameState[4] == weapon && (list.contains(
                                6
                            ) || list.contains(2))
                        ) {
                            if (list.containsAll(listOf(2, 6))) {
                                r = listOf(2, 6).random()
                            } else if (list.containsAll(listOf(3, 6))) {
                                r = 6
                            } else if (list.containsAll(listOf(2, 1))) {
                                r = 2
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    6,
                                    4
                                )
                            ) && gameState[6] == weapon && gameState[4] == weapon && (list.contains(
                                0
                            ) || list.contains(8))
                        ) {
                            if (list.containsAll(listOf(0, 8))) {
                                r = listOf(0, 8).random()
                            } else if (list.containsAll(listOf(0, 1))) {
                                r = 0
                            } else if (list.containsAll(listOf(8, 5))) {
                                r = 8
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    0,
                                    4
                                )
                            ) && gameState[0] == weapon && gameState[4] == weapon && (list.contains(
                                6
                            ) || list.contains(2))
                        ) {
                            if (list.containsAll(listOf(2, 6))) {
                                r = listOf(2, 6).random()
                            } else if (list.containsAll(listOf(6, 3))) {
                                r = 6
                            } else if (list.containsAll(listOf(2, 1))) {
                                r = 2
                            }
                        } else if (!list.containsAll(
                                listOf(
                                    2,
                                    4
                                )
                            ) && gameState[2] == weapon && gameState[4] == weapon && (list.contains(
                                0
                            ) || list.contains(8))
                        ) {
                            if (list.containsAll(listOf(0, 8))) {
                                r = listOf(0, 8).random()
                            } else if (list.containsAll(listOf(0, 1))) {
                                r = 0
                            } else if (list.containsAll(listOf(8, 5))) {
                                r = 8
                            }
                        } else {
                            r = list[Random.nextInt(0..list.size - 1)]
                        }
                    }
                }
                if (r == -1) {
                    r = list[Random.nextInt(0..list.size - 1)]
                }
                return r
            }
        }
        return -1
    }
}
