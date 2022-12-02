import java.io.File


fun main(args: Array<String>) {
    val data = File("src/main/kotlin/days/day1/input").readText()
    println(getNMax(3, getListOfSum(data)))
}

fun getListOfSum(data: String): List<Int> {
    val list = data.split("\n\n")
        .map {
            it.split("\n")
                .map { stringNum -> stringNum.toInt() }
        }
    return list.map { it.sum() }
}

fun getNMax(n: Int, list: List<Int>): Int {
    return list.sortedDescending().take(n).sum()
}
