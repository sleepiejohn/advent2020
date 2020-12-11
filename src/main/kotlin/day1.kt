import Lists.genCombinations
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue
import kotlin.system.measureTimeMillis

object Day1 : Day<Int> {
    override fun number() = 1

    override fun firstPart(input: List<Int>): String {
        return input.multiplyCombinationsSummingGoal(2).toString()
    }

    override fun secondPart(input: List<Int>): String {
        return input.multiplyCombinationsSummingGoal(3).toString()
    }

    private fun List<Int>.multiplyCombinationsSummingGoal(combinations: Int) =
        this.genCombinations(combinations).multiplySummingGoal(2020)


    private fun List<List<Int>>.multiplySummingGoal(goal: Int): Int {
        return this.find { it.sum() == goal }?.reduce { acc, i -> acc * i } ?: 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        Day1.run(Day.Mode.BOTH) { it.toInt() }
    }
}

