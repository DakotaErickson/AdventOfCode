import kotlin.reflect.typeOf

fun main() {
    fun parseMul(input: List<String>): Sequence<MatchResult> {
        val regex = Regex(pattern = "mul\\(\\d{1,3},\\d{1,3}\\)", RegexOption.MULTILINE)
        val match = input.joinToString(separator = "\n").let { regex.findAll(it) }
        return match
    }

    fun parseOperands(input: MatchResult): Pair<Int, Int> {
        val regex = Regex("\\d+")
        val numbers = regex.findAll(input.value).map { it.value.toInt() }.toList()
        return numbers.take(2).let { (num1, num2) -> num1 to num2 }
    }

    fun mul(a: Int, b: Int): Int = a * b

    fun part1(input: List<String>): Int {
        var result = 0
        val matches = parseMul(input)
        matches.forEach {
            val (num1, num2) = parseOperands(it)
            result += mul(num1, num2)
        }

        return result
    }

    fun parseInstructions(input: String): List<Pair<Int, Int>> {
        val regex = Regex("""(mul\(\d{1,3},\d{1,3}\))|(do\(\))|(don't\(\))""")
        val matches = regex.findAll(input)

        val result = mutableListOf<Pair<Int, Int>>()
        var isDisabled = false

        for (match in matches) {
            when (match.value) {
                "do()" -> isDisabled = false
                "don't()" -> isDisabled = true
                else -> {
                    if (!isDisabled) {
                        val (num1, num2) = parseOperands(match)
                        result.add(num1 to num2)
                    }
                }
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        val operations = parseInstructions(input.joinToString { it })

        operations.forEach {
            result += mul(it.first, it.second)
        }

        return result
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
