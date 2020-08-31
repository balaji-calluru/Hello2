class MutableStack<E>(vararg items: E) {              // Defines a generic class MutableStack<E> where E is called the generic type parameter. At use-site, it is assigned to a specific type such as Int by declaring a MutableStack<Int>.

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)        // Inside the generic class, E can be used as a parameter like any other type.

    fun peek(): E = elements.last()                     // You can also use E as a return type.

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"


}