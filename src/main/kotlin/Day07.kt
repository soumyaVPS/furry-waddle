import kotlin.math.abs
import kotlin.math.round
import kotlin.math.roundToInt

fun main() {
    fun part1(input: List<String>): Int {
        val hpositions = input[0].split(",").map { it.toInt() }
        val ordered = hpositions.sorted()
        val avg = round(ordered.average()).toInt()

        println(hpositions)
        println(ordered.size )
        println("Average  "+avg +" Max:" +ordered.maxByOrNull { it })
        var minDist:Int = 999999999
        for(i in 1..2000) {

             val distFromI = ordered.fold(0) { acc, it ->
                {}
                acc + round(1.0 * abs(it - i) * (abs(it - i) + 1) / 2).toInt()
            }
            if(distFromI < minDist) {
                minDist = distFromI
            }
            println("$i:$distFromI")
        }
        return minDist

    }

    fun part2(input: List<String>): Int {
        val zip3 = input.zip( input.drop(1).zip(input.drop(2))){t1,t2 -> t1.toInt() + t2.first.toInt() + t2.second.toInt()}
        return zip3.zip(zip3.drop(1)).count{it ->
            it.second >it.first }
    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day07_test")
    println(part1(input))
    println(part2(input))
}

