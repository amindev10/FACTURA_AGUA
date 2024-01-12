

# Factura de Agua

Este proyecto en Kotlin calcula el costo de la factura de agua en función de diferentes parámetros, como el consumo de agua, descuentos familiares y el bono social.

## Funciones Principales

### `consumoagua()`

- Solicita al usuario ingresar el consumo de agua en litros.

### `quotavariable()`

- Calcula la cuota variable en función del consumo de agua.
- Aplica tarifas diferentes según el rango de consumo.

### `descuentos()`

- Calcula descuentos familiares en función del tipo de familia y el número de miembros.
- Los descuentos no son acumulables.

### `bonoSocial()`

- Aplica un descuento del 80% sobre el consumo en caso de tener el bono social.
- Reducción de la cuota fija a 3€.

### `formadesglossada()`

- Muestra de forma desglosada el costo de la factura.
- Presenta información detallada sobre la cuota fija, consumo de litros de agua y los descuentos aplicados.
