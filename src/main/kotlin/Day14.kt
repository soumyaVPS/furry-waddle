import java.lang.Integer.MAX_VALUE
import java.lang.Integer.MIN_VALUE
import java.math.BigInteger
import java.util.concurrent.ConcurrentHashMap


val BigOne = BigInteger("1")
val BigZero = BigInteger("0")
val BigMax = BigInteger("40")

fun main() {
    fun part1(input: List<String>): Int {
        var polymer = input.first()
        val rules = input.drop(2).map{it.split(" -> ").zipWithNext().first()}.toMap()
        println("Rules "+ rules)
        repeat(10) {
            var newPolymer = ""
            polymer.zipWithNext().forEach {
                println(it)
                newPolymer += listOf(it.first,rules[it.toList().joinToString("")]).joinToString("")
            }
            polymer = newPolymer
            println(polymer)
            println("length "+polymer.length)
        }

        val polymerChars = polymer.toCharArray()
       val elements = polymerChars.toSet()
        var min = MAX_VALUE
        var max = MIN_VALUE
        for (e in elements) {
            val count =polymerChars.count{it==e}
            if (min>count) {
                min = count
            }
            if (max<count) {
                max = count
            }
        }
        println ("max and min "+ max + " " + min)
        return max-min
    }

    fun part2(input: List<String>): BigInteger? {
            var polymer = input.first()
            val rules = input.drop(2).map{it.split(" -> ").zipWithNext().first()}.toMap()
            println("Rules "+ rules)

            val countMap = mutableMapOf<Char, BigInteger> ()
            polymer.toCharArray().forEach {
                countMap.set(it, countMap.getOrDefault(it, BigZero).add(BigOne))
            }

        val map = ConcurrentHashMap<Pair<String, BigInteger>,  MutableMap<Char, BigInteger>>()

        fun  memoize(fn: (Pair<String, BigInteger>) -> MutableMap<Char,BigInteger>): (Pair<String,BigInteger>) -> MutableMap<Char,BigInteger> {
            return { a ->
                map.getOrPut(a) {
                    fn(a)
                }
            }
        }


        fun mergeMaps(toMap:MutableMap<Char,BigInteger>, fromMap:MutableMap<Char,BigInteger>){
            for (entry in fromMap) {
                toMap.set(entry.key,toMap.getOrDefault(entry.key,BigZero).add(entry.value))
            }
        }

        fun recurs ( pairDepth : Pair<String,BigInteger>): MutableMap<Char,BigInteger>{
            val memoized = memoize(::recurs)
            println("Recurs depth "+pairDepth.second)
            if (pairDepth.second.equals(BigMax)) {
                return mutableMapOf()
            }
            val ch = rules.get(pairDepth.first)!!
            val charCounts = mutableMapOf(ch.first() to BigOne)
            mergeMaps ( charCounts,memoized(Pair(""+pairDepth.first[0]+ch.first(), pairDepth.second.add(BigOne))))
            mergeMaps (charCounts, memoized(Pair(""+ch.first()+pairDepth.first[1], pairDepth.second.add(BigOne))))
            return charCounts

        }


        polymer.zipWithNext().forEach {
            val memoized = memoize(::recurs)

            mergeMaps(countMap, memoized(Pair(it.toList().joinToString(""),BigZero)))
            }

            var min = countMap.minOf { it.value }
            var max = countMap.maxOf { it.value }

            println ("max and min "+ max + " " + min)
            return max.subtract(min)
        }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day14_test")
   // println(part1(input))
    println(part2(input))
}


