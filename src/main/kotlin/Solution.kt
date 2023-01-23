import java.util.*
import kotlin.math.abs

class Solution {

    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var countBits = 0
        var num = n

        for (i in 0..31) {
            if (num and 1 == 1)
                countBits++
            num = num ushr 1
        }

        return countBits
    }

    fun hammingWeight2(n: Int): Int {
        var count = 0
        var nums = n
        while (nums != 0) {
            nums = nums and (nums - 1)
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
        for (i in numTxt.indices) {
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

    fun largestPerimeter(nums: IntArray): Int {
        if (nums.size < 3) return 0

        var perimeter = 0
        //nums.sort()

        if (nums.size == 3 && nums[0] + nums[1] > nums[2]) {
            perimeter = nums[0] + nums[1] + nums[2]
            println("perimeter = $perimeter")
            return perimeter
        }
        // 1, 2, 1, 10
        for (i in 1 until nums.size - 1) {
            if (nums[i - 1] + nums[i] > nums[i + if (i == nums.size - 1) 0 else 1]) {
                perimeter = nums[i] + nums[i - 1] + nums[i + if (i == nums.size - 1) 0 else 1]
            }
            if (nums[i] + nums[i - 1] > nums[i + if (i == nums.size - 1) 0 else 1]) {
                perimeter = nums[i] + nums[i - 1] + nums[i + if (i == nums.size - 1) 0 else 1]
            } else {
                continue
            }
        }
        return perimeter
    }

    fun largestPerimeter2(nums: IntArray): Int {
        if (nums.size < 3) return 0
        //[3,2,3,4]
        nums.sort()
        //[2, 3, 3, 4]
        println(nums.toList())
        if (nums.size == 3 && nums[0] + nums[1] > nums[2]) {
            return nums[0] + nums[1] + nums[2]
        }

        for (i in nums.size - 1 downTo 2) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i]
            }
        }
        return 0
    }

    private fun doQuickSort(array: IntArray): IntArray {
        if (array.size < 2) return array
        val greeterList = mutableListOf<Int>()
        val lessList = mutableListOf<Int>()
        var equalItem = 0
        val pivot = array[array.size / 2]
        for (item in array) {
            if (item < pivot) {
                lessList.add(item)
            }
            if (item > pivot) {
                greeterList.add(item)
            }
            if (item == pivot) {
                equalItem = item
            }
        }

        return doQuickSort(lessList.toIntArray()) + equalItem + doQuickSort(greeterList.toIntArray()) // 4
    }

    //Input: x = 1, y = 1, points = //[[1,2],[3,3],[3,3]]
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        var distance = 0
        var smallestDisIndex = 0
        var validDistance = Int.MAX_VALUE
        for (i in points.indices) {

            if (x == points[i][0] || y == points[i][1]) {
                val currentDis = abs(x - points[i][0]) + abs(y - points[i][1])
                if (currentDis < validDistance) {
                    validDistance = currentDis
                    smallestDisIndex = i
                }
            } else {
                distance = -1
            }
            if (x == points[i][0] && y == points[i][1]) {
                distance = 0
            }
        }

        return if (smallestDisIndex > 0 || validDistance != Int.MAX_VALUE) {
            smallestDisIndex
        } else if (distance != -1) {
            0
        } else {
            -1
        }
    }

    fun nearestValidPoint2(x: Int, y: Int, points: Array<IntArray>): Int {
        //Input: x = 1, y = 1, points = //[[1,2],[3,3],[3,3]]
        var nearestPoint = -1
        var validDistance = Int.MAX_VALUE
        for (i in points.indices) {

            if (((points[i][0] - x) * (points[i][1] - y) == 0)) {
                val currentDis = abs(x - points[i][0]) + abs(y - points[i][1])
                if (currentDis < validDistance) {
                    validDistance = currentDis
                    nearestPoint = i
                }
            }
        }
        return nearestPoint
    }

    fun arraySign(nums: IntArray): Int {
        var isNegative = false
        for (num in nums) {
            if (num == 0) return 0
            if (num < 0) isNegative = !isNegative
        }
        return if (isNegative) -1 else 1
    }

    fun canMakeArithmeticProgression(nums: IntArray): Boolean {
        var result = false
        nums.sort()
        val diff = nums[0] - nums[1] //-4
        for (i in 0..nums.size - 2) {
            println("The diff ${nums[i] - nums[i + 1]}")
            if (nums[i] == nums[i + 1]) result = true
            result = nums[i] - nums[i + 1] == diff
            if (!result) return false
        }

        return result
    }

    fun canMakeArithmeticProgression2(nums: IntArray): Boolean {

        Arrays.sort(nums)
        val diff = nums[1] - nums[0] //-4
        for (i in 1 until nums.size - 1) {
            if (nums[i + 1] - nums[i] != diff) return false

        }

        return true
    }

    /*Get the sum of the digits squared first*/
    private fun sumSquareNumberDigits(n: Int): Int {
        var num = n
        var total = 0
        while (num > 0) {
            val remainder = num % 10
            num /= 10
            total += remainder * remainder
        }
        return total
    }

    fun isHappy(n: Int): Boolean {
        var num = n
        val seenValues = HashSet<Int>()
        // Make sure we don't go to the same values again
        while (num != 1 && !(seenValues.contains(num))) {
            seenValues.add(num)
            num = sumSquareNumberDigits(num)
        }
        return num == 1
    }

    fun areAlmostEqual(s1: String, s2: String): Boolean {
        // check if the two strings are already equal or not
        if (s1 == s2) return true
        //looping throw string indices and do swapping operation at most once then check if thw two strings after swapping operation equal or not
        for (i in s2.indices) {
            val swappedString = swapChar(i, s2.lastIndex, s2)
            return s1 == swappedString
        }
        return false
    }

    private fun swapChar(oldIndex: Int, newIndex: Int, word: String): String {

        val charList = word.toMutableList()
        val temp = charList[oldIndex]
        charList[oldIndex] = charList[newIndex]
        charList[newIndex] = temp

        println(
            "Word -> ${
                charList.joinToString(separator = "")
            }"
        )


        return charList.joinToString(separator = "")
    }

    /* let count = 0, arr1 = [], arr2 = []
    for (let i = 0; i < s1.length; i++) {
        if (s1[i] !== s2[i]) {
            arr1.push(s1[i])
            arr2.push(s2[i])
            count++
        }
        if (count > 2)
            return false
    }
    if (count === 2) {
        return JSON.stringify(arr1.sort()) === JSON.stringify(arr2.sort())
    }
    return count === 0*/
    fun areAlmostEqual2(s1: String, s2: String): Boolean {
        var count = 0
        val arr1 = mutableListOf<Char>()
        val arr2 = mutableListOf<Char>()
        for (i in s1.indices) {
            if (s1[i] != s2[i]) {
                arr1.add(s1[i])
                arr2.add(s2[i])
                count++

            }
            if (count > 2) return false
        }

        if (count == 2) {

            return arr1.sort().toString() == arr2.sort().toString()
        }
        return count == 0
    }

    fun areAlmostEqual1(s1: String, s2: String): Boolean {
        if (s1 == s2) return true
        var index1 = -1
        var index2 = -1
        for (i in s1.indices) {
            if (s1[i] != s2[i]) {
                if (index1 == -1) {
                    index1 = i
                } else if (index2 == -1) {
                    index2 = i
                } else {
                    return false
                }
            }
        }
        if (index1 < 0) return true;
        if (index2 < 0) return false;
        if (s1[index1] == s2[index2] && s1[index2] == s2[index1]) return true;
        return false;
    }

    fun maximumWealth(accounts: Array<IntArray>): Int {
        //[[1,5],[7,3],[3,5]]
        var maxWealth = 0
        var currentWealth = 0
        for (i in accounts.indices) {
            currentWealth = 0
            for (j in accounts[i].indices) {
                currentWealth += accounts[i][j]
            }
            if (maxWealth < currentWealth) {
                maxWealth = currentWealth
            }
        }
        return maxWealth
    }

    /*solve the same problem but using foreach*/
    fun maximumWealth2(accounts: Array<IntArray>): Int {
        //[[1,5],[7,3],[3,5]]
        var maxWealth = 0
        for (account in accounts) {
            var currentWealth = 0
            for (balance in account) {
                currentWealth += balance
            }
            if (maxWealth < currentWealth) {
                maxWealth = currentWealth
            }
        }
        return maxWealth
    }

    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var left = 0
        var result = 0
        while (left < arr.size) {
            var currentSum = arr[left]

            val right = left + 1
            result += arr[left]
            for (index in right until arr.size) {
                currentSum += arr[index]
                if ((index - left) % 2 == 0) {
                    result += currentSum
                }
            }
            left++
        }
        return result
    }

    fun findTheDifference(s: String, t: String): Char {
        val asciiS = asciiSum(s)
        val asciiT = asciiSum(t)
        return (asciiT - asciiS).toChar()
    }

    private fun asciiSum(s: String): Int {
        var sum = 0
        for (element in s.toCharArray()) {
            sum += element.toChar().toInt()
        }
        return sum
    }

    /*
     Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
*/

    fun mergeAlternately(word1: String, word2: String): String {
        var mergedStr = ""
        val strSize = if (word1.length > word2.length) word1.length - 1 else word2.length - 1
        for (i in 0..strSize) {
            if (i < word1.length && i < word2.length) mergedStr += "${word1[i]}${word2[i]}"
            if (i < word1.length && i >= word2.length) mergedStr += "${word1[i]}"
            if (i < word2.length && i >= word1.length) mergedStr += "${word2[i]}"
        }
        return mergedStr
    }

    fun mergeAlternately2(word1: String, word2: String): String {

        val strLength = if (word1.length > word2.length) word1.length else word2.length

        var mergedStr = ""
        for (count in 0 until strLength) {
            if (count < word1.length) {
                mergedStr += word1[count]
            }
            if (count < word2.length) {
                mergedStr += word2[count]
            }
        }
        return mergedStr
    }


}