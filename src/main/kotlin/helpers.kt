import Lists.genCombinations
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.asSequence

object Input {
    fun readLinesForDay(day: Int): Sequence<String> =
        javaClass.getResource("/inputs/${day}.txt").let {
            val uri = it.toURI()
            val path = Paths.get(uri)
            Files.lines(path).asSequence()
        }
}

object Lists {
    fun <T> List<T>.genCombinations(num: Int): List<List<T>> =
        if (num == 1) this.map(::listOf)
        else this.flatMap { comb -> genCombinations(num - 1).map { listOf(comb) + it }}

    fun <T> List<T>.inspect(): List<T> = this.map {
        println(it)
        it
    }

}



fun main() {
    listOf(1,2,3).genCombinations(2).forEach(::println)
}
