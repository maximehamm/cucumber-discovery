package org.maxime.cucumber

import kotlin.reflect.KClass

class GroupPerSizeHelper<T> {

    private var items: List<Pair<Double, T>>? = null

    fun load(items: List<Pair<Double, T>>): GroupPerSizeHelper<T> {
        this.items = items
        return this
    }

    fun group(maxSize: Double): List<List<T>> {

        val sorted = this.items?.sortedBy { it.first }?.reversed()?.toMutableList()
            ?: throw ItemsInputNotSetException()

        val groups = mutableListOf<List<T>>()
        while (sorted.isNotEmpty()) {

            var size = 0.0.apply { toLong() }
            val group = mutableListOf<T>()

            sorted.forEachMutable { it ->
                if (it.first > maxSize)
                    throw ItemSizeExceededMaximumException()
                if (size + it.first <= maxSize) {
                    size += it.first
                    group += it.second
                    this.remove()
                }
            }

            groups += group
        }

        return groups
    }

    class ItemsInputNotSetException : Throwable() {
    }

    class ItemSizeExceededMaximumException : Throwable() {
    }

}