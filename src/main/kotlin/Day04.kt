fun main() {
    fun isRowDone(r: Int, card: List<List<String>>): Boolean {
        for (i in 0..card[0].size - 1) {
            if (card[r][i] != "x") return false
        }
        return true
    }

    fun isColumnDone(c: Int, card: List<List<String>>): Boolean {
        for (i in 0..card.size - 1) {
            if (card[i][c] != "x") return false
        }
        return true
    }

    fun calculate(card: List<List<String>>): Int {
        return card.flatten().filter { it != "x" }.map { it.toInt() }.sum()
    }

    fun part1(input: List<String>): Int {
        var cards: List<List<MutableList<String>>> =
            input.drop(1).filter({ it.isNotEmpty() }).map { it.trim().split("\\s+".toRegex()) }
                .chunked(5) as List<List<MutableList<String>>>
        val readouts = input.get(0).split(",")

        println(cards)
        val numToPos: MutableMap<String, MutableList<Triple<Int, Int, Int>>> = mutableMapOf()
        cards.flatMapIndexed { cardnum: Int, card ->
            card.flatMapIndexed { rownum: Int, row ->
                row.mapIndexed { colnum: Int, elem ->
                    Pair(elem, Triple(cardnum, rownum, colnum))
                }
            }
        }.forEach {
            if (numToPos[it.first] != null) {
                numToPos[it.first]?.add(it.second)
            } else {
                numToPos[it.first] = mutableListOf<Triple<Int, Int, Int>>(it.second)
            }
        }
        readouts.forEach {
            val pos = numToPos[it]
            pos?.forEach { posit ->
                cards[posit.first][posit.second][posit.third] = "x"
                if (isRowDone(posit.second, cards[posit.first]) || isColumnDone(posit.third, cards[posit.first])) {
                    return calculate(cards[posit.first]) * it.toInt()
                }

            }
        }
        return 1
        }

        fun part2(input: List<String>): Int {
            var returnVal = 0

            var cards: List<List<MutableList<String>>> =
                input.drop(1).filter({ it.isNotEmpty() }).map { it.trim().split("\\s+".toRegex()) }
                    .chunked(5) as List<List<MutableList<String>>>
            val readouts = input.get(0).split(",")

            val numToPosOnBoards: MutableMap<String, MutableList<Triple<Int, Int, Int>>> = mutableMapOf()
            cards.flatMapIndexed { cardnum: Int, card ->
                card.flatMapIndexed { rownum: Int, row ->
                    row.mapIndexed { colnum: Int, elem ->
                        Pair(elem, Triple(cardnum, rownum, colnum))
                    }
                }
            }.forEach {
                if (numToPosOnBoards[it.first] != null) {
                    numToPosOnBoards[it.first]?.add(it.second)
                } else {
                    numToPosOnBoards[it.first] = mutableListOf<Triple<Int, Int, Int>>(it.second)
                }
            }
            val wonBoards = mutableSetOf<Int>()
            readouts.forEach {
                val pos = numToPosOnBoards[it]
                pos?.forEach { posit ->
                    if(!wonBoards.contains(posit.first)) {
                        cards[posit.first][posit.second][posit.third] = "x"
                        if (isRowDone(posit.second, cards[posit.first]) || isColumnDone(
                                posit.third,
                                cards[posit.first]
                            )
                        ) {
                            returnVal = calculate(cards[posit.first]) * it.toInt()
                            wonBoards.add(posit.first)
                        }
                    }

                }
            }
                return returnVal
            }

        // test if implementation meets criteria from the description, like:

        val input = readInput("Day04_test")
      //  println(part1(input))
        println(part2(input))
    }


