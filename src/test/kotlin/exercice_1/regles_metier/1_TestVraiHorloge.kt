package exercice_1.regles_metier

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import parcmetre.adapteurs.VraieHorloge

class `1_TestVraiHorloge` : StringSpec({

    "le vrai temps".config(enabled = true) {
        // Arrange / Given
        val horloge = VraieHorloge()
         //Act / When

        // Assert / Then
       horloge.maintenantALaMinute() shouldNotBe horloge.maintenantALaMinute()

    }


})