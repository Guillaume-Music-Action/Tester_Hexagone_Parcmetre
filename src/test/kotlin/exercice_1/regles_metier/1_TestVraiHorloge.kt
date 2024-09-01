package exercice_1.regles_metier

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import parcmetre.adapters.storage.VraieHorloge

class `1_TestVraiHorloge` : StringSpec({

    "le vrai temps".config(enabled = true) {
        // Arrange / Given
        val horloge = VraieHorloge()
         //Act / When

        // Assert / Then
       horloge.quelleHeureEstIl() shouldNotBe horloge.quelleHeureEstIl()

    }


})