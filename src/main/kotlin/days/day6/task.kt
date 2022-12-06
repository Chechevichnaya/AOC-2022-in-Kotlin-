package days.day6

import java.io.File

fun main(args: Array<String>) {
    val data = File("src/main/kotlin/days/day6/input").readText()
    val list4Symbols = mutableListOf<Char>()
    val fourList = mapList(data.toMutableList(), list4Symbols)
    println(fourList)
}

fun mapList(oldList: MutableList<Char>, newList: MutableList<Char>):
        Int {
    var indexStart = 0
    var sizeOfResult = 0
    while (newList.size != 14) {
        run findFour@ {
        run cycle@{
            oldList.forEach { char ->
                if (newList.size == 14) return@findFour
                if (newList.contains(char).not()) {
                    newList.add(char)
                    println("newlist = $newList")
                } else {
                    indexStart = oldList.indexOf(char)
                    println("indexStart $indexStart")
                    newList.clear()
                    return@cycle
                }
            }
        }
        val result = oldList.drop(indexStart + 1)

        sizeOfResult += (indexStart + 1)
        println("howmany drop $sizeOfResult")
        oldList.clear()
        oldList.addAll(result)
    }}
    return sizeOfResult + 14
}
