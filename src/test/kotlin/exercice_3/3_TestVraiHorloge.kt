package exercice_3

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import adapters.driven.timeProviders.VraieHorloge

class `3_TestVraiHorloge` : StringSpec({

    "le vrai temps".config(enabled = true) {
        // Arrange / Given
        val horloge = VraieHorloge()

        //Act /  Assert / Then
       horloge.quelleHeureEstIl() shouldNotBe horloge.quelleHeureEstIl()

    }


})