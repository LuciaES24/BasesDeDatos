class Libro(nom:String, aut:String, ed:String, pag:Int){
    val nombre = nom
    var autor = aut
    val editorial = ed
    val paginas = pag
    override fun toString(): String {
        return "Libro: Nombre='$nombre'| Autor='$autor' | Editorial='$editorial' | Paginas=$paginas)"
    }


}