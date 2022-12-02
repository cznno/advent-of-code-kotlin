import java.nio.file.Files
import java.nio.file.Path

object Day02 {
    private val map1 = mapOf("X" to 1, "Y" to 2, "Z" to 3)
    private val map2 = mapOf(
        "A X" to 3, "A Y" to 6, "A Z" to 0,
        "B X" to 0, "B Y" to 3, "B Z" to 6,
        "C X" to 6, "C Y" to 0, "C Z" to 3,
    )

    private val list = listOf(
        "001", "012", "020",
        "100", "111", "122",
        "202", "210", "221"
    )

    fun toDigi(t: String): Char {
        return when (t) {
            "X", "A" -> '0'
            "Y", "B" -> '1'
            else -> '2'
        }
    }

    fun part1(data: List<String>) {
        var sum = 0
        for (s in data) {
            val k = s.split(" ")
            val m = toDigi(k[0])
            val n = toDigi(k[1])
            for (t in list) {
                if (t[0] == m && t[1] == n) {
                    sum += when (t[1]) {
                        '0' -> 1
                        '1' -> 2
                        else -> 3
                    }
                    sum += when (t[2]) {
                        '0' -> 0
                        '1' -> 3
                        else -> 6
                    }
                }
            }
//            sum += map1[s.split(" ")[1]]!!
//            sum += map2[s]!!
        }
        println(sum) //8890
    }

    fun part2(data: List<String>) {
        var sum = 0
        for (s in data) {
            val k = s.split(" ")
            val m = toDigi(k[0])
            val n = toDigi(k[1])
            for (t in list) {
                if (t[0] == m && t[2] == n) {
                    sum += when (t[1]) {
                        '0' -> 1
                        '1' -> 2
                        else -> 3
                    }
                    sum += when (t[2]) {
                        '0' -> 0
                        '1' -> 3
                        else -> 6
                    }
                }
            }
        }
        println(sum)
    }
}

fun main() {
    val data = Files.readAllLines(Path.of("./input/Day02.txt"))

    Day02.part1(data)
    Day02.part2(data)
}
