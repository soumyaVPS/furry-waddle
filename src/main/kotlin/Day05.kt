fun main() {
    fun part1(input: List<String>): Int {
        val a = input.map {
            it.split("->").map { it.trim().split(",").map { it.toInt() }.zipWithNext().first() }.zipWithNext().first()
        }
        val b =  a.filter {
            it.first.first == it.second.first || it.first.second == it.second.second
        }
        val c = b.map {
            if (it.first.first > it.second.first || it.first.second > it.second.second)
                Pair(it.second, it.first)
            else
                it
        }
        val d = c.flatMap {
            if (it.first.first == it.second.first) {
                (it.first.second..it.second.second).map { rit -> Pair(it.first.first, rit) }
            } else {
                (it.first.first..it.second.first).map { rit -> Pair(rit, it.first.second) }
            }
        }
        val e = d.groupingBy { it }.eachCount().count{it.value >= 2}

        return e

    }

    fun part2(input: List<String>): Int {
        val a = input.map {
            it.split("->").map { it.trim().split(",").map { it.toInt() }.zipWithNext().first() }.zipWithNext().first()
        }

        val b = a.map {
            if ( it.first.first > it.second.first  || (it.first.first == it.second.first && it.first.second>it.second.second))
                Pair(it.second, it.first)
            else
                it
        }
        val c = b.flatMap {it->
            if (it.first.first == it.second.first) {
                (it.first.second..it.second.second).map { rit -> Pair(it.first.first, rit) }
            } else if(it.first.second == it.second.second) {
                (it.first.first..it.second.first).map { rit -> Pair(rit, it.first.second) }
            } else if(it.first.second > it.second.second){
                var i = it.first.second
                (it.first.first..it.second.first).map { rit -> Pair(rit, i--) }
            } else {
                var i = it.first.second
                (it.first.first..it.second.first).map { rit -> Pair(rit, i++) }
            }
        }
        println(b)
        println(c)
        val d = c.groupingBy { it }.eachCount().count{it.value >= 2}

        return d
    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day05_test")
    //println(part1(input))
    println(part2(input))
}

