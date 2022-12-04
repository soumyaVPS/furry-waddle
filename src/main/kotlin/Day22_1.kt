
fun main() {
    var i = 0
    var sum = 0
    var acc = mutableListOf<Int>()

    fun accumulate(sum:Int, i : Int) {
        acc.add(sum)
    }
    val input = readInput("Day22_1_1_test")

    for (e in input) {
        if (e != "") {
            sum += e.toInt()
        } else{
            accumulate(sum, i)
            println("${sum} ${i}")
            sum = 0
            i++
        }
    }

    println(acc.sortedDescending().take(3).sum())
}