import kotlinx.coroutines.*
import java.util.*

fun main() {
    val ctx = ThreadLocal<String>().asContextElement()
    runBlocking {
        for (i in 0 until 100) {
            launch {
                withContext(Dispatchers.Default) {

                }

                withContext(Dispatchers.IO) {

                }
            }
        }
    }
}