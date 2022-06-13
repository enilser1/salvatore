# language: es
Característica: Verificar articulos y sus precios

  Antecedentes:
    Dado Un cliente ingresa a la pagina de ebay

  @EscenariosRimac
  Esquema del escenario: Flujo 1
    Cuando realiza una búsqueda de zapatilla deportiva,
    Y realiza un filtro por dos colores de una marca específica
      | <primerColor> | <segundoColor> | <marca> |
    Entonces obtiene el precio de la marca en su 3 posición y su precio mas caro

    Ejemplos:
      | primerColor | segundoColor | marca  |
      | Blanco      | Rojo         | adidas |
      | Blanco      | Rojo         | Wilson |


  @EscenariosRimacs
  Escenario: Flujo 2
    Cuando va al menu Casa y Jardín , selecciona Bricolaje luego Materiales de bricolaje,
    Y selecciona la opcion Puertas de garage, selecciona la marca Ditec,
    Entonces el precio de Entrematic DITEC ZEN2 es de 18,00 EUR en total