package org.maxime.cucumber

class GroupPerSizeHelper<T> {

    private var items: List<Pair<Double, T>>? = null

    fun load(items: List<Pair<Double, T>>): GroupPerSizeHelper<T> {
        this.items = items
        return this
    }

    fun group(maxSize: Double): List<List<T>> {

        val sorted = this.items?.sortedBy { it.first }?.reversed()?.toMutableList()
            ?: throw ItemsInputNotSetException()

        val grouped = mutableListOf<List<T>>()
        while (sorted.isNotEmpty()) {

            var size = 0.0
            val group = mutableListOf<T>()

            sorted.forEachMutable { r, it ->
                if (it.first > maxSize)
                    throw ItemsSizeExceededMaximumException()
                if (size + it.first <= maxSize) {
                    size += it.first
                    group += it.second
                    r.remove()
                }
            }

            grouped += group
        }

        return grouped
    }

    class ItemsInputNotSetException : Throwable() {
    }

    class ItemsSizeExceededMaximumException : Throwable() {
    }

}