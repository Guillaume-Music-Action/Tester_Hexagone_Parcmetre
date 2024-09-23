package adapters.exercice_3_adapters_fakes

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.shouldBe
import junit.framework.TestCase.assertEquals
import kotlinx.datetime.LocalDateTime
import org.junit.jupiter.api.Test
import parcmetre.models.DTOs.TicketDto

class EspionStockageTest {

    @Test
    fun saveSurLeSpy() {

        var spy = EspionStockage()

        var actual = spy.saveTicket( TicketDto(0, 0))

        actual  shouldBeSuccess true
       // actual.SaveCombienDeFois shouldBe 1


    }
}