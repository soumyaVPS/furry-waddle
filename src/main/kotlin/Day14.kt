import java.lang.Integer.MAX_VALUE
import java.lang.Integer.MIN_VALUE

fun main() {
    fun part1(input: List<String>): Int {
        var polymer = input.first()
        val rules = input.drop(2).map{it.split(" -> ").zipWithNext().first()}.toMap()
        println("Rules "+ rules)
        repeat(1) {
            var newPolymer = ""
            polymer.zipWithNext().forEach {
                println(it)
                newPolymer += listOf(it.first,rules[it.toList().joinToString("")]).joinToString("")
            }
            polymer = newPolymer
            println(polymer)
            println("length "+polymer.length)
        }

        val polymerChars = polymer.toCharArray()
       val elements = polymerChars.toSet()
        var min = MAX_VALUE
        var max = MIN_VALUE
        for (e in elements) {
            val count =polymerChars.count{it==e}
            if (min>count) {
                min = count
            }
            if (max<count) {
                max = count
            }
        }
        println ("max and min "+ max + " " + min)
        return 1
    }

    fun part2(input: List<String>): Int {
        val zip3 = input.zip( input.drop(1).zip(input.drop(2))){t1,t2 -> t1.toInt() + t2.first.toInt() + t2.second.toInt()}
        return zip3.zip(zip3.drop(1)).count{it ->
            it.second >it.first }
    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day14_test")
    println(part1(input))
    println(part2(input))
}

