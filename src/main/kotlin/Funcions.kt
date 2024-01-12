import org.example.*
import java.util.*
/**
 * Función para obtener el consumo de agua ingresado por el usuario.
 * @return El valor del consumo de agua.
 */
fun consumoagua(): Double {
    val scanner = Scanner(System.`in`)
    print("Ingrese el consumo de agua: ")
    val consumo: Double = scanner.nextDouble()
    return consumo
}

/**
 * Función para calcular la cuota variable en función del consumo de agua.
 * @return La cuota variable calculada.
 */
fun quotavariable(): Double {
    val consum: Double = consumoagua()

    return when {
        consum < 50 -> 0.0
        consum in 50.0..200.0 -> 0.15 * consum
        consum > 200 -> 0.30 * consum
        else -> {
            println("Tu consumo carece de sentido, por favor ingresa el número de litros de nuevo.")
            0.0
        }
    }
}

/**
 * Función para calcular descuentos familiares.
 * @return La cuota variable después de aplicar los descuentos familiares.
 */
fun descuentos(): Double {
    val bono = bonoSocial()
    val quota = quotavariable()
    val scanner = Scanner(System.`in`)

    println("Eres numerosa o monoparental? (NUMEROSA->1 o MONOPARENTAL->2)")
    val tipodefamilia = scanner.nextInt()
    println("Cuantos miembros sois en la familia?")
    val miembros = scanner.nextInt()

    var descuento = 0.0

    if (tipodefamilia == 1 || tipodefamilia == 2) {
        val descuentoIndividuo = 10.0
        val maximoDescuento = 50.0


        descuento = if (miembros * descuentoIndividuo <= maximoDescuento) {
            quota * (miembros * descuentoIndividuo) / 100.0
        } else {
            quota * (maximoDescuento) / 100.0
        }
    }

    return quota
}

/**
 * Función para calcular el bono social.
 * @return El costo total después de aplicar el bono social.
 */
fun bonoSocial(): Double {
    val quota = quotavariable()
    var quotafixa: Double = 3.0
    val scanner = Scanner(System.`in`)
    val descuentoConsumo = quota * 0.2

    val consumofinal = descuentoConsumo + quotafixa



    return consumofinal


}

/**
 * Función para mostrar de forma desglosada el costo de la factura de agua.
 */
fun formadesglossada() {
    val quota = quotavariable()
    println("Tienes bono o familia numerosa/monoparental)? ( (BONO->1  NUMEROSA/MONOPARENTAL->2  LAS DOS->3  NO->4)")
    val opcion: Int = readln().toInt()
    if (opcion == 1) {
        bonoSocial()
    } else if (opcion == 2) {
        descuentos()
    } else if (opcion == 1) {
        bonoSocial()
    } else if (opcion == 3) {
        bonoSocial()
    } else if (opcion == 4) {
        println(quota)

    } else {
        println("vuelve a intentarlo")
    }


    val costQuotaFixa: Double = 6.0
    val consumLitres: Double


    consumLitres = consumoagua()


    when (opcion) {
        1 -> {
            val consumTotal = bonoSocial()
            println("Desglose de costos:")
            println("Cuota fija: ${costQuotaFixa / 2} ")
            println("Consumo de litros de agua: $consumLitres")
            println("Costo total después de bono social: $consumTotal")
        }

        2 -> {
            val consumTotal = descuentos()
            println("Desglose de costos:")
            println(" Cuota fija: $costQuotaFixa")
            println(" Consumo de litros de agua: $consumLitres")
            println("  Costo total después de descuentos: $consumTotal")
        }

        3 -> {
            val consumTotal = bonoSocial()
            println("Desglose de costos:")
            println(" Cuota fija: ${costQuotaFixa / 2} ")
            println(" Consumo de litros de agua: $consumLitres")
            println(" Costo total después de bono social: $consumTotal")
        }

        else -> {
            println("Desglose de costos:")
            println(" Cuota fija: $costQuotaFixa")
            println(" Consumo de litros de agua: $consumLitres")
            println(" Costo total: $quota")
        }
    }
}
