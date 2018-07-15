Feature: Search

  Scenario Outline: Como usuario, debo poder realizar busqueda de cursos
    Given Accedo a la pagina "https://courses.ultimateqa.com/users/sign_in"
    When Lleno el campo email con "automation.diplomado.dh@outlook.com"
    And Lleno el campo password con "Password123"
    And Hago click en el boton Sing In
    Then En la pagina home debo ver el usuario "Automation D"
    And  hacer click "View more courses"
    When Lleno el campo search con "<course>"
    Then El curso "<course>" debe ser mostrado en home page
    Then hacer click en "<course>" para ingresar curso
    Then verificar que el precio "<precio>" sea correcto
    And Cierro sesion
    Examples:
      |course                                                             |precio         |
      |C# For QA Automation Engineers with Selenium Webdriver             |Enroll for free|
      |Complete Selenium Webdriver with C# - Build A Framework            |Buy $349.99    |
      |Page Objects in Test Automation                                    |Buy $49.00     |
      |Sauce Labs Advanced Course                                         |Buy $49.99     |
