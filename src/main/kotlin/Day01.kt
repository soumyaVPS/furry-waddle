fun main() {
    fun part1(input: List<String>): Int {
        return input.zip( input.drop(1)).count{it ->
            it.second.toInt() >it.first.toInt() }
    }

    fun part2(input: List<String>): Int {
        val zip3 = input.zip( input.drop(1).zip(input.drop(2))){t1,t2 -> t1.toInt() + t2.first.toInt() + t2.second.toInt()}
        return zip3.zip(zip3.drop(1)).count{it ->
            it.second >it.first }
    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day01_test")
    println(part1(input))
    println(part2(input))
}

