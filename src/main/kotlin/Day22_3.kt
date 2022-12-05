
fun main() {
    var i = 0
    var sum = 0
    //var acc = mutableListOf<Int>()


    fun priority(group: List<String>) : Int{
        val fs = group[0].toCharArray().toSet()
        val ss = group[1].toCharArray().toSet()
        val ts = group[2].toCharArray().toSet()

        val common = fs.intersect(ss).intersect(ts).first()
        println(common)
        val priority = if (common >= 'a')
            common - 'a' +1
        else if
                (common <= 'Z')  common - 'A' +27
        else
            0
        return priority

    }
//    fun accumulate(sum:Int, i : Int) {
//        acc.add(sum)
//    }
    val input = readInput("Day22_3_test")

    println(input.chunked(3).map{it -> priority(it)}.sum())

    //println(acc.sortedDescending().take(3).sum())
}