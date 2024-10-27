package adapters.driver.restAPI


import com.natpryce.hamkrest.and
import com.natpryce.hamkrest.assertion.assertThat
import io.kotest.core.spec.style.FunSpec
import adapters.driver.httpServer
import boundedContexts.location.useCases.AcheterUnTicketDeLocation
import boundedContexts.location.utilities.LinearIdGenerator
import org.http4k.client.OkHttp
import org.http4k.core.Method
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.hamkrest.hasBody
import org.http4k.hamkrest.hasStatus


class RestApiTest : FunSpec({

    context("en utilisant http4k server").config(enabled = true) {
        // SETUP TEST
        val client = OkHttp()
        //   val store =  Repository()
        val useCase =
            boundedContexts.location.useCases.AcheterUnTicketDeLocation(boundedContexts.location.utilities.LinearIdGenerator())  //testableIdGenerateur
        val server = httpServer(0, useCase)
        server.start()


        test("on passe par l'API pour générer un ticket") {
            val response = client(
                Request(
                    Method.PUT,
                    "http://localhost:${server.port()}/location/ticket/5"
                )
            )
            assertThat(
                response, hasStatus(OK).and(
                    hasBody(
                        "{\"id\":\"FAUX-ID-1\",\"heureEntree\":\"\",\"dureeDeLocation\":\"600.0 min\",\"sommePayee\":\"5\"}"
                    )))

        }

        test("un ticket a été demandé, on doit pouvoir demander à l'API de le retrouver").config(enabled = false) {

            val response = client(Request(GET, "http://localhost:${server.port()}/location/tickets"))
            assertThat(response, hasStatus(OK).and(hasBody("{\"value\":100,\"accountId\":\"1234567890\"}")))
        }

        // tear down
        server.stop()
    }
})