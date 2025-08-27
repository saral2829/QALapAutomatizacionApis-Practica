Feature: Crear mascotas en PetStore

  @TestMascota
  Scenario Outline: Crear mascota con diferentes categorías y nombres
    Given que preparo la información de la mascota con categoría "<categoria>" y nombre "<nombre>"
    When envío la solicitud para crear la mascota
    Then la mascota creada de "<nombre>" con <statusCode>

    Examples:
      | categoria | nombre   |statusCode|
      | perros    | Max      |200        |
      | gatos     | Misha    |100        |
      | aves      | Brenda   |200        |
 @TestActualizarMascota
   Scenario Outline: Actualizamos una mascota a través de su ID
    Given que preparo una mascota con el nombre "<nombre>"
    And envío la creación de la mascota obteniendo el ID
    When actualizo la mascota con el nombre "<nombre>" y el estado "<status>"
    Then se mostrará la mascota actualizada con estado "<status>" y código "<statusCode>"

    Examples:
      | nombre | status     | statusCode |
      | Max    | pending    | 200        |
      | Misha  | sold       | 200        |
      | Brenda | available  | 200        |

