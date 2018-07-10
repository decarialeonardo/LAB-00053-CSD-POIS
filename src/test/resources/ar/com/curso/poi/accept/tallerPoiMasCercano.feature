  # language: es

Característica: Obtener el POI más cercano a la ubicación actual
  Como usuario
  Quiero obtener el punto de interes más cercano a mi ubicación actual


  Escenario: Obtener el POI más cercano estando parado en Grupo Esfera
    Dado que estoy en -34.609509 y -58.396681
    Cuando pido el POI mas cercano
    Entonces el servicio devuelve Pasco
