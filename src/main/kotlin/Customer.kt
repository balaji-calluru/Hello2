class Customer                                  // Declares a class named Customer without any properties or user-defined constructors. A non-parameterized default constructor is created by Kotlin automatically.

class Contact(val id: Int, var email: String)   // Declares a class with two properties: immutable id and mutable email, and a constructor with two parameters id and email.

fun main() {

    val customer = Customer()                   // Creates an instance of the class Customer via the default constructor. Note that there is no new keyword in Kotlin.

    val contact = Contact(1, "mary@gmail.com")  // Creates an instance of the class Contact using the constructor with two arguments.

    println(contact.id)                         // Accesses the property id.
    println(contact.email)                      // Accesses the property email.
    contact.email = "jane@gmail.com"            // Updates the value of the property email.
    println(contact.email)                      // Accesses the property email.
}