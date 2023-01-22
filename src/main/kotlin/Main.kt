import binarysearch.BinarySearch1
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val solution = Solution()
    val binarySearch1 = BinarySearch1()
    //[[1,5],[7,3],[3,5]]
    val accounts:Array<IntArray> = arrayOf(intArrayOf(1,5), intArrayOf(7,3), intArrayOf(3,5))
    val target = solution.maximumWealth2(accounts)
    println(target)
}

