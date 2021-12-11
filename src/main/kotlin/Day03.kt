fun main() {

    fun part1(input: List<String>): Int {
        val a = input.map{ it.toCharArray()
       }
        val l = a[0].size
        var eps = CharArray(l)
        var g = CharArray(l)

        for (i in 0..l-1) {
            val zcount = a.count{it.get(i) == '0'}
            eps[i] = if(zcount>=input.size/2) { '0' } else '1'
            g[i] = if(eps[i] =='0') { '1' } else '0'

        }
        return eps.fold(0) { acc,t -> acc*2+t.digitToInt() } * g.fold(0) { acc,t -> acc*2+t.digitToInt() }
    }

    fun part2(input: List<String>): Int {
        var a = input.map { it.toCharArray() }
        var b = input.map { it.toCharArray() }

        val l = a[0].size
        var eps = CharArray(l)
        var g = CharArray(l)
    var i = 0
        while (a.size > 1 && i < l) {
                val zcount = a.count { it.get(i) == '0' }
                val f = if (zcount > a.size / 2) {
                    '0'
                } else '1'
                a = a.filter { it[i] == f }
                println("A "+i)
                i++
            }
i=0
            while(b.size >1 && i< l) {
                val lcount = b.count { it.get(i) == '1' }
                val f = if (lcount >= 1.0 * b.size / 2 ) {
                    '0'
                } else '1'
                b = b.filter { it[i] == f }
                println("B " +i)
                i++
            }


        val oxy = a.get(0).fold(0) { acc, t -> acc * 2 + t.digitToInt() }
        val co2 = b.get(0).fold(0) { acc, t -> acc * 2 + t.digitToInt() }
        println(" " + oxy +" "+ co2)
        return oxy * co2
    }
        // test if implementation meets criteria from the description, like:

    val input = readInput("Day03_test")
    println(part1(input))
    println(part2(input))
}

