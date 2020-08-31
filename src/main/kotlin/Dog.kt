open class Dog {                // Kotlin classes are final by default. If you want to allow the class inheritance, mark the class with the open modifier.
    open fun sayHello() {       // Kotlin methods are also final by default. As with the classes, the open modifier allows overriding them.
        println("wow wow!")
    }
}

class Yorkshire : Dog() {       // A class inherits a superclass when you specify the : SuperclassName() after its name. The empty parentheses () indicate an invocation of the superclass default constructor.
    override fun sayHello() {   // Overriding methods or attributes requires the override modifier.
        println("wif wif!")
    }
}

open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

class SiberianTiger : Tiger("Siberia")                  // If you want to use a parameterized constructor of the superclass when creating a subclass, provide the constructor arguments in the subclass declaration.

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India") // name in the Asiatic declaration is neither a var nor val: it's a constructor argument, whose value is passed to the name property of the superclass Lion.

