class Customer                                  // Declares a class named Customer without any properties or user-defined constructors. A non-parameterized default constructor is created by Kotlin automatically.

class Contact(val id: Int, var email: String)   // Declares a class with two properties: immutable id and mutable email, and a constructor with two parameters id and email.

data class User(val name: String, val id: Int)  // Defines a data class with the data modifier.

enum class State {
    IDLE, RUNNING, FINISHED                     // Defines a simple enum class with three enum instances. The number of instances is always finite and they are all distinct.
}

enum class Color(val rgb: Int) {                // Defines an enum class with a property and a method.
    RED(0xFF0000),                          // Each instance must pass an argument for the constructor parameter.
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)  // Enum class members are separated from the instance definitions by a semicolon.
}

sealed class Mammal(val name: String)                                     // Defines a sealed class.
class Cat(val catName: String) : Mammal(catName)                          // Defines subclasses. Note that all subclasses must be in the same file.
class Human(val humanName: String, val job: String) : Mammal(humanName)   // Defines subclasses. Note that all subclasses must be in the same file.
