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

        var biblioteca = mutableListOf<Libro>()
        val libro = Libro("EL CODIGO DA VINCI","DAN BROWN","TIEM.MODERNOS",421)
        biblioteca.add(libro)
        val libro2 = Libro("HAMLET","SHAKESPEARE","ALFAGUARA",389)
        biblioteca.add(libro2)
        val libro3 = Libro("EL QUIJOTE","MIGUEL DE CERVANTES","CIRCULO",645)
        biblioteca.add(libro3)

        for (uno in biblioteca){
            stmt.setString(1, uno.nombre)

            stmt.setString(2, uno.autor)

            stmt.setString(3, uno.editorial)

            stmt.setInt(4, uno.paginas)

            stmt.executeUpdate()
        }


        println("Inserción exitosa")

        conexion.close()
    } catch (e: SQLException) {
        println("Error en la conexión: ${e.message}")
    } catch (e: ClassNotFoundException) {
        println("No se encontró el driver JDBC: ${e.message}")
    }

}