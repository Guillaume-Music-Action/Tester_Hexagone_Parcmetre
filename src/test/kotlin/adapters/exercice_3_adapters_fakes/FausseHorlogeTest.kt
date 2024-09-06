package adapters.exercice_3_adapters_fakes

import junit.framework.TestCase.assertEquals
import kotlinx.datetime.LocalDateTime
import org.junit.jupiter.api.Test

class FausseHorlogeTest {

    @Test
    fun testQuelleHeureEstIl() {
        val expectedTime = LocalDateTime.parse("2024-12-31T23:59:59")
        val horloge = FausseHorloge(expectedTime)
        val actualTime = horloge.quelleHeureEstIl()
        assertEquals(expectedTime, actualTime)
    }
}