interface HelloService {
    fun hello(): String
}

class HelloServiceImpl(private val greeting: Greeting) : HelloService {
    override fun hello(): String = "Hello ${greeting.text}"
}

data class Greeting(val text: String)