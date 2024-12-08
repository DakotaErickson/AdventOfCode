import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val listOne = mutableListOf<Int>()
        val listTwo = mutableListOf<Int>()
        var difference = 0
        input.forEach { line ->
            val splitLine = line.split(" ").filter { it.isNotBlank() }
            if (splitLine.size > 1) {
                listOne.add(splitLine[0].toInt())
                listTwo.add(splitLine[1].toInt())
            }
        }
        listOne.sort()
        listTwo.sort()

        listOne.forEachIndexed { index, number ->
            difference += abs(number - listTwo[index])
        }
        return difference
    }

    fun part2(input: List<String>): Int {
        var similarity = 0
        val listOne = mutableListOf<Int>()
        val listTwo = mutableListOf<Int>()
        input.forEach { line ->
            val splitLine = line.split(" ").filter { it.isNotBlank() }
            if (splitLine.size > 1) {
                listOne.add(splitLine[0].toInt())
                listTwo.add(splitLine[1].toInt())
            }
        }
        val listTwoCounts = listTwo.groupingBy { it }.eachCount()

        listOne.forEach {
            similarity += listTwoCounts[it]?.times(it) ?: 0
        }

        return similarity
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
