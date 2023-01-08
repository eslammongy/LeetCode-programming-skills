class Solution {

    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var countBits = 0
        var num = n

        for (i in 0..31) {
            if (num and 1 == 1)
                countBits++
            num = num ushr 1
        }

        return countBits
    }

    fun hammingWeight2(n:Int):Int {
        var count = 0
        var nums = n
        while(nums != 0){
            nums = nums and  (nums-1)
            count += 1
        }

        return count
    }
    fun numberOfDigits(n: Int): Int =
        when (n) {
            in -9..9 -> 1
            else -> 1 + numberOfDigits(n / 10)
        }

    fun subtractProductAndSum(n: Int): Int {

        if (n / 10 < 1) return 0
        val numTxt = n.toString()
        var sumDigits = 0
        var productDigits = 1
        for (i in numTxt.indices){
            sumDigits += numTxt[i].toString().toInt()
            productDigits *= numTxt[i].toString().toInt()
        }

        return productDigits - sumDigits
    }

    fun subtractProductAndSum2(n: Int): Int {
        var productDigits = 1
        var sumDigits = 0
        var num = n
        while (num > 0) {
            val remainder = num % 10
            sumDigits += remainder
            productDigits *= remainder
            num /= 10
        }
        return productDigits - sumDigits
    }

}