package com.example.consola

class Estudiantes(val nombre: String, val carnet: Int, var asignatura: String) {
}

fun main() {

    val Estudiante1 = Estudiantes("Enrique", 78090, "DPM")
    val Estudiante2 = Estudiantes("Karla", 34589, "DPM")
    val Estudiante3 = Estudiantes("Raul", 65790, "DPM")
    val Estudiante4 = Estudiantes("Tania", 82989, "Analisis Numerico")
    val Estudiante5 = Estudiantes("Ulises", 29389, "Analisis Numerico")
    val Estudiante6 = Estudiantes("Ivonne", 24791, "Analisis Numerico")
    val Estudiante7 = Estudiantes("Omar", 47290, "Analisis Numerico")

    val ciclo01 = listOf(
        Estudiante1,
        Estudiante2,
        Estudiante3,
        Estudiante4,
        Estudiante5,
        Estudiante6,
        Estudiante7
    )

    val cantidadEstudiantes = ciclo01.filter { it.asignatura === "DPM" }

    cantidadEstudiantes.forEach { println("Nombre:" + it.nombre + ", " + "Carnet:" + it.carnet + ", " + "Asignatura:" + it.asignatura) }
}