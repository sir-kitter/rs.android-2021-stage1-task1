package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        if(sadArray.size >= 3) {
            val result : MutableList<Int> = mutableListOf<Int>()

            result.add(sadArray.first())

            for(i in 1 until (sadArray.size - 1)) {
                if(result.last() + sadArray[i + 1] >= sadArray[i]) {
                    result += sadArray[i]
                }
            }

            result.add(sadArray.last())

            return if (result.size == sadArray.size) sadArray else convertToHappy(result.toIntArray())
        }

        return sadArray
    }
}
