package programmerzamannow.belajarandroiddasar

import org.junit.Assert
import org.junit.Test

class HalloTest {

    @Test
    fun testSayHello() {
        val result = Hello.sayHello("Eko")

        Assert.assertEquals("Hello Eko", result)
    }

}