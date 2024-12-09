import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var safeCount = 0
        for (line in input) {
            val list = line.split(" ")
            val isIncreasing = list[0].toInt() < list[1].toInt()
            var i = 0

            while (i < list.size - 1) {

                // a line is unsafe if it changes from increasing to decreasing
                if (isIncreasing && (list[i].toInt() > list[i+1].toInt())) {
                    break
                }
                // a line is unsafe if it changes from decreasing to increasing
                if (!isIncreasing && list[i].toInt() < list[i+1].toInt()) {
                    break
                }
                // a line is unsafe if it moves more than 3 between adjacent numbers
                if (abs(list[i].toInt() - list[i+1].toInt()) > 3) {
                    break
                }
                // a line is unsafe if it doesn't change from one number to the next
                if (list[i].toInt() == list[i+1].toInt()) {
                    break
                }

                i += 1
            }

            // a line is safe if we've passed all the previous checks
            if (i == list.size - 1) {
                safeCount += 1
            }
        }
        return safeCount
    }

    fun part2(input: List<String>): Int {
        println(input)
        return 0
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
//    part2(input).println()
}
