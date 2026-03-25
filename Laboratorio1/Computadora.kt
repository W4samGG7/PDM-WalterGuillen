package com.example.consola

class Computadora (var RAM: String, var espacioDeMemoria: String,
                   var sistemaOperativo: String, val CPU: String,
                   val GPU: String, val pantalla: String,
                   val ProgramasInstalados: List<String>) {
    fun encender(){
        println("Bienvenido")
        println("")
    }
    fun apagar(){
        println("")
        println("Apagando el equipo")
    }
    fun mostrarProgramas(){
        println("Programas instalados:")
        ProgramasInstalados.forEach { element ->
            println("$element")}
    }
}

fun main() {
    val	programasActuales = listOf("Steam 2025", "Intellij IDEA 2026","Visual Studio Code 2024",
        "Epic Games 2025", "Goggle Chrome 2024", "Brave 2026")
    val Laptop1 = Computadora("32GB", "1TB", "Windows", "Inter i9",
        "NVDIA RTX 4050","1920x1080 FULL HD", programasActuales)

    Laptop1.encender()
    Laptop1.mostrarProgramas()

    val programasFiltrados = Laptop1.ProgramasInstalados.filter { it.contains( "2026") }

    println("")
    println("Programas Filtrados")
    programasFiltrados.forEach { println(it) }

    Laptop1.apagar()
}
