package Voiture

import draft.Voiture

class VoitureBuilder {

    private lateinit var PlaqueImat: String

    fun withPlaqueImmatriculation(plaqueImat: String): VoitureBuilder {
        PlaqueImat = plaqueImat;
        return this
    }

    fun build(): Voiture {
        return Voiture(this.PlaqueImat)
    }

    /*
    public VoitureBuilder withPlaqueImmatriculation(String plaqueImat ) {
        this.plaqueImmatriculation = plaqueImat;
        return this;
    }*/

}
