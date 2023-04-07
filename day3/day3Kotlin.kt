import java.io.File

fun main() {
    printResult(readInput("input.txt"))
}

fun readInput(fileName: String): List<String> =
    File(fileName).readLines()

fun printResult(inputList: List<String>){
    var part1 = 0
    var part2 = 0
    for((i, line) in inputList.withIndex()){
        val comparmentSize = line.length / 2
        val firstComparment = line.slice(0 until comparmentSize).toSet()
        val secondComparment = line.slice(comparmentSize until line.length).toSet()

        part1 += firstComparment.sumOf {
            if (secondComparment.contains(it)) GetLetterValue(it) else 0
        }

        if((i + 1) % 3 == 0){
            part2 += inputList[i - 2].toSet().sumOf {
                if (inputList[i -1].contains(it) and inputList[i].contains(it))
                    GetLetterValue(it) else 0
            }
        }
    }
    println(part1)
    println(part2)
}

fun GetLetterValue (letter: Char): Int{
   return if (letter.isLowerCase()) letter.code - 96 else letter.code - 38
}