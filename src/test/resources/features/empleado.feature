Feature: Gestión de empleados en OrangeHRM

  Scenario: Crear un nuevo empleado
    Given el administrador está logueado en OrangeHRM
    When crea un empleado con nombre "Juan Pérez"
    Then el empleado aparece en la lista de empleados
  
