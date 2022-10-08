package org.maxime.cucumber

fun <T> MutableIterable<T>.forEachMutable(block: Removable<T>.(T) -> Unit): Unit {
    val iterator: MutableIterator<T> = iterator()
    val removable = Removable(iterator, block)
    while (iterator.hasNext()) {
        val item = iterator.next()
        removable.action(item)
    }
}

class Removable<T>(
    private val iterator: MutableIterator<T>,
    private val block: Removable<T>.(T) -> Unit) {

    fun remove() =
        iterator.remove()

    fun action(item: T) {
        block(item)
    }
}