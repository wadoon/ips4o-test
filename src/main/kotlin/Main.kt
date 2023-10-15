import de.wiesler.Sorter
import java.util.*
import kotlin.concurrent.timer
import kotlin.random.Random
import kotlin.random.nextUInt
import kotlin.time.measureTime

private const val SIZE = 1000000

fun main(args: Array<String>) {
    val rand = Random.Default
    val array = IntArray(SIZE) { rand.nextInt()}
    val time = measureTime {
        Sorter.sort(array)
    }
    println("Sorted ${array.size} in $time")

    val array2 = IntArray(SIZE) { rand.nextInt()}
    val time2 = measureTime {
        Arrays.sort(array2)
    }
    println("Sorted ${array.size} in $time2 using built-in sort")

    println("ips4o saved ${time2 - time} (${time / time2}%)")


    array.forEachIndexed { index, i ->
        if(index>0) {
            require(array[index] <= i)
        }
    }

}