fun printMessage(message: String): Unit {                               // A simple function that takes a parameter of type String and returns Unit (i.e., no return value).
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // A function that takes a second optional parameter with default value Info. The return type is omitted, meaning that it's actually Unit.
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {                                          // A function that returns an integer.
    return x + y
}

fun multiply(x: Int, y: Int) = x * y                                    // A single-expression function that returns an integer (inferred).

fun printAll(vararg messages: String) {                            // The vararg modifier turns a parameter into a vararg.
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {  // Thanks to named parameters, you can even add another parameter of the same type after the vararg. This wouldn't be allowed in Java because there's no way to pass a value.
    for (m in messages) println(prefix + m)
}

fun log(vararg entries: String) {
    printAll(*entries)                                             // At runtime, a vararg is just an array. To pass it along into a vararg parameter, use the special spread operator * that lets you pass in *entries (a vararg of String) instead of entries (an Array<String>).
}

fun main() {
//    println("What's your name?")
//    val name = readLine()
//    println("Hello $name!")

    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiply(1, 2))

    infix fun Int.times(str: String) = str.repeat(this)        // Defines an infix extension function on Int.
    println(2 times "Bye ")                                    // Calls the infix function.

    val pair = "Ferrari" to "Katrina"                          // Creates a Pair by calling the infix function to from the standard library.
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)   // Here's your own implementation of to creatively called onto.
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia                                       // Infix notation also works on members functions (methods).

//    operator fun Int.times(str: String) = str.repeat(this)       // 1
//    println(2 * "Bye ")                                          // 2

    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])

    printAll("Hello", "Hallo", "Salut", "Hola", "你好")

    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "
    )

    log("Tell", "Me", "Something", "I", "Don't", "Know...")

    var a: String = "initial"  // Declares a mutable variable and initializing it.
    val b: Int = 1             // Declares an immutable variable and initializing it.
    val c = 3                  // Declares an immutable variable and initializing it without specifying the type. The compiler infers the type Int.
    println("$a $b $c")
    a = "Gotcha"               // Mutating (Changing) the mutables
    println("$a $b $c")

    // b = 7    // Compiler error when trying to mutate (change) immutables
    // c = 12   // Compiler error when trying to mutate (change) immutables

    var e: Int  // Declares a variable without initialization.
    // println(e)  // An attempt to use the variable causes a compiler error: Variable 'e' must be initialized.

    val d: Int  // 1

    if (true) {
        d = 1   // 2
    } else {
        d = 2   // 2
    }

    println(d) // 3

    var neverNull: String = "This can't be null"            // Declares a non-null String variable.
    // neverNull = null                                     // When trying to assign null to non-nullable variable, a compilation error is produced.

    var nullable: String? = "You can keep a null here"      // Declares a nullable String variable.
    nullable = null                                         // Sets the null value to the nullable variable. This is OK.

    var inferredNonNull = "The compiler assumes non-null"   // When inferring types, the compiler assumes non-null for variables that are initialized with a value.
    // inferredNonNull = null                               // When trying to assign null to a variable with inferred type, a compilation error is produced.

    fun strLength(notNull: String): Int {                   // Declares a function with a non-null string parameter.
        return notNull.length
    }
    strLength(neverNull)                                    // Calls the function with a String (non-nullable) argument. This is OK.
    // strLength(nullable)                                  // When calling the function with a String? (nullable) argument, a compilation error is produced.

    println(describeString(neverNull))
    println(describeString(nullable))
    println(describeString(inferredNonNull))
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // The containing class becomes the first parameter.

}

fun describeString(maybeString: String?): String {              // A function that takes in a nullable string and returns its description.
    if (maybeString != null && maybeString.length > 0) {        // If the given string is not null and not empty, return information about its length.
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"                           // Otherwise, tell the caller that the string is empty or null.
    }
}
