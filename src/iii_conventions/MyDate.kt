package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        if (year.compareTo(other.year) != 0) {
            return year.compareTo(other.year)
        } else if (month.compareTo(other.month) != 0) {
            return month.compareTo(other.month)
        } else if (dayOfMonth.compareTo(other.dayOfMonth) != 0) {
            return dayOfMonth.compareTo(other.dayOfMonth)
        } else {
            return 0
        }
    }

    operator fun plus(interval: TimeInterval): MyDate = addTimeIntervals(interval, 1)

    operator fun plus(intervals: TimeIntervals): MyDate = addTimeIntervals(intervals.interval, intervals.count)
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

data class TimeIntervals(val interval: TimeInterval, val count: Int)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(n: Int): TimeIntervals {
        return TimeIntervals(this, n)
    }
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterator<MyDate> {

    private var current = start

    override fun contains(value: MyDate): Boolean {
        return start <= value && value <= endInclusive
    }

    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    override fun next(): MyDate {
        val result = current;
        current = current.copy(year = current.year, month = current.month, dayOfMonth = current.dayOfMonth + 1)
        return result
    }
}
