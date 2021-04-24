package subtask2

import java.lang.Integer.min
import java.lang.Integer.max


class MiniMaxSum {
    fun getResult(input: IntArray): IntArray {
        val sum: Int = input.sum()
        var minSum: Int = Int.MAX_VALUE
        var maxSum: Int = Int.MIN_VALUE

        for(value in input) {
            val sumMinus1: Int = sum - value
            minSum = min(minSum, sumMinus1)
            maxSum = max(maxSum, sumMinus1)
        }

        return intArrayOf(minSum, maxSum)
    }
}