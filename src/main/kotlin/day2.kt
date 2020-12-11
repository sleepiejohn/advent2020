private typealias Policy = (low: Int, high: Int, letter: Char, text: String) -> Boolean

object Day2 : Day<String> {

    override fun number() = 2

    override fun firstPart(input: List<String>): String =
         PasswordPolicies.withinPolicy(input, PasswordPolicies::oldPolicy).toString()

    override fun secondPart(input: List<String>): String =
         PasswordPolicies.withinPolicy(input, PasswordPolicies::newPolicy).toString()

    private object PasswordPolicies {

        private val lineRegex = Regex("(\\d+)-(\\d+) (\\w): (\\w+)")

        fun oldPolicy(low: Int, high: Int, letter: Char, text: String) =
            text.count { it == letter } in low..high
        fun newPolicy(low: Int, high: Int, letter: Char, text: String) =
            (text[low - 1] == letter) != (text[high - 1] == letter)

        fun withinPolicy(input: List<String>, policy: Policy) =
            input.filter {
                val (low, high, letter, pass) = lineRegex.find(it)!!.destructured
                policy(low.toInt(), high.toInt(), letter[0], pass)
            }.count()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        Day2.run(Day.Mode.BOTH) { it }
    }
}
