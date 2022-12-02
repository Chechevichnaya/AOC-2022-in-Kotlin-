import java.io.File


fun main(args: Array<String>) {
    val data = File("src/input").readText()
    println(getSum(data))
}

fun getSum(data: String): Int {
    val list = data.split("\n\n")
        .map {
            it.split("\n")
                .map { stringNum -> stringNum.toInt() }
        }
    return list.maxOf { it.sum() }
}
