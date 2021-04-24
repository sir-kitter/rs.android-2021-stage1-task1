package subtask5

class HighestPalindrome {
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val digits: CharArray = digitString.toCharArray()
        var diffCount: Int = 0

        for (i in 0 until n / 2) {
            if (digits[i] != digits[n - i - 1]) ++diffCount
        }
        if (diffCount > k) return "-1"

        var bonus: Int = k - diffCount
        for (i in 0 until n / 2) {
            val nines = (if (digits[i] == '9') 1 else 0) + (if (digits[n - i - 1] == '9') 1 else 0)
            val comparison = digits[i].compareTo(digits[n - i - 1])
            when {
                nines == 1 -> {
                    digits[i] = '9'
                    digits[n - i - 1] = '9'
                    --diffCount
                }
                nines == 2 -> {
                }
                bonus >= 1 -> {
                    digits[i] = '9'
                    digits[n - i - 1] = '9'
                    --bonus
                    --diffCount
                }
                comparison == 0 -> {
                }
                comparison < 0 -> {
                    digits[i] = digits[n - i - 1]
                    --diffCount
                }
                comparison > 0 -> {
                    digits[n - i - 1] = digits[i]
                    --diffCount
                }
            }
        }
        if (bonus >= 1 && (n and 1 == 1)) digits[n / 2] = '9'

        return String(digits)
    }
}
