import java.sql.*
fun main() {
    // val url = "jdbc:mysql://localhost:3306/sakila"
//jdbc:oracle:thin:@//localhost:1521:xe
    val url = "jdbc:oracle:thin:@localhost:1521:xe"
    val usuario = "alumno"
    val contraseña = "alumno"
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver")
        val conexion = DriverManager.getConnection(url, usuario, contraseña)
        println("Conexión exitosa")

        val stmt = conexion.prepareStatement("SELECT TITULO, AUTOR, EDITORIAL, PAGINA FROM LIBROS")

        val resultSet = stmt.executeQuery()

        val biblioteca = mutableListOf<Libro>()

        while (resultSet.next()){
            val titulo = resultSet.getString("TITULO")
            val autor = resultSet.getString("AUTOR")
            val editorial = resultSet.getString("EDITORIAL")
            val paginas = resultSet.getInt("PAGINA")

            biblioteca.add(Libro(titulo,autor,editorial,paginas))

        }

        for (libro in biblioteca){
            println(libro.toString())
        }


        conexion.close()
    } catch (e: SQLException) {
        println("Error en la conexión: ${e.message}")
    } catch (e: ClassNotFoundException) {
        println("No se encontró el driver JDBC: ${e.message}")
    }

}