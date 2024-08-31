package exercice_1.regles_metier

import io.kotest.core.spec.style.StringSpec

class `1_TestTicket` : StringSpec({

    "l'heure de départ ne peut etre inférieure à l'heure d'arrivée ".config(enabled = true) {
        // Arrange / Given

        // Assert / Then
      //  ticket.heureDebutStationnement shouldBe leMaintenant

    }

    "le montant ne peut pas etre inférieure ou égal à 0" {

    }
})