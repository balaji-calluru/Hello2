class Animal(val name: String)

class Zoo(val animals: List<Animal>) {

    operator fun iterator(): Iterator<Animal> {  // Defines an iterator in a class. It must be named iterator and have the operator modifier.
        return animals.iterator()                // Returns the iterator that meets the following method requirements: next(): Animal, hasNext(): Boolean
    }
}
