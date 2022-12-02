package days.day2

import java.io.File
import java.util.*


fun main(args: Array<String>) {
    val data = File("src/main/kotlin/days/day2/input2").readText()
    val list = data.lines().map {
        it.split(" ")
    }

    val listOfSumPart1 = mutableListOf<Int>()
    list.forEach {
        val sum =  scoreForShape(it.last()) + scoreForRound(it.first(), transform(it.last()))
        listOfSumPart1.add(sum)
    }

    val listOfSumPart2 = mutableListOf<Int>()
    list.forEach {
        val sum = scoreForRound(it.first(), it.last()) + scoreForShape(whichShapeToChose(it.first(), it.last()))
            listOfSumPart2.add(sum)
    }

    println(listOfSumPart1.sum())
    println(listOfSumPart2.sum())
}



fun transform(second: String):String{
    return when(second){
        "X" -> "A"
        "Y" -> "B"
        else -> "C"
    }
}

fun scoreForRound(first: String, second: String): Int {
    val secondInt = when {
        second == "X" || (first == "A" && second == "C") ||
                (first == "B" && second == "A") ||
                (first == "C" && second == "B") -> 0
        second == "Y" || (first == "A" && second == "A") ||
                (first == "B" && second == "B") ||
                (first == "C" && second == "C") -> 3
        second == "Z" || (first == "A" && second == "B") ||
                (first == "B" && second == "C") ||
                (first == "C" && second == "A") -> 6
        else -> 0
    }
    return secondInt
}

fun scoreForShape(string: String): Int {
    return when (string) {
        "A", "X" -> 1
        "B", "Y" -> 2
        "C", "Z" -> 3
        else -> 0
    }
}

fun whichShapeToChose(first: String, second: String): String {
    var shape = ""
    when (second) {
        "X" -> {
            when (first) {
                "A" -> shape = "C"
                "B" -> shape = "A"
                "C" -> shape = "B"
            }
        }
        "Z" -> {
            when (first) {
                "A" -> shape = "B"
                "B" -> shape = "C"
                "C" -> shape = "A"
            }
        }
        "Y" -> {
            when (first) {
                "A" -> shape = "A"
                "B" -> shape = "B"
                "C" -> shape = "C"
            }
        }


    }
    return shape
}