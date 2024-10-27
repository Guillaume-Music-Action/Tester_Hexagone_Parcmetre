package boundedContexts.location.utilities

import boundedContexts.location.behaviors.IJeDonneDesIdentifiants
import ulid.ULID


class UlidGenerateur : boundedContexts.location.behaviors.IJeDonneDesIdentifiants {
    override fun idSuivant(): String = ULID.randomULID()
}

// juste pour la beauté des interfaces fonctionnelles
val ulidGenerateur = boundedContexts.location.behaviors.IJeDonneDesIdentifiants {
    ULID.randomULID()
}
//probleme: c'est pas facile à tester


class testableIdGenerateur : boundedContexts.location.behaviors.IJeDonneDesIdentifiants {

    override fun idSuivant(): String {
        TODO("quelque chose de facile à tester")
    }

}