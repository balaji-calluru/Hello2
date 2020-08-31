// Classes and objects in Kotlin work the same way as in most object-oriented languages:
//    a class is a blueprint
//    an object is an instance of a class
// Usually, you define a class and then create multiple instances of that class

import java.util.Random

class LuckDispatcher {                    // Defines a blueprint.
    fun getNumber() {                     // Defines a method.
        var objRandom = Random()
        println(objRandom.nextInt(190))
    }
}

object DoAuth {                                                 // Creates an object declaration.
    fun takeParams(username: String, password: String){         // Defines the object method.
        println("input Auth parameters = $username:$password")
    }
}

class BigBen {                                  // Defines a class.
    companion object Bonger {                   // Defines a companion. Its name can be omitted.
        fun getBongs(nTimes: Int) {             // Defines a companion object method.
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
            println()
        }
    }
}