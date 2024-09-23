package jukebox

class JukeBox() {

    val sons: MutableList<String> = mutableListOf()
    var nombreDeSons: Int = 0


    fun insererCarteDansFente( carte : String, fente: Int) {
        nombreDeSons ++
        sons.add(carte)
    }


}
