package adapters.exercice_3_adapters_fakes

import io.kotest.matchers.result.shouldBeSuccess
import org.junit.jupiter.api.Test
import location.models.DTOs.TicketDto

class EspionStockageTest {

    @Test
    fun saveSurLeSpy() {

        var spy = EspionStockage()

        var actual = spy.saveTicket( TicketDto(0, 0))

        actual  shouldBeSuccess true
       // actual.SaveCombienDeFois shouldBe 1


    }
}