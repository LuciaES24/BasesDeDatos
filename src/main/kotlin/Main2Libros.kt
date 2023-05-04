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

        val stmt = conexion.prepareStatement("INSERT INTO LIBROS  (TITULO , AUTOR , EDITORIAL , PAGINA ) VALUES (?, ?, ?, ?)")

        val libro = Libro("ROMEO Y JULIETA","SHAKESPEARE","ALFAGUARA",376)

        stmt.setString(1, libro.nombre)


        stmt.setString(2, libro.autor)


        stmt.setString(3, libro.editorial)

        stmt.setInt(4, libro.paginas)

        stmt.executeUpdate()

        println("Inserción exitosa")

        conexion.close()
    } catch (e: SQLException) {
        println("Error en la conexión: ${e.message}")
    } catch (e: ClassNotFoundException) {
        println("No se encontró el driver JDBC: ${e.message}")
    }

}