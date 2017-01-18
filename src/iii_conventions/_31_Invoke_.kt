package iii_conventions

import util.TODO
import java.util.concurrent.atomic.AtomicInteger


class Invokable {

    val count: AtomicInteger = AtomicInteger(0)

    operator fun invoke(): Invokable {
        count.incrementAndGet()
        return this
    }

    fun getNumberOfInvocations(): Int {
        return count.toInt()
    }
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
