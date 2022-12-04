
fun main() {
    var i = 0
    var sum = 0
    //var acc = mutableListOf<Int>()


    fun priority(s: String) : Int{
        val f = s.substring(0,s.length/2)
        val s = s.substring(s.length/2)


        val fs = f.toCharArray().toSet()
        val ss = s.toCharArray().toSet()
          val common = fs.intersect(ss).first()
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

    println(input.map{it -> priority(it)}.sum())

    //println(acc.sortedDescending().take(3).sum())
}