package adapters.adapters_fakes

import io.kotest.matchers.result.shouldBeSuccess
import org.junit.jupiter.api.Test
import boundedContexts.location.models.DTOs.TicketDto
import io.kotest.matchers.shouldBe

class EspionStockageTest {

    @Test
    fun saveSurLeSpy() {

        var spy = EspionStockage()

        var actual = spy.saveTicket(TicketDto("0", 0))

        actual  shouldBeSuccess true
        spy.SaveCombienDeFois shouldBe 1
    }

@Test
    fun pasDappelSaveSurLeSpy() {

        var spy = EspionStockage()
        spy.SaveCombienDeFois shouldBe 0
    }
}