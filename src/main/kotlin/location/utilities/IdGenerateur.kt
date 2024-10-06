package location.utilities

import location.behaviors.IJeDonneDesIdentifiants
import ulid.ULID


class UlidGenerateur : IJeDonneDesIdentifiants {
    override fun idSuivant(): String = ULID.randomULID()
}

// juste pour la beauté des interfaces fonctionnelles
val ulidGenerateur = IJeDonneDesIdentifiants {
    ULID.randomULID()
}
//probleme: c'est pas facile à tester


class testableIdGenerateur : IJeDonneDesIdentifiants {

    override fun idSuivant(): String {
        TODO("quelque chose de facile à tester")
    }

}