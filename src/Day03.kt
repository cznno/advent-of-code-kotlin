import java.nio.file.Files
import java.nio.file.Path

object Day03 {
    fun part1(data: List<String>) {
        data.map {
            Pair(it.substring(0, it.length / 2).toHashSet(), it.substring(it.length / 2))
        }
            .map {
                it.first.first { char -> it.second.contains(char) }
            }
            .let { doSum(it) }
    }

    fun part2(data: List<String>) {
        data.chunked(3).map { arr ->
            arr[0].toHashSet().filter { arr[1].contains(it) }
                .toHashSet().first { arr[2].contains(it) }
        }
            .let { doSum(it) }

    }

    private fun doSum(list: List<Char>) {
        list.map {
            when (it.code) {
                in (97..122) -> it.code - 96
                else -> it.code - 38
            }
        }
            .sum()
            .let { println(it) }
    }
}

fun main() {
    val data = Files.readAllLines(Path.of("./input/Day03.txt"))
    Day03.part1(data)
    Day03.part2(data)
}