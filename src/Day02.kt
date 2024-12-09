import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var safeCount = 0
        for (line in input) {
            val list = line.split(" ").map { it.toInt() }
            val isIncreasing = list[0] < list[1]
            var i = 0

            while (i < list.size - 1) {

                // a line is unsafe if it changes from increasing to decreasing
                if (isIncreasing && (list[i] > list[i+1])) {
                    break
                }
                // a line is unsafe if it changes from decreasing to increasing
                if (!isIncreasing && list[i] < list[i+1]) {
                    break
                }
                // a line is unsafe if it moves more than 3 between adjacent numbers
                if (abs(list[i] - list[i+1]) > 3) {
                    break
                }
                // a line is unsafe if it doesn't change from one number to the next
                if (list[i] == list[i+1]) {
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
        var safeCount = 0

        for (line in input) {
            val list = line.split(" ").map { it.toInt() }
            val isIncreasing = list[0] < list[1]
            var i = 0
            var unsafeLevels = 0

            while (i < list.size - 1) {

                // a line is unsafe if it changes from increasing to decreasing
                if (isIncreasing && (list[i] > list[i+1])) {
                    unsafeLevels += 1
                    if (unsafeLevels > 1) {
                        break
                    }
                }
                // a line is unsafe if it changes from decreasing to increasing
                if (!isIncreasing && list[i] < list[i+1]) {
                    unsafeLevels += 1
                    if (unsafeLevels > 1) {
                        break
                    }
                }
                // a line is unsafe if it moves more than 3 between adjacent numbers
                if (abs(list[i] - list[i+1]) > 3) {
                    unsafeLevels += 1
                    if (unsafeLevels > 1) {
                        break
                    }
                }
                // a line is unsafe if it doesn't change from one number to the next
                if (list[i] == list[i+1]) {
                    unsafeLevels += 1
                    if (unsafeLevels > 1) {
                        break
                    }
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

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
