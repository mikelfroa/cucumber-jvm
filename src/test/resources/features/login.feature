@SetupDriver
@Login
Feature: Login
  Como usuario
  Quiero logarme en la aplicación
  Para acceder a mi área personal

  @GoHomePage
  Scenario: Hacer login correcto
    Given estoy en la pagina de login