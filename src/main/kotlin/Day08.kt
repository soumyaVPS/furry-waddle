fun main() {
    fun part1(input: List<String>): Int {
        val outputs = input.flatMap{ it.split("|")[1].trim().split(" ")}
        val letterCounts = listOf(2,3,4,7)

        return outputs.count{
             letterCounts.contains(it.length)
        }
    }

    fun part2(input: List<String>): Int {
        var sumOfAll = 0
        input.forEach { it ->
            val line = it.split("|")[0].trim().split(" ")
            val output = it.split("|")[1].trim().split(" ")
            val one = line.find { it.length == 2 }!!
            val seven = line.find { it.length == 3 }!!
            val four = line.find { it.length == 4 }!!
            val eight = line.find { it.length == 7 }!!
            val firstline = seven?.toCharArray()?.toList()?.minus(one?.toCharArray()?.toList())?.get(0)
            val nine = line.find { it.length == 6 && it.toSet().intersect(four.toSet()).size == 4 }!!
            val bottomline = nine.toSet().minus(four.toSet()).minus(firstline).first()
            val bottomLeft = eight.toSet().minus(four.toSet()).minus(firstline).minus(bottomline).first()
            val zero = line.find { it.length == 6 && it.toSet().containsAll(one.toSet()) && it != nine }!!
            // val topLeft = zero.toSet().minus(one.toSet()).minus(firstline).minus(bottomline).minus(bottomLeft).first()
            val middleLine = eight.toSet().minus(zero.toSet()).first()
            val two = line.find {
                it.length == 5 && it.contains(firstline)
                        && it.contains(middleLine) && it.contains(bottomline)
                        && it.contains(bottomLeft)
            }!!
            val three = line.find {
                it.length == 5 && it.contains(firstline)
                        && it.contains(middleLine) && it.contains(bottomline) &&
                        it.toSet().intersect(one.toSet()).size == 2
            }!!
            val fiveAndSix = line.minus(one).minus(two).minus(three).minus(four).minus(seven).minus(eight).minus(nine).minus(zero)
            println("fiveAndSix " + fiveAndSix)
            val five = fiveAndSix.find { it!!.length == 5 }!!
            val six = fiveAndSix.find { it!!.length == 6 }!!
            val seqMap = mapOf<String, Int>(
                one.toSortedSet().toString() to 1, two.toSortedSet().toString() to 2,
                three.toSortedSet().toString() to 3, four.toSortedSet().toString() to 4,
                five.toSortedSet().toString() to 5,
                six.toSortedSet().toString() to 6, seven.toSortedSet().toString() to 7, eight.toSortedSet().toString() to 8,
                nine.toSortedSet().toString() to 9, zero.toSortedSet().toString() to 0
            )
            val lineOut = output.fold(0) { acc, seq -> acc * 10 + seqMap.getOrDefault(seq.toSortedSet().toString(), 0) }
            println("SeqMap :"+ seqMap)

            println( output)
            println(lineOut)
            sumOfAll += lineOut
        }
        return sumOfAll
    }
            // test if implementation meets criteria from the description, like:

    val input = readInput("Day08_test")
    println(part1(input))
    println(part2(input))
}

