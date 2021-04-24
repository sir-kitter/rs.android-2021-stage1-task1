package subtask4

class StringParser {
    private fun extract(s: String, opener: Char, closer: Char): String? {
        var depth: Int = 1
        s.forEachIndexed { i, c ->
            if (c == opener) ++depth
            if (c == closer) --depth
            if (depth == 0) return s.take(i)
        }
        return null
    }

    fun getResult(inputString: String): Array<String> {
        var result: MutableList<String> = mutableListOf()

        inputString.forEachIndexed { i, c ->
            val extracted: String? = when (c) {
                '(' -> extract(inputString.drop(i + 1), '(', ')')
                '[' -> extract(inputString.drop(i + 1), '[', ']')
                '<' -> extract(inputString.drop(i + 1), '<', '>')
                else -> null
            }
            if (extracted != null) result.add(extracted)
        }

        return result.toTypedArray()
    }
}
