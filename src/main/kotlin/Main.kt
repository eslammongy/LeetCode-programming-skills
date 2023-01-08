fun main() {

    val nums = calcSalaryAverage2(intArrayOf(2000,9000,3000, 1000, 5000, 4000))
    println(nums)
    val solution = Solution()
    /*
  Input: n = 4421

Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21
    * */
    val hammingWeight = solution.subtractProductAndSum2(234)
    println(hammingWeight)
}


/* Count Odd Numbers in an Interval Range*/
fun countOdds(low: Int, high: Int): Int {
    var difference = (high - low) / 2
    if (low % 2 == 1 || high % 2 == 1) difference++
    return difference
}
fun countOddNumber(low:Int, height:Int):Int{
    var countOdd = 0
    if (height < low) return -1
    for (number in low..height){
        if (number % 2 == 0){
            continue
        }else{
            countOdd++
        }
    }
    return countOdd
}

/* Average Salary Excluding the Minimum and Maximum Salary */

fun calcSalaryAverage(salaries:IntArray):Double{

    var total = 0.0
    var maxSalary = salaries[0]
    var miniSalary = salaries[0]

    for (salary in salaries){
        if (salary > maxSalary){
            maxSalary = salary
        }
        if (salary < miniSalary){
            miniSalary = salary
        }
        total += salary
    }
    total -= maxSalary + miniSalary
return total / (salaries.size - 2)

}

fun calcSalaryAverage2(salaries: IntArray): Double {
    val nums = doQuickSort(salaries)
    return nums.copyOfRange(1, nums.size - 1).average()
}
fun doQuickSort(array: IntArray): IntArray {
    if (array.size < 2) return array
    val greeterList = mutableListOf<Int>()
    val lessList = mutableListOf<Int>()
    var equalItem = 0
    val pivot = array[array.size / 2]
    for (item in array){
        if (item < pivot){
            lessList.add(item)
        }
        if (item > pivot){
            greeterList.add(item)
        }
        if (item == pivot){
            equalItem = item
        }
    }

    return doQuickSort(lessList.toIntArray()) + equalItem + doQuickSort(greeterList.toIntArray()) // 4
}
