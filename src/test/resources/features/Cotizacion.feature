@SetupDriver
@Cotizacion
Feature: Cotización
  Como usuario
  Quiero introducir distintas caracteristicas de mi seguro
  Para conocer el precio de mi seguro

  @GoHomePage
  Scenario: Alta de Cotización donde tomador (persona física) es asegurado con 2º aseguradoNavigate to the home page
    Given estoy en la pagina de precarga de cotización
    And introduzco la fecha de nacimiento: 14, 02, 1981
    And introduzco el nif: "71215129E"