fun main() {


    fun position( input : List<Pair<String,String>>, d  : Int,  h: Int ) : Pair<Int,Int>{
       return if(input.isNotEmpty()){
           when {
               input.first().first == "down"->
                   position(input.drop(1), d+input.first().second.toInt(), h)
               input.first().first == "up"->
                   position(input.drop(1), d-input.first().second.toInt(), h)
               input.first().first == "forward"->
                   position(input.drop(1), d, h+input.first().second.toInt())
               else ->
                   throw Exception("Invalid input")
           }
       } else {
           Pair(d,h)
       }

    }
    fun part1(input: List<String>): Int {
        return position(input.map{it.split(" ").let{Pair(it.first(), it.last())}}, 0,0).let{
            println(" " + it.first+ " " +it.second)
            it.first*it.second
        }
    }
    fun position2( input : List<Pair<String,String>>,aim: Int,  d  : Int,  h: Int ) : Pair<Int,Int>{
        return if(input.isNotEmpty()){
            val current = input.first().second.toInt()
            when {
                input.first().first == "down"->
                    position2(input.drop(1), aim+current, d, h)
                input.first().first == "up"->
                    position2(input.drop(1), aim-current, d, h)
                input.first().first == "forward"->
                    position2(input.drop(1), aim, d + aim*current, h+current)
                else ->
                    throw Exception("Invalid input")
            }
        } else {
            Pair(d,h)
        }

    }
    fun part2(input: List<String>): Int {
        return position2(input.map{it.split(" ").let{Pair(it.first(), it.last())}}, 0, 0,0).let{
            println(" " + it.first+ " " +it.second)
            it.first*it.second
        }    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day02_test")
    println(part1(input))
    println(part2(input))
}

