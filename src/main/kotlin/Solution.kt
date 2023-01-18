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



}