import java.nio.file.Files
import java.nio.file.Path

object Day04 {
    fun part1(data: List<String>) {
        data.map {
            val split = it.split(Regex("[,|-]")).map { s -> s.toInt() }
            when {
                split[0] <= split[2] && split[1] >= split[3] -> 1
                split[0] >= split[2] && split[1] <= split[3] -> 1
                else -> 0
            }
        }
            .sum()
            .let { println(it) }
    }

    fun part2(data: List<String>) {
        data.map {
            val split = it.split(Regex("[,|-]")).map { s -> s.toInt() }
            when {
                split[0] <= split[2] && split[1] >= split[2] -> 1
                split[0] >= split[2] && split[0] <= split[3] -> 1
                else -> 0
            }
        }
            .sum()
            .let { println(it) }
    }
}

fun main() {
    val data = Files.readAllLines(Path.of("./input/Day04.txt"))
    Day04.part1(data)
    Day04.part2(data)
}