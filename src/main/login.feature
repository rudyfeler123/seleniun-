Feature: Login

  Scenario: Como usuario, debo poder acceder a la aplicacion con email and password correctos

    Given Accedo a la pagina "https://courses.ultimateqa.com/users/sign_in"
    When Llleno el campo email con "automation.diplomado.dh@outlook.com"
    And Lleno el campo password con "Password123"
    And Hago click en el boton sing in
    Then En la pagina home debo ver el esenario "Automation Ds"


    And Cierro cession

  Scenario: Como usuario, Al ingresar credenciales no validas debo un error

    Given Accedo a la pagina "https://courses.ultimateqa.com/users/sign_in"
    When Llleno el campo email con "automation.diplomado.dh@gmail.com"
    And Lleno el campo password con "Password1235"
    And Hago click en el boton sing in
    Then debo ver un examen de error que dice "Invalid email or password"

  Scenario: Como usuario, debo poder realizar la busqueda de curso

    Given Accedo a la pagina "https://courses.ultimateqa.com/users/sign_in"
    When Llleno el campo email con "automation.diplomado.dh@gmail.com"
    And Lleno el campo password con "Password123"
    And Hago click en el boton sing in
    Then En la pagins home debo ver el usuario "Automation D"
    when Lleno el campo search con "course"
    then El curso "//*[@id="page-content"]/div/div/div[2]/div[1]/div[2]/div/div[3]/div/div/a" Debe ser mostrado
    And Cierre seccion
    
