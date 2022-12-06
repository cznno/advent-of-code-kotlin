import java.nio.file.Files
import java.nio.file.Path

object Day06 {
    private fun find(data: String, size: Int) {
        data.windowed(size, 1)
            .mapIndexed { index, s ->
                Pair(index, s.toSet())
            }
            .first { (_, set) -> set.size == size }
            .let { println(it.first + size) }
    }

    fun part1(data: String) {
        find(data, 4)
    }

    fun part2(data: String) {
        find(data, 14)
    }
}

fun main() {
    val data = Files.readString(Path.of("./input/Day06.txt"))

    Day06.part1(data)
    Day06.part2(data)
}