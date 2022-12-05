
fun main() {
    var i = 0
    var sum = 0
    //var acc = mutableListOf<Int>()


    fun points(s: String) : Int{
        val (e,m) = s.split(" ").let {it[0] to it[1]}

        val elf = when (e) {
            "A" -> 1
            "B" -> 2
            "C" -> 3
            else -> 0
        }
        val me = when (m) {
            "X" -> 1
            "Y" -> 2
            "Z" -> 3
            else -> 0
        }
        val meScore = when (m) {
            "X" -> 0
            "Y" -> 3
            "Z" -> 6
            else -> 0
        }
        var winScore = when  {
            m=="X"-> elf - 1
            m=="Y"-> elf
            m=="Z" -> elf + 1
            else -> 0
        }
        if (winScore == 4) { winScore = 1}
        if (winScore == 0) { winScore = 3 }
        return winScore + meScore
    }
//    fun accumulate(sum:Int, i : Int) {
//        acc.add(sum)
//    }
    val input = readInput("Day22_2_1_test")

    println(input.map{it -> points(it)}.sum())

    //println(acc.sortedDescending().take(3).sum())
}