fun main() {
    fun part1(input: List<String>): Int {
        val coordinateSplit = input.indexOf("")
        var coordis = input.subList(0,coordinateSplit).map{it.split(",").map{it.toInt()}.zipWithNext().first()}.toSet()
        println(coordis.size)
        val commands = input.subList(coordinateSplit+1,input.lastIndex+1)
        println(commands)

        commands.forEach{
            if (it.indexOf("y=") != -1) {
                val yfoldAt = it.substring("fold along y=".length).trim().toInt()
                val partitioned = coordis.partition { it.second < yfoldAt }
                var upper = partitioned.first.toMutableList()
                upper.addAll(partitioned.second.map { Pair(it.first,it.second - 2*(it.second-yfoldAt))})
                coordis = upper.toSet()
                println("Y fold points" + coordis.size)
            }
            else {
                val xfoldAt = it.substring("fold along x=".length).trim().toInt()
                val partitioned = coordis.partition { it.first < xfoldAt }
                var left = partitioned.first.toMutableList()
                left.addAll(partitioned.second.map { Pair(it.first - 2*(it.first-xfoldAt),it.second)})
                coordis = left.toSet()
                println("X fold points" + coordis.size)
            }
        }

        return coordis.size
    }

    fun part2(input: List<String>): Int {
        val coordinateSplit = input.indexOf("")
        var coordis = input.subList(0,coordinateSplit).map{it.split(",").map{it.toInt()}.zipWithNext().first()}.toSet()
        println(coordis.size)
        val commands = input.subList(coordinateSplit+1,input.lastIndex+1)
        println(commands)

        commands.forEach{
            if (it.indexOf("y=") != -1) {
                val yfoldAt = it.substring("fold along y=".length).trim().toInt()
                val partitioned = coordis.partition { it.second < yfoldAt }
                var upper = partitioned.first.toMutableList()
                upper.addAll(partitioned.second.map { Pair(it.first,it.second - 2*(it.second-yfoldAt))})
                coordis = upper.toSet()
                println("Y fold points" + coordis.size)
            }
            else {
                val xfoldAt = it.substring("fold along x=".length).trim().toInt()
                val partitioned = coordis.partition { it.first < xfoldAt }
                var left = partitioned.first.toMutableList()
                left.addAll(partitioned.second.map { Pair(it.first - 2*(it.first-xfoldAt),it.second)})
                coordis = left.toSet()
                println("X fold points" + coordis.size)
            }
        }
        println("coordis : "+coordis.sortedWith( compareBy({it.second},{it.first})))

        for (y in 0..5 ) {
            for(x in 0..38) {
                if (Pair(x, y) in coordis) {
                    print("#")
                } else {
                    print(".")
                }
            }
            println()

        }
        return 1
    }
            // test if implementation meets criteria from the description, like:

    val input = readInput("Day13_test")
    //println(part1(input))
    println(part2(input))
}

