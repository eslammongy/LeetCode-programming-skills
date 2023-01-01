fun main(args: Array<String>) {

    var result = countOdds(7, 20)
    println(result)

}

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