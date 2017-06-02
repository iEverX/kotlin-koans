package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year != other.year) {
            return year - other.year
        }
        if (month != other.month) {
            return month - other.month
        }
        return dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterator<MyDate> {
    var current = start
    var started = false

    override fun hasNext(): Boolean {
        return current < endInclusive
    }

    override fun next(): MyDate {
        if (started) {
            current = current.nextDay()
        } else {
            started = true
        }
        return current
    }
}

operator fun MyDate.plus(t: TimeInterval): MyDate {
    return this.addTimeIntervals(t, 1)
}

class RepeatedTimeInterval(val interval: TimeInterval, val times: Int)

operator fun TimeInterval.times(times: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, times)
}

operator fun MyDate.plus(t: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(t.interval, t.times)
}