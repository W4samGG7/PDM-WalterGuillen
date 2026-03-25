package com.example.consola

class Calculadora(val marca: String, val añosDeVida: Int, var precio: Double) {

    fun suma() {
        println("")
        println("Metodo Suma")
        var primerNumero: Double? = null
        do {
            println("Ingrese el primer numero:")
            primerNumero = readln().toDoubleOrNull()
            if (primerNumero == null) {
                println("Ingreso de Dato invalido")
            }
        } while (primerNumero == null)

        var segundoNumero: Double? = null
        do {
            println("Ingrese el segundo numero:")
            segundoNumero = readln().toDoubleOrNull()
            if (segundoNumero == null) {
                println("Ingreso de Dato invalido")
            }
        } while (segundoNumero == null)


        println("La suma $primerNumero de $segundoNumero es ${primerNumero + segundoNumero}")
    }

    fun resta() {
        println("")
        println("Metodo Resta")
        var primerNumero: Double? = null
        do {
            println("Ingrese el primer numero:")
            primerNumero = readln().toDoubleOrNull()
            if (primerNumero == null) {
                println("Ingreso de Dato invalido")
            }
        } while (primerNumero == null)

        var segundoNumero: Double? = null
        do {
            println("Ingrese el segundo numero:")
            segundoNumero = readln().toDoubleOrNull()
            if (segundoNumero == null) {
                println("Ingreso de Dato invalido")
            }
        } while (segundoNumero == null)


        println("La resta de $primerNumero y $segundoNumero es ${primerNumero - segundoNumero}")
    }
    fun multiplicacion() {
        println("")
        println("Metodo Multiplicacion")
        var primerNumero: Double? = null
        do {
            println("Ingrese el primer numero:")
            primerNumero = readln().toDoubleOrNull()
            if (primerNumero == null) {
                println("Ingreso de Dato invalido")
            }
        } while (primerNumero == null)

        var segundoNumero: Double? = null
        do {
            println("Ingrese el segundo numero:")
            segundoNumero = readln().toDoubleOrNull()
            if (segundoNumero == null) {
                println("Ingreso de Dato invalido")
            }
        } while (segundoNumero == null)

        println("La multiplicacion de $primerNumero y $segundoNumero es ${primerNumero * segundoNumero}")
    }
    fun dividir() {
        println("Metodo Dividir")
        var primerNumero: Double? = null
        do {
            println("Ingrese el primer numero:")
            primerNumero = readln().toDoubleOrNull()
            if (primerNumero == null) {
                println("Ingreso de Dato invalido")
            }
        } while (primerNumero == null)

        var segundoNumero: Double? = null
        do {
            println("Ingrese el segundo numero:")
            segundoNumero = readln().toDoubleOrNull()
            if (segundoNumero == null || segundoNumero == 0.0) {
                println("Ingreso de Dato invalido")
            }
        } while (segundoNumero == null)


        println("sum of $primerNumero and $segundoNumero is ${primerNumero / segundoNumero}")

    }
}

fun main() {

    val Calculadora1 = Calculadora("Casio", 20, 15.6)

    Calculadora1.suma()
    Calculadora1.resta()
    Calculadora1.multiplicacion()
    Calculadora1.dividir()
}