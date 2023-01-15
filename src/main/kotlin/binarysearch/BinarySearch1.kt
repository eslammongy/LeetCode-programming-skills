package binarysearch

class BinarySearch1 {

    fun search(nums: IntArray, target: Int): Int {

        if (nums.isEmpty()) return -1
        var left = 0
        var right = nums.size-1

        while (left <= right){
            val mid = left + (right - left) / 2
            if (nums[mid] == target){
                return mid
            }
            else if (nums[mid] > target){
                right = mid - 1
            }
            else{
                left = mid + 1
            }
        }
        return -1
    }

    fun search2(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while(left <= right){
            val mid = left + (right - left) / 2
            when{
                nums[mid] < target -> {
                    left = mid + 1
                }
                nums[mid] > target -> {
                    right = mid - 1
                }
                nums[mid] == target -> {
                    return mid
                }
            }
        }
        return -1
    }
}