package exercice_1.regles_metier

class DureeDeLocation(val demiHeure: Int ) {
    val dureeEnMinutes: Int = demiHeure * 30

    companion object {
        fun Creer(demiHeures: Int): DureeDeLocation {
            return DureeDeLocation(demiHeures)
        }
    }

}
