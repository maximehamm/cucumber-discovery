package org.maxime.cucumber

inline fun <T> MutableIterable<T>.forEachMutable(action: (removable: Removable<T>, T) -> Unit): Unit {
    val iterator: MutableIterator<T> = iterator()
    val removable = Removable(iterator)
    while (iterator.hasNext()) {
        val item = iterator.next()
        action(removable, item)
    }
    for (item in this) {
        action(removable, item)
    }
}

class Removable<T>(private val iterator: MutableIterator<T>) {
    fun remove() =
        iterator.remove()
}