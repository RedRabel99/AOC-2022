import java.io.File

fun main(args: Array<String>) {
    printResult(readInput("input.txt"))
}

fun readInput(fileName: String): List<String> =
    File(fileName).readLines()

fun printResult(inputList: List<String>){
    var currentSum = 0
    val listOfElves = mutableListOf<Int>()
    for(x in inputList){
        if (x.isEmpty()){
            listOfElves.add(currentSum)
            currentSum = 0
        } else currentSum += x.toInt()
    }
    listOfElves.sortDescending()
    println("Part1: ${listOfElves[0]}")
    println("Part2: ${listOfElves.slice(0..2).sum()}")
}