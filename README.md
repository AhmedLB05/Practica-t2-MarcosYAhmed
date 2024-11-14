![LogoAL ML](https://github.com/user-attachments/assets/6ac0f881-0f7e-49de-958c-ee6509062fcd)

# Índice

- [Presentación](#Presentacion)
- [Instalación](#Instalación)
- [Iniciar el programa](#Iniciar)
- [Ejecución del programa](#Ejecución)

## Presentación

Bienvenidos a **Eventos AL.ML**, su aliado en la gestión y venta de entradas. Nos especializamos en optimizar la experiencia de compra y acceso a eventos, proporcionando una plataforma confiable, eficiente y segura tanto para organizadores como para el público. Nuestro objetivo es hacer que cada paso, desde la adquisición de la entrada hasta el disfrute del espectáculo, sea fluido y sencillo.

### Nuestra experiencia en gestión de entradas

Con una infraestructura digital avanzada, Eventos AL.ML se posiciona como un referente en la venta de entradas para eventos culturales, conciertos y espectáculos en vivo. A lo largo de nuestra trayectoria, hemos trabajado con diversos teatros y recintos, adaptándonos a sus necesidades específicas y ofreciendo herramientas de gestión personalizadas.

Este mes, nos complace anunciar que estamos gestionando la venta de entradas para tres eventos destacados en el **Teatro Maestro Álvarez Alonso**:

- **Las Criadas**  
  Obra teatral de gran impacto que atrae a los amantes del drama y el teatro clásico. Con Eventos AL.ML, hemos implementado un sistema de asignación de asientos y control de aforo que garantiza una experiencia cómoda y organizada desde el momento de la compra hasta el ingreso.

- **II Concierto de Otoño**  
  Para este concierto de temporada, Eventos AL.ML asegura una experiencia de compra ágil y segura, permitiendo al público seleccionar sus asientos y recibir confirmaciones digitales, optimizando el proceso y reduciendo el tiempo de espera en el acceso.

- **Concierto de Jazz**  
  Con una audiencia ávida de buena música y un ambiente vibrante, hemos configurado opciones de compra rápida y accesibilidad para facilitar la adquisición de entradas. Además, nuestro equipo de soporte está disponible para resolver cualquier consulta o inconveniente antes del evento.

### ¿Por qué elegir Eventos AL.ML?

En Eventos AL.ML, sabemos que la gestión de entradas es clave para el éxito de cualquier evento. Nuestros servicios incluyen:

- Sistema de compra en línea intuitivo y seguro, con opciones de pago diversas y confirmación automática.
- Gestión de aforo en tiempo real para asegurar el cumplimiento de las regulaciones de seguridad y maximizar la satisfacción del público.
- Soporte técnico y atención al cliente dedicados, disponibles para resolver dudas y asistir tanto a los organizadores como al público.
- Análisis y reportes post-evento que ayudan a los organizadores a entender mejor el comportamiento de sus asistentes.

Con Eventos AL.ML, los organizadores pueden concentrarse en ofrecer experiencias excepcionales mientras nosotros nos encargamos de que el proceso de venta de entradas y acceso sea impecable.

Si está buscando una solución profesional y confiable para gestionar la venta de entradas, **Eventos AL.ML** es la elección ideal.

## Instalación

Para poder ejecutar el programa, debemos instalar el **JDK 21**. [Haz clic aquí para descargarlo directamente en tu ordenador](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html).

1. **Instalación del JDK 21**  
   Una vez descargado, instala el JDK y asegúrate de que se encuentra en la ruta `C:\Program Files\Java`.

2. **Configuración de Variables de Entorno**  
   Para configurar las variables de entorno en Windows:
   - Abre el menú de inicio y busca **Variables de entorno**.
   - Aparecerá una ventana; selecciona la opción **Variables de entorno** para continuar con la configuración.

![Captura de pantalla 2024-11-14 162410](https://github.com/user-attachments/assets/76ba0089-a4d4-484e-b001-6688f4b65d05)

   Se nos abrirá la siguiente ventana, seleccionamos “**Path**” y pulsamos sobre **editar**.

![Captura de pantalla 2024-11-14 164707](https://github.com/user-attachments/assets/737cdb62-eabf-4416-8fe3-706bc51e2518)

   Se abrirá una nueva ventana, haremos clic en la variable de Java e introducimos la siguiente ruta: `C:\Program Files\Java\jdk-18.0.2.1\bin`.

![Captura de pantalla 2024-11-14 165301](https://github.com/user-attachments/assets/b9d79a8c-2438-4cbc-81e2-fe859c05ee72)

Luego, confirmamos y aceptamos.

# Iniciar
  
- Descargamos mediante el enlace a **GitHub** el archivo **.zip**.
- Creamos una carpeta en **C:** con el nombre que queramos e introducimos el archivo `.zip` que hemos descargado.
- Descomprimimos el archivo y abrimos la carpeta que se genera.
- Entramos en la carpeta **out\artifacts\PracticaObligatoriaT2_jar**, y pulsamos sobre el ejecutable. El programa comenzará a funcionar.

# Ejecución
#### - Al ejecutar el programa nos saldrá el nombre del teatro  y las diferentes opciones de las que disponemos:
	Nos permitirá vender entradas
	Nos permitirá consultar el estado de un evento (Entradas libres, descuento...)
	Acceso al menú administrador a traves de un usuario y contraseña pedidos por teclado


![Captura de pantalla 2024-11-14 161903](https://github.com/user-attachments/assets/27f1bc27-be4a-41d3-baf5-fbee16fe6960)

####  - Después, al pulsar la primera opción que sirve para vender entradas nos preguntará sobre que entrada de concierto queremos venderla: 
		
![Captura de pantalla 2024-11-14 161915](https://github.com/user-attachments/assets/68a50dbb-4088-41c8-9b20-8d8882089948)

#### - Tomando como ejemplo la opción "1":
- ###### Nos aparecera el título del evento y los diferentes tipos de asientos que existen.
![Captura de pantalla 2024-11-14 161922](https://github.com/user-attachments/assets/53d947b5-dcc2-4805-afa4-286a9eaefaf9)

#### - Nos preguntará sobre el número de entradas que deseamos comprar
![Captura de pantalla 2024-11-14 161929](https://github.com/user-attachments/assets/362311d7-60fa-4f67-9986-3de801985294)

#### - Al introducir el número de entradas que deseamos:
- ###### Nos preguntará por la fecha en la que estamos realizando la compra y después nos dirá si podemos tener un descuento o no.
- ###### Nos imprime el recibo con el IVA incluido y nos preguntará cuando dinero introduciremos, después introducimos con cuánto dinero vamos a pagar, y nos mostrará el cambio y los billetes y monedas que nos dará

-![Captura de pantalla 2024-11-14 162006](https://github.com/user-attachments/assets/dc7a82f4-8f44-4259-b2cb-6446cedc272a)

#### - A continuación, nos irá mostrando entrada por entrada:
![Captura de pantalla 2024-11-14 162015](https://github.com/user-attachments/assets/03990b90-c11d-487b-a917-74336899fa85)

#### - Volviendo al menú principal en la opción b podemos consultar cualquier evento:
![Captura de pantalla 2024-11-14 162037](https://github.com/user-attachments/assets/4ace897f-e994-474a-9d3d-1c1ffa21f00e)

#### - Al elegir el evento de "Las Criadas":
- ###### Podemos ver que falta una entrada
- ###### El costo de entrada segun el sitio
- ###### Dias restantes al evento
![Captura de pantalla 2024-11-14 162046](https://github.com/user-attachments/assets/ce2d94b0-1882-41fb-8fc1-9bebc3379209)

#### En el menú admin nos pedirá el usuario y contraseña:
	 (será "admin" para ambos)
###### Podemos consultar:
- ###### 1.Los ingresos totales
- ###### 2.Monedas restantes
- ###### 3.Apagar el sofware
![Captura de pantalla 2024-11-14 162102](https://github.com/user-attachments/assets/7d340237-2787-4362-bcaf-64f2bf671bbf)

#### Al elegir la opcion 1:
###### Nos muestra los ingresos totales que hemos conseguido
![Captura de pantalla 2024-11-14 162127](https://github.com/user-attachments/assets/b82d2b60-a79a-4499-9ab7-3f80746454fe)

#### Al elegir la opción 2:
###### Nos mostrara los billetes y monedas restantes que nos queda para el cambio
![Captura de pantalla 2024-11-14 162213](https://github.com/user-attachments/assets/507ab413-56fd-4eb2-adeb-006a0ba93baf)

#### En la opción 3 saldremos del programa
![Captura de pantalla 2024-11-14 162340](https://github.com/user-attachments/assets/22839254-1ca0-4302-95dc-91a5b1b67d71)
