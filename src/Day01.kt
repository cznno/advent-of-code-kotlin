import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import java.util.Collections.reverseOrder


fun part1(data: List<String>) {
    var max = 0
    var sum = 0
    for (s in data) {
        if (s.isNotBlank()) {
            sum += s.toInt()
        } else {
            if (sum > max) {
                max = sum
            }
            sum = 0
        }
    }
    println(max)
}

fun part2(data: List<String>) {
    val max = PriorityQueue<Int>(4)
    var sum = 0
    for (s in data) {
        if (s.isNotBlank()) {
            sum += s.toInt()
        } else {
            if (max.size < 3) {
                max.offer(sum)
            } else if (max.peek() < sum) {
                max.poll()
                max.offer(sum)
            }
            sum = 0
        }
    }
    println(max.sum())
}

fun main() {
    val data = Files.readAllLines(Path.of("./input/Day01.txt"))

    part1(data)
    part2(data)
}
