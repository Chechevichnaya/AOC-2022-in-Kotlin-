package days.day3

import java.io.File

fun main(args: Array<String>) {
    val data = File("src/main/kotlin/days/day3/input3").readText()
    val listOfIntTask1 = mutableListOf<Int>()
    data.lines().map { ruksack ->
        val ruksackParts = ruksack.chunked(ruksack.length / 2)
        val commonElement = transform(
            ruksackParts.first().toSet().intersect(ruksackParts.last().toSet()).first()
        )
        listOfIntTask1.add(commonElement)
    }

    val listOfIntTask2 = mutableListOf<Int>()
    data.lines().chunked(3)
        .map { groupOfElfs ->
            val commonFirstSecond = groupOfElfs.first().toSet().intersect(groupOfElfs[1].toSet())
            val commonSecondThird = groupOfElfs[1].toSet().intersect(groupOfElfs.last().toSet())
            val common = transform(commonFirstSecond.intersect(commonSecondThird).first())
            listOfIntTask2.add(common)
        }



    println(listOfIntTask1.sum())
    println(listOfIntTask2.sum())
}

fun transform(element: Char): Int {
    val alfabet = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toList()
    return alfabet.indexOf(element)
}