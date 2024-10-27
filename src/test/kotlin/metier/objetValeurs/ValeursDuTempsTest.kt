package metier.objetValeurs

import boundedContexts.universel.valueObjects.Temps
import boundedContexts.universel.valueObjects.UniteTemps
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ValeursDuTempsTest : StringSpec({


    "je veux passer des minutes aux heures".config(enabled = true) {
        // Arrange
        val soixanteMinutes = Temps(60, UniteTemps.minutes)
        val uneHeure = Temps(1, UniteTemps.heures)

        // Assert
        soixanteMinutes shouldBe uneHeure
    }

    "je veux comparer des minutes aux heures".config(enabled = true) {
        // Arrange
        val soixanteMinutes = Temps(60, UniteTemps.minutes)
        val uneMinute = Temps(1, UniteTemps.minutes)

        val uneHeure = Temps(1, UniteTemps.heures)

        // Assert
        (uneMinute < uneHeure) shouldBe true
        (soixanteMinutes > uneMinute) shouldBe true
        (soixanteMinutes < uneHeure) shouldBe false
        (soixanteMinutes <= soixanteMinutes) shouldBe true
    }
})