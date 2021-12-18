import java.lang.Integer.MAX_VALUE

fun main() {
    fun part1(input: List<String>): Int {
      val ingraph = input.map{it.toCharArray().map{it1-> it1.digitToInt() }}
        val rows = ingraph.size
        val cols = ingraph.get(0).size
        val distgraph = Array(rows, Array(cols,MAX_VALUE))
        val sx =0; val sy = 0
        fun sp(sx:Int, sy:Int, dist:Int) {

        }
        sp(sx+1, sy, 0)
        sp(sx,ingraph.get(sx).get(sy),0)

    }

    fun part2(input: List<String>): Int {

    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day01_test")
    println(part1(input))
    println(part2(input))
}

