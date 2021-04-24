package subtask3

class BillCounter {
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val shouldPay = (bill.sum() - bill[k]) / 2
        return if (b <= shouldPay) "Bon Appetit" else (b - shouldPay).toString()
    }
}
