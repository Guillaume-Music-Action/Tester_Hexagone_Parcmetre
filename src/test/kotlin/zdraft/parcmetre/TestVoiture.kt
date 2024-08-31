package exercice_1

import Voiture.VoitureBuilder
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldHaveLength
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.function.Executable
import draft.Voiture

class TestVoiture : StringSpec({


    ("la voiture doit avoir une plaque d'immatriculation a 9 caracteres").config(enabled = true) {
        // Arrange
        var sut : Voiture =  VoitureBuilder()
            .withPlaqueImmatriculation("123456789")
            .build()

        // Voiture sut = new VoitureBuilder()
        //    .withPlaqueImmatriculation()
        //    .build();

        // Assert
        sut.PlaqueImmatriculation shouldHaveLength 9
        //assertEquals(9,  sut.PlaqueImmatriculation.length);
    }


    ("la voiture ne peut pas avoir une plaque d'immatriculation a 8 caracteres").config(enabled = true) {
        // Arrange
        var sut : Voiture =  VoitureBuilder()
            .withPlaqueImmatriculation("12345678")
            .build()

        // ca n'a plus de sens d'écrire cette assertion !!!
        // assertEquals(0,  sut.PlaqueImmatriculation.length);  // oui mais pourquoi 0 ????

        // Assert
      //  sut.IsValid shouldBe false  // 1e version
        // sut shouldBeSameInstanceAs  InvalideVoiture()  // 2e version
        // sut.Demarre() shouldBe Voiture.NePeutPasDemarrer   // dans les 2 versions, on devrait avoir ca

        // faire un diagramme UML du pattern builder dans la 2e version
    }

    ("la voiture ne peut pas avoir une plaque d'immatriculation vide ").config(false ) {

        // Assert possibles
        // sut.EstValide shoulBe false
       // sut.PlaqueImmatriculation shouldBeBlank()

        // on choisi de jeter une exception au moment de la construction
        Assertions.assertThrows(IllegalArgumentException::class.java,
            Executable { var sut = Voiture("") })

        // a évtier car les constructeurs ne doivent pas générer d'exceptions
        // voir
    }


})