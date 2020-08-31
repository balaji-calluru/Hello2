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


    val customer = Customer()                   // Creates an instance of the class Customer via the default constructor. Note that there is no new keyword in Kotlin.

    val contact = Contact(1, "mary@gmail.com")  // Creates an instance of the class Contact using the constructor with two arguments.

    println(contact.id)                         // Accesses the property id.
    println(contact.email)                      // Accesses the property email.
    contact.email = "jane@gmail.com"            // Updates the value of the property email.
    println(contact.email)                      // Accesses the property email.


    val stack = MutableStack(0.62, 3.14, 2.74)
    stack.push(9.87)
    println(stack)

    println("peek(): ${stack.peek()}")
    println(stack)

    for (i in 1..stack.size()) {
        println("pop(): ${stack.pop()}")
        println(stack)
    }

    val stack2 = mutableStackOf(0.6, 3.1, 2.7)
    println(stack2)

    val dog1: Dog = Dog()
    val dog2: Dog = Yorkshire()
    dog1.sayHello()
    dog2.sayHello()

    val tiger: Tiger = SiberianTiger()
    tiger.sayHello()

    val lion: Lion = Asiatic("Rufo")                              // Creates an Asiatic instance with the name Rufo. The call invokes the Lion constructor with arguments Rufo and India.
    lion.sayHello()


    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")

    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {                               // 1
        println("Yummy, it's a $cake cake!")
    }

    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {                    // 1
        eatACake()
        cakesEaten ++
    }

    do {                                        // 2
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))

    for (animal in zoo) {                                   // Loops through animals in the zoo with the user-defined iterator.
        println("Watch out, it's a ${animal.name}")
    }

    for(i in 0..3) {             // Iterates over a range starting from 0 up to 3 (inclusive).
        print(i)
    }
    print(" ")

    for(i in 2..8 step 2) {      // Iterates over a range with a custom increment step for consecutive elements.
        print(i)
    }
    print(" ")

    for (i in 3 downTo 0) {      // Iterates over a range in reverse order.
        print(i)
    }
    print(" ")

    for (c in 'a'..'d') {        // Iterates over a char range in alphabetical order.
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 's' step 2) { // Char ranges support step and downTo as well.

        print(c)
    }
    println()

    val x = 2
    if (x in 1..5) {            // Checks if a value is in the range.
        println("x is in range from 1 to 5")
    }

    if (x !in 6..10) {          // !in is the opposite of in.
        println("x is not in range from 6 to 10")
    }

    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)   // Returns true because it calls authors.equals(writers) and sets ignore element order.
    println(authors === writers)  // Returns false because authors and writers are distinct references.

    val user = User("Alex", 1)
    println(user)                                          // Method toString is auto-generated, which makes println output look nice.

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    println("user == secondUser: ${user == secondUser}")   // Auto-generated equals considers two instances equal if all their properties are equal.
    println("user == thirdUser: ${user == thirdUser}")

    println(user.hashCode())                               // Equal data class instances have equal hashCode().
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    // copy() function
    println(user.copy())                                   // Auto-generated copy function makes it easy to create a new instance.
    println(user.copy("Max"))                        // When copying, you can change values of certain properties. copy accepts arguments in the same order as the class constructor.
    println(user.copy(id = 2))                             // Use copy with named arguments to change the value despite of the properties order.

    println("name = ${user.component1()}")                 // Auto-generated componentN functions let you get the values of properties in the order of declaration.
    println("id = ${user.component2()}")


    val state = State.RUNNING                         // Accesses an enum instance via the class name.
    val message = when (state) {                      // With enums, the compiler can infer if a when-expression is exhaustive so that you don't need the else-case.
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)

    val red = Color.RED
    println(red)                                      // The default toString returns the name of the instance, here "RED".
    println(red.containsRed())                        // Calls a method on an enum instance.
    println(Color.BLUE.containsRed())                 // Calls a method via enum class name.


    println(greetMammal(Cat("Snowy")))
    println(greetMammal(Human("MJ", "Singer")))

    val d1 = LuckDispatcher()             // Creates instances.
    val d2 = LuckDispatcher()

    d1.getNumber()                        // Calls the method on instances.
    d2.getNumber()

    rentPrice(10, 2, 1)  // Calls the function. This is when the object is actually created.

    DoAuth.takeParams("foo", "qwerty")  // Calls the method. This is when the object is actually created.

    BigBen.getBongs(12)                         // Calls the companion object method via the class name.

    val sumResult = calculate(4, 5, ::mysum)           // Invokes the higher-order function passing in two integer values and the function argument ::mysum. :: is the notation that references a function by name in Kotlin.
    val mulResult = calculate(4, 5) { a, b -> a * b }  // Invokes the higher-order function passing in a lambda as a function argument. Looks clearer, doesn't it?
    println("sumResult $sumResult, mulResult $mulResult")

    val func = operation()   // Invokes operation to get the result assigned to a variable. Here func becomes square which is returned by operation.
    println(func(2))         // Invokes func. The square function is actually executed.


    // All examples create a function object that performs upper-casing.
    // So it's a function from String to String

    val upperCase1: (String) -> String = { str: String -> str.toUpperCase() } // A lambda in all its glory, with explicit types everywhere. The lambda is the part in curly braces, which is assigned to a variable of type (String) -> String (a function type).
    val upperCase2: (String) -> String = { str         -> str.toUpperCase() } // Type inference inside lambda: the type of the lambda parameter is inferred from the type of the variable it's assigned to.
    val upperCase3                     = { str: String -> str.toUpperCase() } // Type inference outside lambda: the type of the variable is inferred from the type of the lambda parameter and return value.
 // val upperCase4                     = { str         -> str.toUpperCase() } // You cannot do both together, the compiler has no chance to infer the type that way.
    val upperCase5: (String) -> String = {                 it.toUpperCase() } // For lambdas with a single parameter, you don't have to explicitly name it. Instead, you can use the implicit it variable. This is especially useful when the type of it can be inferred (which is often the case).
    val upperCase6: (String) -> String =              String::toUpperCase     // If your lambda consists of a single function call, you may use function pointers (::) .
    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))

    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))

    println("Max priced item name: ${order.maxPricedItemName()}")                     // Calls extension functions directly on an instance of Order.
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")                                // Accesses the extension property on an instance of Order.

    println(null.nullSafeToString())
    println("Kotlin".nullSafeToString())

}

data class Item(val name: String, val price: Float)  // Defines simple models of Item and Order. Order can contain a collection of Item objects.
data class Order(val items: Collection<Item>)

fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price ?: 0F    // Adds extension functions for the Order type.
fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

val Order.commaDelimitedItemNames: String                                             // Adds an extension property for the Order type.
    get() = items.map { it.name }.joinToString()

fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"  // 1

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // Declares a higher-order function. It takes two integer parameters, x and y. Additionally, it takes another function operation as a parameter. The operation parameters and return type are also defined in the declaration.
    return operation(x, y)                                          // The higher order function returns the result of operation invocation with the supplied arguments.
}

fun mysum(x: Int, y: Int) = x + y                                   // Declares a function that matches the operationsignature.

fun operation(): (Int) -> Int {                                     // Declares a higher-order function that returns a function. (Int) -> Int represents the parameters and return type of the square function.
    return ::mysquare
}

fun mysquare(x: Int) = x * x                                          // Declares a function matching the signature.

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  // Creates a function with parameters.
    val dayRates = object {                                                     // Creates an object to use when calculating the result value.
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }
    val total = dayRates.standard + dayRates.festivity + dayRates.special       // Accesses the object's properties.
    println("Total price: $$total")                                               // Prints the result.
}

fun greetMammal(mammal: Mammal): String {
    when (mammal) {                                                                     // Uses an instance of the sealed class as an argument in a when expression.
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"    // A smartcast is performed, casting Mammal to Human.
        is Cat -> return "Hello ${mammal.name}"                                         // A smartcast is performed, casting Mammal to Cat.
    }                                                                                   // The else-case is not necessary here since all possible subclasses of the sealed class are covered. With a non-sealed superclass else would be required.
}

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

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

fun cases(obj: Any) {
    when (obj) {                                     // This is a when statement.
        1 -> println("One")                          // Checks whether obj equals to one.
        "Hello" -> println("Greeting")               // Checks whether obj equals to Hello.
        is Long -> println("Long")                   // Performs type checking.
        !is String -> println("Not a string")        // Performs inverse type checking.
        else -> println("Unknown")                   // Default statement (might be omitted).
    }
}

class MyClass
