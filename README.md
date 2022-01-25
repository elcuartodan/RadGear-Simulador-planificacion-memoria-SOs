Simulador de planificación de memoria mediante la técnica de paginación por demanda con asignación dinámica y reemplazo global. Ideal para estudiantes de carreras universitarias relacionadas a la informática y que cursen Sistemas Operativos.

Soporta:
- Selección entre un proceso o multiproceso*(1)(2).
- Culminación de procesos no simultánea.
- Opción para la distinción de páginas modificadas y uso de un marco para la descarga asincrónica.
- Intercambiar entre algoritmos FIFO, LRU y Segunda Chance manteniendo los mismos datos.
- Ingreso de cantidad de marcos deseada de hasta 2 dígitos.

Genera un archivo de texto en el directorio actual, el cuál contiene un diagrama de Gantt con el resultado de la simulación e incluye la contabilización de los fallos de página. La generación utiliza los recursos del sistema anfitrión, por lo que el formato se ajusta al Sistema Operativo utilizado. Para poder visualizar correctamente el resultado, es necesario desactivar la opción "Ajuste de línea" del lector de texto utilizado (notepad, wordpad, etc.).

*(1)Debido a su naturaleza mixta, para la lista Lote y lista de procesos no se realizan chequeos de tipo, pues esto complejiza la solución y por lo tanto, afecta el rendimiento del programa. Es responsabilidad del usuario ingresar datos con el formato correcto y valores válidos, caso contrario el comportamiento del simulador es impredecible.

*(2)Desmarcar la opción de múltiples procesos causa el borrado de la lista de procesos.
