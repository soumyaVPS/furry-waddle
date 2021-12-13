fun main() {
    fun part1(input: List<String>): Int {
        val coordinateSplit = input.indexOf("")
        val coordis = input.subList(0,coordinateSplit)
        println(coordis)
        val commands = input.subList(coordinateSplit+1,input.lastIndex+1)
   print(commands)
        coordis.
        return 1
    }

    fun part2(input: List<String>): Int {
        return 1
    }
            // test if implementation meets criteria from the description, like:

    val input = readInput("Day13_test")
    println(part1(input))
    println(part2(input))
}

