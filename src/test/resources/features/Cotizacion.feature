# language: es
@Cotizacion
@SetupDriver
Característica: Cotización
  Como usuario
  Quiero introducir distintas caracteristicas de mi seguro
  Para conocer el precio de mi seguro

  @IrPaginaCotizacion
  @DEV @UAT @PROD
  Escenario: : Alta de Cotización donde tomador (persona física) es asegurado con 2º asegurado
    Dado estoy en la pagina de precarga de cotización
    Y introduzco la fecha de nacimiento: 14, 02, 1981
    Y introduzco el nif: "71215129E"
#    Y selecciono el producto: "DECESOS COMPLETO"
    Y introduzco el codigo postal: "28045"
#    Y selecciono la localidad: "MADRID"
    Y selecciono que el tomador es también el asegurado
    Y añado nuevo asegurado
    Y introduzco la fecha de nacimiento del segundo asegurado: 01, 01, 1981
    Y acepto las condiciones generales
    Cuando calculo la tarificación
    Entonces estoy en la pagina de presupuesto
    Y las frecuencias de pago sean correctas

  @IrPaginaCotizacion
  @DEV @UAT
  Escenario: Alta de Cotización donde tomador (persona física) es asegurado con 2º asegurado y Pack ADN
    Dado estoy en la pagina de precarga de cotización
    Y introduzco la fecha de nacimiento: 17, 06, 1982
    Y introduzco el nif: "53425199v"
    Y selecciono el producto: "DECESOS COMPLETO"
    Y introduzco el codigo postal: "28045"
    Y selecciono la localidad: "MADRID"
    Y añado nuevo asegurado
    Y introduzco la fecha de nacimiento del segundo asegurado: 18, 05, 1982
    Y acepto las condiciones generales
    Y calculo la tarificación
    Y estoy en la pagina de presupuesto
    Y las frecuencias de pago sean correctas
    Cuando añado pack ADN
    Y recalculo la tarificación
    Entonces las frecuencias de pago sean correctas
