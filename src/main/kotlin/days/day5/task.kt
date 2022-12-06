package days.day5

import java.io.File

fun main(args: Array<String>) {
    val data = File("src/main/kotlin/days/day5/input5").readText()
    val (stacks, tasks) = data.split("\n\n")
    val rearrrangedStacks = mutableListOf<MutableList<Char>>()
    val sizeOfRearrangedStack = stacks.lines().last().length
    (0..sizeOfRearrangedStack).forEach { rearrrangedStacks.add(mutableListOf()) }

    stacks.lines().forEach { line ->
        line.toList().forEachIndexed { index, char ->
            rearrrangedStacks[index].add(char)
        }
    }
    val listOfCrates = rearrrangedStacks
        .filter { it.last().isDigit() }
        .map { it.dropLast(1) }
        .map {
            it.filter { char -> char.isWhitespace().not() }
                .reversed()
                .toMutableList()
        }

    val listOfTasks = tasks.lines().map { line ->
        val list = line.split(" ")
        val regexNumber = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        list.filter { it.matches(regexNumber) }
            .map { it.toInt() }
    }

    val finalList = listOfCrates.toMutableList()
    listOfTasks.forEach { task ->
        moveCrate(howManyCrates = task.first(), from = task[1], to = task.last(), finalList)
    }
    finalList.forEach {
        print(it.last())
    }

}

fun moveCrate(howManyCrates: Int, from: Int, to: Int, list: MutableList<MutableList<Char>>) {

    val fromStack = list[from - 1]
    if (howManyCrates == 1) {
       // val fromStack = list[from - 1]
        val char = fromStack.last()
        fromStack.removeAt(fromStack.lastIndex)
        list[to - 1].add(char)
    }
    else {
       // val fromStack = list[from - 1]
        val chars = list[from-1].takeLast(howManyCrates)
        list[from-1] = fromStack.dropLast(howManyCrates).toMutableList()
        list[to - 1].addAll(chars)
    }
}