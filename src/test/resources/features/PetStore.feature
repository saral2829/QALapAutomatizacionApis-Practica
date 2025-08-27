Feature: PetStore

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
    When actualizo la mascota con el nombre "<newnombre>" y el estado "<newstatus>"
    Then se mostrará la mascota con su nombre, estado actualizada y código <statusCode>

    Examples:
      | nombre | newstatus  | statusCode | newnombre |
      | Max    | pending    | 200        | Caty      |
      | Misha  | sold       | 200        | Misifu    |
      | Brenda | available  | 200        | Sofi      |

  @TestConsultarMascota
  Scenario Outline: Consultamos una mascota por su ID
    Given que existe una mascota con ID <idMascota>
    When consulto la mascota por su ID
    Then se mostrará la información de la mascota y se espera el codigo <statusCode>

    Examples:
    | idMascota | statusCode |
    |      1    |    200     |
    |    123    |    200     |
    |   1001    |    404     |
    |      4    |     200    |


