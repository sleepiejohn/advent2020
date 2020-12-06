import java.time.Clock

interface Day<T> {


    enum class Mode {
        FIRST, SECOND, BOTH
    }

    fun number(): Int
    fun firstPart(input: List<T>): String
    fun secondPart(input: List<T>): String

    fun input(transformer: (String) -> T): List<T> =
        Input.readLinesForDay(number()).map(transformer).toList()

    private fun timed(f: () -> String): Pair<String, Long> {
        val s = System.currentTimeMillis()
        val r = f()
        val e = System.currentTimeMillis()
        return Pair(r, e - s)
    }

    fun run(mode: Mode, transformer: (String) -> T): Unit {
        val input = input(transformer)
        when (mode) {
            Mode.FIRST -> {
                val (result, time) = timed { firstPart(input) }
                println("First part yields the result: $result in $time ms ")
            }
            Mode.SECOND -> {
                val (result, time) = timed { secondPart(input) }
                println("Second part yields the result: $result in $time ms ")
            }
            Mode.BOTH -> {
                run(Mode.FIRST, transformer)
                run(Mode.SECOND, transformer)
            }
        }
    }
}