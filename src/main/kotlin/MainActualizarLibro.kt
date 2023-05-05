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

        val stmt = conexion.prepareStatement("UPDATE LIBROS SET EDITORIAL = ? WHERE TITULO = ?")

        stmt.setString(1, "SM")

        stmt.setString(2,"HAMLET")

        val rowsUpdated = stmt.executeUpdate()

        if (rowsUpdated>0){
            println("Se ha actualizado correctamente")
        }else{
            println("No se ha podido actualizar")
        }

        conexion.close()
    } catch (e: SQLException) {
        println("Error en la conexión: ${e.message}")
    } catch (e: ClassNotFoundException) {
        println("No se encontró el driver JDBC: ${e.message}")
    }

}