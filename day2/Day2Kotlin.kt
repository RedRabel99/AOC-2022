import java.io.File

fun main() {
    printResult(readInput("input.txt"))
}

fun readInput(fileName: String): List<String> =
    File(fileName).readLines()

fun printResult(inputList: List<String>){
    var part1 = 0
    var part2 = 0
    for (line in inputList) {
        val columns = line.split(' ')
        val first = columns[0].first().code - 65
        val second = columns[1].first().code - 88

        part1 += when {
            first == second -> second + 4
            (first + 1) % 3 == second -> second + 7
            else -> second + 1
        }

        part2 += when(second){
            0 -> (first + 2) % 3 + 1 //lose
            1 -> (first + 4) //draw
            else -> (first + 1) % 3 + 7 //win
        }
    }
    println("Part1: $part1")
    println("Part2: $part2")
}