package days.day4

import java.io.File

fun main(args: Array<String>) {
    val data = File("src/main/kotlin/days/day4/input4").readText()
    val result = data.lines()
        .sumOf { line ->
            val (firstRange, secondRange) = line.split(",")
            checkTwoRangesTask1(firstRange, secondRange)
        }
    val result2 = data.lines()
        .sumOf { line ->
            val (firstRange, secondRange) = line.split(",")
            checkTwoRangesTask2(firstRange, secondRange)
        }

    println(result)
    println(result2)

}

fun checkTwoRangesTask1(firstRange: String, secondRange: String): Int {
    val (firstRangeFirstNum, firstRangeSecNum) = firstRange.split("-").map { it.toInt() }
    val (secRangeFirstNum, secRangeSecNum) = secondRange.split("-").map { it.toInt() }
    return if ((firstRangeFirstNum <= secRangeFirstNum && firstRangeSecNum >= secRangeSecNum) ||
        (firstRangeFirstNum >= secRangeFirstNum && firstRangeSecNum <= secRangeSecNum)
    ) 1
    else 0

}

fun checkTwoRangesTask2(first: String, second: String): Int {
    val (firstRangeFirstNum, firstRangeSecNum) = first.split("-").map { it.toInt() }
    val (secRangeFirstNum, secRangeSecNum) = second.split("-").map { it.toInt() }
    val secRange = secRangeFirstNum..secRangeSecNum
    val firstRange = firstRangeFirstNum..firstRangeSecNum
    return if ((firstRangeFirstNum in secRange || firstRangeSecNum in secRange) ||
        (secRangeFirstNum in firstRange || secRangeSecNum in firstRange)
    ) 1
    else 0

}