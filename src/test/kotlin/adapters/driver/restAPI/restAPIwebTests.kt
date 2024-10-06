package adapters.driver.restAPI


import com.natpryce.hamkrest.and
import com.natpryce.hamkrest.assertion.assertThat

import io.kotest.core.spec.style.FunSpec
import org.http4k.client.OkHttp
import org.http4k.core.Method
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.hamkrest.hasBody
import org.http4k.hamkrest.hasStatus
import location.adapters.driver.httpServer
import location.useCases.AcheterUnTicketDeLocation
import location.useCases.DemandeDuTicket


class RestApiTest : FunSpec({

    context("en utilisant http4k server").config(enabled = true) {
        val client = OkHttp()

     //   val store =  Repository()
        val demande = DemandeDuTicket(immatriculationVehicule = "imma", montantEuro = 5)
        val useCase = AcheterUnTicketDeLocation()

        val server = httpServer(0, useCase)

        server.start()

        test("on passe par l'API pour générer un ticket") {
            val response = client(Request(Method.PUT,
                "http://localhost:${server.port()}/parcemetre/ticket/5"
            ))
            assertThat(response, hasStatus(OK).and(hasBody(
                "{\"id\":\"\",\"heureEntree\":\"\",\"dureeDeLocation\":\"\",\"sommePayee\":\"\"}")))
            //TODO: put real data in the response
        }



        test("un ticket a été demandé, on doit pouvoir demander à l'API de le retrouver").config(enabled = false) {

           // val resultat = async { useCase.handle(demande) }.await()

            val response = client(Request(GET, "http://localhost:${server.port()}/parcemetre/tickets"))
            assertThat(response, hasStatus(OK).and(hasBody("{\"value\":100,\"accountId\":\"1234567890\"}")))
        }

        server.stop()
    }
})