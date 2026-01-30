Feature: Login en OrangeHRM

  Scenario: Login exitoso con credenciales válidas
    Given el usuario está en la página de login
    When ingresa el usuario "Admin" y la contraseña "admin123"
    Then accede al dashboard correctamente


