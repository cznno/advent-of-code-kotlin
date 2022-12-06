import java.nio.file.Files
import java.nio.file.Path
import java.util.*

//FCVRLMVQP
//RWLWGJGFD
class Day05(val data: List<String>) {
    private val regex = Regex("(?<= )\\d+")
    private val crane = Array(10) { LinkedList<Char>() }
    private var ops: List<Triple<Int, Int, Int>> = listOf()

    private fun init() {
        data.take(8)
            .map { it.padEnd(36, ' ') }
            .forEach {
                (1..33 step 4).forEachIndexed { i, k ->
                    if (it[k].isLetter()) {
                        crane[i + 1].push(it[k])
                    }
                }
            }

        this.ops = data.drop(10)
            .map { s ->
                regex.findAll(s).map { it.groupValues[0] }.iterator()
                    .run {
                        Triple(next().toInt(), next().toInt(), next().toInt())
                    }
            }
    }

    fun part1() {
        init()
        ops.forEach { (move, from, to) ->
            repeat(move) { crane[to].offer(crane[from].pollLast()) }
        }
        crane.filter { it.isNotEmpty() }.forEach { print(it.pollLast()) }
    }

    fun part2() {
        init()
        ops.forEach { (move, from, to) ->
            val list = (1..move).map { crane[from].pollLast() }.reversed()
            crane[to].addAll(list)
        }
        crane.filter { it.isNotEmpty() }.forEach { print(it.pollLast()) }
    }
}

fun main() {
    val data = Files.readAllLines(Path.of("./input/Day05.txt"))

    Day05(data).part1()
    println()
    Day05(data).part2()
    println()
}