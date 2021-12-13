fun main() {
    fun part1(input: List<String>): Int {
        var states = input[0].split(",").map{it.trim().toInt()}
        repeat(10) { it1 ->
            println(it1)
            println(states)
            states = states.flatMap {
                when (it) {
                    0 -> listOf(6, 8)
                    else -> {
                        listOf(it - 1)
                    }
                }
            }
        }
       return states.size
    }

    fun part2(input: List<String>): Int {
     return 1
    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day06_test")
    println(part1(input))
    println(part2(input))
}

