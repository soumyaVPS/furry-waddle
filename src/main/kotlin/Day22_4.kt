
fun main() {
    var i = 0
    var sum = 0
    //var acc = mutableListOf<Int>()


    fun overlapping(line: String) : Boolean{
        val (f,s) = line.split(",").let { it[0] to it[1]}
        val f1 = f.split("-").let { t-> t[0].toInt() to t[1].toInt()}
        val s1 = s.split("-").let { t-> t[0].toInt() to t[1].toInt()}


        if ((f1.first <= s1.first && f1.second >= s1.second)|| (s1.first<=f1.first && s1.second >= f1.second)
            || (f1.second >= s1.first && f1.second <= s1.second) || (s1.second >= f1.first && s1.second <= f1.second)){
             println( "$f1    $s1")
            println( "$f     $s")
            return true
        }
        return false
    }
//    fun accumulate(sum:Int, i : Int) {
//        acc.add(sum)
//    }
    val input = readInput("Day22_4_test")

    println(input.map{it -> overlapping(it)}.filter { it == true }.count())

    //println(acc.sortedDescending().take(3).count())
}