import binarysearch.BinarySearch1
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val solution = Solution()
    val binarySearch1 = BinarySearch1()

    //[[1,2],[3,3],[3,3]]
    val points:Array<IntArray> = arrayOf(intArrayOf(1,2), intArrayOf(3,3), intArrayOf(3,3))
    val target = solution.nearestValidPoint(1, 1, points)
    println(target)
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

/*fun calcSalaryAverage2(salaries: IntArray): Double {
    val nums = doQuickSort(salaries)
    return nums.copyOfRange(1, nums.size - 1).average()
}*/

