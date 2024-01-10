import java.util.*

var quotafixa: Double = 6.0
fun consumoagua(): Double {
    val scanner = Scanner(System.`in`)
    print("Ingrese el consumo de agua: ")
    val consumo: Double = scanner.nextDouble()
    return consumo
}


fun quotavariable(): Double {
    val consum: Double = consumoagua()

    when {
        consum < 50 -> 0.0
        consum in 50.0..200.0 -> 0.15 * consum
        consum > 200 -> 0.30 * consum

        else -> {
            println("Tu consumo carece de sentido, por favor ingresa el número de litros de nuevo.")
            0.0
        }
    }
    return consum
}


fun descuentos(): Double {

    var consumo = quotavariable()

    val scanner = Scanner(System.`in`)

    print("Eres familia numerosa o monoparental? (SI->1 o NO->2) ")
    val opcion2 = scanner.nextInt()
    if (opcion2 == 2) {
        println("Eres numerosa o monoparental? (NUMEROSA->1 o MONOPARENTAL->2)")
        val tipodefamilia = scanner.nextInt()
        if (tipodefamilia == 1) {
            consumo = consumo * 0.5
        }
        if (tipodefamilia == 2) {
            println("Cuantos miemboros sois en la famila?")
            val miembros = scanner.nextInt()
            val desc = 100 - (miembros / 10)
            consumo = consumo * desc
        }
    }



var consumofinal=consumo+quotafixa
    return consumofinal
}

fun bonoSocial() :Double {
    var consumo = quotavariable()

    val scanner = Scanner(System.`in`)

    print("Tiene ingresos mínimos para sobrevivir? (SI->1 o NO->2) ")
    val opcion = scanner.nextInt()

    if (opcion == 1) {
        println("APTO")
    } else if (opcion == 2) {
        println("NO APTO")
    } else {
        println("!ERROR")
    }

    if (opcion == 1)
        consumo = consumo * 0.2
    quotafixa = quotafixa * 0.5
    val consumofinal = consumo + quotafixa
    return consumofinal
}
    fun formadesglossada() {
        val costoFinal = minOf(bonoSocial(), descuentos())


}


