import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class PracticaObligatoria {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Declaración de variables de fecha y tiempo para los eventos
        LocalDate fechaCompra, fechaActual = LocalDate.now(), fechaEventoCriadas = LocalDate.of(2024, 12, 15), fechaEventoOtono = LocalDate.of(2024, 12, 20), fechaEventoJazz = LocalDate.of(2024, 12, 25);
        LocalTime horaEventoCriadas = LocalTime.of(22, 00), horaEventoOtono = LocalTime.of(19, 30), horaEventoJazz = LocalTime.of(16, 50);
        //Declaración de variables de entrada de datos, códigos, etc.
        String opMenuPrin, opMenuAdmin, opMenus, opConsultar, adminUser = "admin", adminPass = "admin", adminUserIntro, adminPassIntro, eventoIntro, fechaIntro, codigoUnico = "", auxString, horaActualTexto = "";
        //Variables necesarias
        char caracter;
        long codigoUnicoNum = 0;
        int cantidadEntradas, plateaCriadas = 140, butacasCriadas = 200, anfiteatroCriadas = 200, plateaOtono = 140, butacasOtono = 200, anfiteatroOtono = 200, plateaJazz = 140, butacasJazz = 200, anfiteatroJazz = 200, contadorEntradasFactura, diasDiferenciaFechas, descuentoCriadas = 5, descuentoOtono = 7, descuentoJazz = 3, billete500 = 10, billete200 = 10, billete10 = 50, billete20 = 50, billete50 = 30, billete100 = 20, billete5 = 60, moneda2e = 100, moneda1e = 100, moneda50cent = 200, moneda20cent = 200, moneda10cent = 200, moneda5cent = 200, moneda2cent = 200, moneda1cent = 200, contBillete500 = 0, contBillete200 = 0, contBillete100 = 0, contBillete50 = 0, contBillete20 = 0, contBillete10 = 0, contBillete5 = 0, contMoneda2e = 0, contMoneda1e = 0, contMoneda50cent = 0, contMoneda20cent = 0, contMoneda10cent = 0, contMoneda5cent = 0, contMoneda2cent = 0, contMoneda1cent = 0, plateaCriadasVendidas = 0, butacaCriadasVendidas = 0, anfiteatroCriadasVendidas = 0, iva = 10;
        //Precios y descuentos de cada tipo de entrada para cada evento
        float precioPlateaCriadas = 17, precioButacasCriadas = 20, precioAnfiteatroCriadas = 13, precioPlateaOtono = 12, precioButacasOtono = 15, precioAnfiteatroOtono = 8, precioPlateaJazz = 20, precioButacasJazz = 25, precioAnfiteatroJazz = 15, precio = 0, cambio, dineroInsertado, ingresosTotales = 0;
        boolean salirMenu = true, descuentoDias = false; //Control para salir del bucle

        //Titulo de bienvenida
        System.out.println("""
                ████████╗███████╗ █████╗ ████████╗██████╗  ██████╗     ███╗   ███╗ █████╗ ███████╗███████╗████████╗██████╗  ██████╗\s
                ╚══██╔══╝██╔════╝██╔══██╗╚══██╔══╝██╔══██╗██╔═══██╗    ████╗ ████║██╔══██╗██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔═══██╗
                   ██║   █████╗  ███████║   ██║   ██████╔╝██║   ██║    ██╔████╔██║███████║█████╗  ███████╗   ██║   ██████╔╝██║   ██║
                   ██║   ██╔══╝  ██╔══██║   ██║   ██╔══██╗██║   ██║    ██║╚██╔╝██║██╔══██║██╔══╝  ╚════██║   ██║   ██╔══██╗██║   ██║
                   ██║   ███████╗██║  ██║   ██║   ██║  ██║╚██████╔╝    ██║ ╚═╝ ██║██║  ██║███████╗███████║   ██║   ██║  ██║╚██████╔╝
                   ╚═╝   ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝     ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝\s
                 █████╗ ██╗     ██╗   ██╗ █████╗ ██████╗ ███████╗███████╗     █████╗ ██╗      ██████╗ ███╗   ██╗███████╗ ██████╗\s
                ██╔══██╗██║     ██║   ██║██╔══██╗██╔══██╗██╔════╝╚══███╔╝    ██╔══██╗██║     ██╔═══██╗████╗  ██║██╔════╝██╔═══██╗
                ███████║██║     ██║   ██║███████║██████╔╝█████╗    ███╔╝     ███████║██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║
                ██╔══██║██║     ╚██╗ ██╔╝██╔══██║██╔══██╗██╔══╝   ███╔╝      ██╔══██║██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║
                ██║  ██║███████╗ ╚████╔╝ ██║  ██║██║  ██║███████╗███████╗    ██║  ██║███████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝
                ╚═╝  ╚═╝╚══════╝  ╚═══╝  ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝    ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝\s
                                                                                                                                \s""");
        //Bucle menú principal
        do {
            System.out.print("""
                    ╔════════════════════════════════════╗
                      a. Vender entradas para un evento
                      b. Consultar el estado de un evento
                      c. Menú de Administrador
                    ╚════════════════════════════════════╝
                    Seleccione una opción:\s""");
            opMenuPrin = s.nextLine();
            opMenuPrin = opMenuPrin.toLowerCase();
            //Switch para el menú principal
            switch (opMenuPrin) {
                case "a": //Opción para vender entradas
                    System.out.print("""
                            ╔════════════════════════════════════╗
                              1. Las criadas
                              2. II Concierto de Otoño
                              3. Concierto de Jazz
                            ╚════════════════════════════════════╝
                            Seleccione un evento:\s""");
                    eventoIntro = s.nextLine();
                    //Submenú para eventos
                    switch (eventoIntro) {
                        case "1": //Evento "Las Criadas"
                            System.out.println("\n" + "██╗      █████╗ ███████╗     ██████╗██████╗ ██╗ █████╗ ██████╗  █████╗ ███████╗\n" + "██║     ██╔══██╗██╔════╝    ██╔════╝██╔══██╗██║██╔══██╗██╔══██╗██╔══██╗██╔════╝\n" + "██║     ███████║███████╗    ██║     ██████╔╝██║███████║██║  ██║███████║███████╗\n" + "██║     ██╔══██║╚════██║    ██║     ██╔══██╗██║██╔══██║██║  ██║██╔══██║╚════██║\n" + "███████╗██║  ██║███████║    ╚██████╗██║  ██║██║██║  ██║██████╔╝██║  ██║███████║\n" + "╚══════╝╚═╝  ╚═╝╚══════╝     ╚═════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚══════╝\n" + "                                                                               \n");
                            System.out.println();
                            System.out.print("""
                                    ╔═══════════════╗
                                      1- Platea
                                      2- Butacas
                                      3- Anfiteatro
                                    ╚═══════════════╝
                                    Seleccione una opción:\s""");
                            opMenus = s.nextLine();
                            //Submenú para la seleccion del tipo de entrada
                            switch (opMenus) {
                                case "1": //Entradas platea Criadas
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    //Validacion cantidad de entradas demandadas
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en platea (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > plateaCriadas) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > plateaCriadas);
                                    //cantidadEntradas = contadorEntradasFactura;
                                    plateaCriadas -= cantidadEntradas; //Restamos al total de entradas de platea Criadas las que se van a vender
                                    //Solicitamos la fecha de compra y calculamos el descuento
                                    do {
                                        System.out.print("  Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }

                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoCriadas, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) { //Aplicamos descuento si faltan 7 dias o mas
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoCriadas + "%");
                                            precio = precioPlateaCriadas - (precioPlateaCriadas * descuentoCriadas / 100);
                                        }
                                        if (diasDiferenciaFechas < 0) //Rechazamos la venta si pone una fecha posterior al evento
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) { //En caso de que no haya descuento se lo decimos
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioPlateaCriadas;
                                        }
                                    } while (diasDiferenciaFechas < 0); //Repetir si la fecha de compra es después del evento
                                    //Mensaje de espera
                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoCriadas.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }
                                    //Generamos el recibo para solicitar el pago de las entradas
                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔────────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚────────────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();

                                    //El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    ingresosTotales += precio;

                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero
                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                           ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                          ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                          ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌         \s
                                                          ▐░▌          ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                          ▐░▌          ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                          ▐░▌          ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌
                                                          ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌          ▐░▌
                                                          ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌ ▄▄▄▄▄▄▄▄▄█░▌
                                                          ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░░▌
                                                           ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀   ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                    \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: Las Criadas
                                                           Entrada General Platea                                               Eventos AL.ML
                                                           CODIGO UNICO: %d                                            Empresa distribuidora de entradas
                                                                                                                      -------------------------------------
                                                                                                                      Esta empresa no está encargada del evento
                                                           Precio Base: %3.2f + IVA del %d %% = %.2f
                                                
                                                
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoCriadas.toString(), horaEventoCriadas.toString(), codigoUnicoNum, precioPlateaCriadas, iva, ((float) (precioPlateaCriadas * iva / 100) + precioPlateaCriadas));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");

                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }
                                    break;
                                case "2": //Evento "Las Criadas"
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    //Validacion cantidad de entradas demandadas
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en butacas (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > butacasCriadas) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > butacasCriadas);
                                    //cantidadEntradas = contadorEntradasFactura;
                                    butacasCriadas -= cantidadEntradas; //Restamos al total de entradas de butacas Criadas las que se van a vender
                                    //Solicitamos la fecha de compra y calculamos el descuento
                                    do {
                                        System.out.print("  Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }
                                        //Calculamos la diferencia de días
                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoCriadas, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) { //Aplicamos descuento si faltan 7 dias o mas
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoCriadas + "%");
                                            precio = precioButacasCriadas - (precioButacasCriadas * descuentoCriadas / 100);
                                        }
                                        if (diasDiferenciaFechas < 0) //Rechazamos la venta si pone una fecha posterior al evento
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) { //En caso de que no haya descuento se lo decimos
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioButacasCriadas;
                                        }
                                    } while (diasDiferenciaFechas < 0); //Repetir si la fecha de compra es después del evento
                                    //Mensaje de espera
                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoCriadas.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }
                                    //Generamos el recibo para solicitar el pago de las entradas
                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔──────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚──────────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();

                                    //El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    ingresosTotales += precio;


                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero
                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                           ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                          ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                          ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌         \s
                                                          ▐░▌          ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                          ▐░▌          ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                          ▐░▌          ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌
                                                          ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌          ▐░▌
                                                          ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌ ▄▄▄▄▄▄▄▄▄█░▌
                                                          ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░░▌
                                                           ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀   ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                    \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: Las Criadas
                                                           Entrada General Butacas                                               Eventos AL.ML
                                                           CODIGO UNICO: %d                                            Empresa distribuidora de entradas
                                                                                                                      -------------------------------------
                                                                                                                      Esta empresa no está encargada del evento
                                                
                                                           Precio (el descuento está aplicado si es usted beneficiario): %3.2f + IVA del %d %% = %.2f
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoCriadas.toString(), horaEventoCriadas.toString(), codigoUnicoNum, precioButacasCriadas, iva, ((float) (precioButacasCriadas * iva / 100) + precioButacasCriadas));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");

                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }
                                    break;
                                case "3": //Entradas anfiteatro Criadas
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en anfiteatro (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > anfiteatroCriadas) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > anfiteatroCriadas);
                                    //cantidadEntradas = contadorEntradasFactura;
                                    anfiteatroCriadas -= cantidadEntradas; //Restamos al total de entradas de platea Criadas las que se van a vender
                                    do {
                                        System.out.print("  Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }

                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoCriadas, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) {
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoCriadas + "%");
                                            precio = precioAnfiteatroCriadas - (precioAnfiteatroCriadas * descuentoCriadas / 100);
                                        }
                                        if (diasDiferenciaFechas < 0)
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) {
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioAnfiteatroCriadas;
                                        }
                                    } while (diasDiferenciaFechas < 0);


                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoCriadas.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }

                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚───────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();

                                    //El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    ingresosTotales += precio;

                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero
                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                           ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                          ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                          ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌         \s
                                                          ▐░▌          ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                          ▐░▌          ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                          ▐░▌          ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌
                                                          ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌          ▐░▌
                                                          ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌ ▄▄▄▄▄▄▄▄▄█░▌
                                                          ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░░▌
                                                           ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀   ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                    \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: Las Criadas
                                                           Entrada General Anfiteatro                                               Eventos AL.ML
                                                           CODIGO UNICO: %d                                            Empresa distribuidora de entradas
                                                                                                                      -------------------------------------
                                                                                                                      Esta empresa no está encargada del evento
                                                
                                                           Precio (el descuento está aplicado si es usted beneficiario): %3.2f + IVA del %d %% = %.2f
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoCriadas.toString(), horaEventoCriadas.toString(), codigoUnicoNum, precioAnfiteatroCriadas, iva, ((float) (precioAnfiteatroCriadas * iva / 100) + precioAnfiteatroCriadas));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }
                                    break;
                            }

                            break;
                        case "2":
                            System.out.println("██╗██╗     ██████╗ ██████╗ ███╗   ██╗ ██████╗██╗███████╗██████╗ ████████╗ ██████╗     ██████╗ ███████╗     ██████╗ ████████╗ ██████╗ ███╗   ██╗ ██████╗ \n" + "██║██║    ██╔════╝██╔═══██╗████╗  ██║██╔════╝██║██╔════╝██╔══██╗╚══██╔══╝██╔═══██╗    ██╔══██╗██╔════╝    ██╔═══██╗╚══██╔══╝██╔═══██╗████╗  ██║██╔═══██╗\n" + "██║██║    ██║     ██║   ██║██╔██╗ ██║██║     ██║█████╗  ██████╔╝   ██║   ██║   ██║    ██║  ██║█████╗      ██║   ██║   ██║   ██║   ██║██╔██╗ ██║██║   ██║\n" + "██║██║    ██║     ██║   ██║██║╚██╗██║██║     ██║██╔══╝  ██╔══██╗   ██║   ██║   ██║    ██║  ██║██╔══╝      ██║   ██║   ██║   ██║   ██║██║╚██╗██║██║   ██║\n" + "██║██║    ╚██████╗╚██████╔╝██║ ╚████║╚██████╗██║███████╗██║  ██║   ██║   ╚██████╔╝    ██████╔╝███████╗    ╚██████╔╝   ██║   ╚██████╔╝██║ ╚████║╚██████╔╝\n" + "╚═╝╚═╝     ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝     ╚═════╝ ╚══════╝     ╚═════╝    ╚═╝    ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ \n" + "                                                                                                                                                        ");
                            System.out.print("""
                                    ╔═══════════════╗
                                      1- Platea
                                      2- Butacas
                                      3- Anfiteatro
                                    ╚═══════════════╝
                                    Seleccione una opción:\s""");
                            opMenus = s.nextLine();
                            switch (opMenus) {
                                case "1":
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en platea (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > plateaOtono) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > plateaOtono);
                                    //cantidadEntradas = contadorEntradasFactura;
                                    plateaOtono -= cantidadEntradas; //Restamos al total de entradas de platea Otoño las que se van a vender
                                    do {
                                        System.out.print("  Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }

                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoOtono, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) {
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoOtono + "%");
                                            precio = precioPlateaOtono - (precioPlateaOtono * descuentoOtono / 100);
                                        }
                                        if (diasDiferenciaFechas < 0)
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) {
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioPlateaOtono;
                                        }
                                    } while (diasDiferenciaFechas < 0);

                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoOtono.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }

                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚───────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();

                                    //El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    ingresosTotales += precio;

                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero
                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                           ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                            ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀      ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌               ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌               ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌               ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌
                                                            ▄▄▄▄█░█▄▄▄▄  ▄▄▄▄█░█▄▄▄▄      ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌      ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌
                                                           ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌     ▐░░░░░░░░░░░▌
                                                            ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                                              \s
                                                                                     ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                                                    ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌
                                                                                    ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀█░▌
                                                                                    ▐░▌       ▐░▌▐░▌               ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░░░░░░░░░░░▌     ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░▌               ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌       ▐░▌
                                                                                    ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄█░▌
                                                                                    ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌
                                                                                     ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                   \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: II CONCIERTO DE OTOÑO
                                                           Entrada General Platea                                                                                  Eventos AL.ML
                                                           CODIGO UNICO: %d                                                                              Empresa distribuidora de entradas
                                                                                                                                                        -------------------------------------
                                                                                                                                                         Esta empresa no está encargada del evento
                                                
                                                           Precio (el descuento está aplicado si es usted es beneficiario): %3.2f + IVA del %d %% = %.2f
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoOtono.toString(), horaEventoOtono.toString(), codigoUnicoNum, precioPlateaOtono, iva, ((float) (precioPlateaOtono * iva / 100) + precioPlateaOtono));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");

                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }


                                    //SEGUIR POR AQUIIIIIIIIIIII
                                    break;
                                case "2":
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en butacas (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > butacasOtono) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > butacasOtono);
                                    butacasOtono -= cantidadEntradas; //Restamos al total de entradas de butacas Otoño las que se van a vender
                                    do {
                                        System.out.print("  Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }

                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoOtono, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) {
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoOtono + "%");
                                            precio = precioButacasOtono - (precioButacasOtono * descuentoOtono / 100);
                                        }
                                        if (diasDiferenciaFechas < 0)
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) {
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioButacasOtono;
                                        }
                                    } while (diasDiferenciaFechas < 0);

                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoOtono.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }

                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚───────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();

                                    //El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    ingresosTotales += precio;

                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero
                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                           ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                            ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀      ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌               ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌               ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌               ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌
                                                            ▄▄▄▄█░█▄▄▄▄  ▄▄▄▄█░█▄▄▄▄      ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌      ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌
                                                           ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌     ▐░░░░░░░░░░░▌
                                                            ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                                              \s
                                                                                     ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                                                    ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌
                                                                                    ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀█░▌
                                                                                    ▐░▌       ▐░▌▐░▌               ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░░░░░░░░░░░▌     ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░▌               ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌       ▐░▌
                                                                                    ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄█░▌
                                                                                    ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌
                                                                                     ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                   \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: II CONCIERTO DE OTOÑO
                                                           Entrada General Butacas                                                                                  Eventos AL.ML
                                                           CODIGO UNICO: %d                                                                              Empresa distribuidora de entradas
                                                                                                                                                        -------------------------------------
                                                                                                                                                         Esta empresa no está encargada del evento
                                                
                                                           Precio (el descuento está aplicado si es usted es beneficiario): %3.2f + IVA del %d %% = %.2f
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoOtono.toString(), horaEventoOtono.toString(), codigoUnicoNum, precioButacasOtono, iva, ((float) (precioButacasOtono * iva / 100) + precioButacasOtono));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");

                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }


                                    //SEGUIR POR AQUIIIIIIIIIIII
                                    break;
                                case "3":
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en anfiteatro (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > anfiteatroOtono) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > anfiteatroOtono);
                                    //cantidadEntradas = contadorEntradasFactura;
                                    anfiteatroOtono -= cantidadEntradas; //Restamos al total de entradas de platea Otoño las que se van a vender
                                    do {
                                        System.out.print("  Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }

                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoOtono, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) {
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoOtono + "%");
                                            precio = precioAnfiteatroOtono - (precioAnfiteatroOtono * descuentoOtono / 100);
                                        }
                                        if (diasDiferenciaFechas < 0)
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) {
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioAnfiteatroOtono;
                                        }
                                    } while (diasDiferenciaFechas < 0);

                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoOtono.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }

                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚───────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();

//El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    ingresosTotales += precio;

                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero
                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                           ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                            ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀      ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌               ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌               ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌               ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌       ▐░▌
                                                                ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌
                                                            ▄▄▄▄█░█▄▄▄▄  ▄▄▄▄█░█▄▄▄▄      ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌      ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌
                                                           ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌     ▐░░░░░░░░░░░▌
                                                            ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                                              \s
                                                                                     ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                                                    ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌
                                                                                    ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀█░▌
                                                                                    ▐░▌       ▐░▌▐░▌               ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░░░░░░░░░░░▌     ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌       ▐░▌
                                                                                    ▐░▌       ▐░▌▐░▌               ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌       ▐░▌
                                                                                    ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄█░▌
                                                                                    ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌
                                                                                     ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                   \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: II CONCIERTO DE OTOÑO
                                                           Entrada General Anfiteatro                                                                                  Eventos AL.ML
                                                           CODIGO UNICO: %d                                                                              Empresa distribuidora de entradas
                                                                                                                                                        -------------------------------------
                                                                                                                                                         Esta empresa no está encargada del evento
                                                
                                                           Precio (el descuento está aplicado si es usted es beneficiario): %3.2f + IVA del %d %% = %.2f
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoOtono.toString(), horaEventoOtono.toString(), codigoUnicoNum, precioAnfiteatroOtono, iva, ((float) (precioAnfiteatroOtono * iva / 100) + precioAnfiteatroOtono));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");

                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }
                                    break;
                            }

                            break;
                        case "3":
                            System.out.println(" ██████╗ ██████╗ ███╗   ██╗ ██████╗██╗███████╗██████╗ ████████╗ ██████╗     ██████╗ ███████╗         ██╗ █████╗ ███████╗███████╗\n" + "██╔════╝██╔═══██╗████╗  ██║██╔════╝██║██╔════╝██╔══██╗╚══██╔══╝██╔═══██╗    ██╔══██╗██╔════╝         ██║██╔══██╗╚══███╔╝╚══███╔╝\n" + "██║     ██║   ██║██╔██╗ ██║██║     ██║█████╗  ██████╔╝   ██║   ██║   ██║    ██║  ██║█████╗           ██║███████║  ███╔╝   ███╔╝ \n" + "██║     ██║   ██║██║╚██╗██║██║     ██║██╔══╝  ██╔══██╗   ██║   ██║   ██║    ██║  ██║██╔══╝      ██   ██║██╔══██║ ███╔╝   ███╔╝  \n" + "╚██████╗╚██████╔╝██║ ╚████║╚██████╗██║███████╗██║  ██║   ██║   ╚██████╔╝    ██████╔╝███████╗    ╚█████╔╝██║  ██║███████╗███████╗\n" + " ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝     ╚═════╝ ╚══════╝     ╚════╝ ╚═╝  ╚═╝╚══════╝╚══════╝\n" + "                                                                                                                                ");
                            System.out.print("""
                                    ╔═══════════════╗
                                      1- Platea
                                      2- Butacas
                                      3- Anfiteatro
                                    ╚═══════════════╝
                                    Seleccione una opción:\s""");
                            opMenus = s.nextLine();
                            switch (opMenus) {
                                case "1":
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en platea (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > plateaJazz) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > plateaJazz);
                                    //cantidadEntradas = contadorEntradasFactura;
                                    plateaJazz -= cantidadEntradas; //Restamos al total de entradas de platea Otoño las que se van a vender
                                    do {
                                        System.out.print("Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }

                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoJazz, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) {
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoJazz + "%");
                                            precio = precioPlateaJazz - (precioPlateaJazz * descuentoJazz / 100);
                                        }
                                        if (diasDiferenciaFechas < 0)
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) {
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioPlateaJazz;
                                        }
                                    } while (diasDiferenciaFechas < 0);

                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoJazz.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }

                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚───────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();

//El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero

                                        ingresosTotales += precio;

                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                         ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄\s
                                                        ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌
                                                        ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌         \s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌               ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌               ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░░░░░░░░░░░▌
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌               ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌         \s
                                                        ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌      ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                        ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌     ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌
                                                         ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                                           \s
                                                                                                          ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                                                                         ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                          ▀▀▀▀▀█░█▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌
                                                                                                               ▐░▌    ▐░▌       ▐░▌          ▐░▌          ▐░▌
                                                                                                               ▐░▌    ▐░█▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌
                                                                                                               ▐░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                               ▐░▌    ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀\s
                                                                                                               ▐░▌    ▐░▌       ▐░▌▐░▌          ▐░▌         \s
                                                                                                          ▄▄▄▄▄█░▌    ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄\s
                                                                                                         ▐░░░░░░░▌    ▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                          ▀▀▀▀▀▀▀      ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                            \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: CONCIERTO DE JAZZ
                                                           Entrada General Platea                                                                                  Eventos AL.ML
                                                           CODIGO UNICO: %d                                                                              Empresa distribuidora de entradas
                                                                                                                                                        -------------------------------------
                                                                                                                                                         Esta empresa no está encargada del evento
                                                
                                                           Precio (el descuento está aplicado si es usted es beneficiario): %3.2f + IVA del %d %% = %.2f
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoJazz.toString(), horaEventoJazz.toString(), codigoUnicoNum, precioPlateaJazz, iva, ((float) (precioPlateaJazz * iva / 100) + precioPlateaJazz));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");

                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }


                                    //SEGUIR POR AQUIIIIIIIIIIII
                                    break;
                                case "2":
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en butacas (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > butacasJazz) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > butacasJazz);
                                    butacasJazz -= cantidadEntradas; //Restamos al total de entradas de butacas Otoño las que se van a vender
                                    do {
                                        System.out.print("Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }

                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoJazz, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) {
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoJazz + "%");
                                            precio = precioButacasJazz - (precioButacasJazz * descuentoJazz / 100);
                                        }
                                        if (diasDiferenciaFechas < 0)
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) {
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioButacasJazz;
                                        }
                                    } while (diasDiferenciaFechas < 0);


                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoJazz.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }

                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚───────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();

                                    //El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    ingresosTotales += precio;

                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero
                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                         ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄\s
                                                        ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌
                                                        ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌         \s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌               ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌               ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░░░░░░░░░░░▌
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌               ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌         \s
                                                        ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌      ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                        ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌     ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌
                                                         ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                                           \s
                                                                                                          ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                                                                         ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                          ▀▀▀▀▀█░█▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌
                                                                                                               ▐░▌    ▐░▌       ▐░▌          ▐░▌          ▐░▌
                                                                                                               ▐░▌    ▐░█▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌
                                                                                                               ▐░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                               ▐░▌    ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀\s
                                                                                                               ▐░▌    ▐░▌       ▐░▌▐░▌          ▐░▌         \s
                                                                                                          ▄▄▄▄▄█░▌    ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄\s
                                                                                                         ▐░░░░░░░▌    ▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                          ▀▀▀▀▀▀▀      ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                            \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: CONCIERTO DE JAZZ
                                                           Entrada General Butaca                                                                                  Eventos AL.ML
                                                           CODIGO UNICO: %d                                                                              Empresa distribuidora de entradas
                                                                                                                                                        -------------------------------------
                                                                                                                                                         Esta empresa no está encargada del evento
                                                
                                                           Precio (el descuento está aplicado si es usted es beneficiario): %3.2f + IVA del %d %% = %.2f
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoJazz.toString(), horaEventoJazz.toString(), codigoUnicoNum, precioButacasJazz, iva, ((float) (precioButacasJazz * iva / 100) + precioButacasJazz));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");

                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }
                                    break;
                                case "3":
                                    System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                                    System.out.println();
                                    do {
                                        System.out.print("    Introduzca cantidad de entradas en anfiteatro (en número): ");
                                        cantidadEntradas = Integer.parseInt(s.nextLine());

                                        if (cantidadEntradas < 0 || cantidadEntradas > anfiteatroJazz) {
                                            System.out.println("CANTIDAD DE ENTRADAS INTRODUCIDA INCORRECTA");
                                            System.out.println();
                                        }
                                    } while (cantidadEntradas < 0 || cantidadEntradas > anfiteatroJazz);
                                    //cantidadEntradas = contadorEntradasFactura;
                                    anfiteatroJazz -= cantidadEntradas; //Restamos al total de entradas de platea Otoño las que se van a vender
                                    do {
                                        System.out.print("Introduzca fecha de compra (yyyy-MM-dd): ");
                                        fechaIntro = s.nextLine();
                                        if (fechaIntro.equalsIgnoreCase("no")) {
                                            fechaCompra = fechaActual;

                                        } else {
                                            fechaCompra = LocalDate.parse(fechaIntro);
                                        }

                                        diasDiferenciaFechas = (int) fechaCompra.until(fechaEventoJazz, ChronoUnit.DAYS);

                                        if (diasDiferenciaFechas >= 7) {
                                            System.out.println("ESTÁ DE SUERTE SE LE APLICARÁ UN DESCUENTO DEL " + descuentoJazz + "%");
                                            precio = precioAnfiteatroJazz - (precioAnfiteatroJazz * descuentoJazz / 100);
                                        }
                                        if (diasDiferenciaFechas < 0)
                                            System.out.println("NO PUEDES COMPRAR DESPUÉS DEL EVENTO");
                                        if (diasDiferenciaFechas < 7 && diasDiferenciaFechas > 0) {
                                            System.out.println("NO SE LE APLICARÁ NINGÚN DESCUENTO");
                                            precio = precioAnfiteatroJazz;
                                        }
                                    } while (diasDiferenciaFechas < 0);


                                    System.out.print("CARGANDO ");
                                    for (int j = 0; j < 3; j++) {
                                        System.out.print(".");
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (j == 2) System.out.println();
                                    }
                                        /*Aquí generamos el código unico, unimos tanto la fecha de compra como la fecha del evento
                                        luego lo pasamos por un bucle que se encarga de borrar los guiones*/
                                    horaActualTexto = String.valueOf(LocalTime.now()); //Pillamos la hora actual con horas, minutos y segundos, y lo pasamos a un String
                                    auxString = fechaCompra.toString().concat(fechaEventoJazz.toString()); //Aqui concatenamos la fecha del evento y la de compra
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < auxString.length(); j++) { //Aqui hacemos un bucle para concatenar solo los numeros y no los guiones
                                        caracter = auxString.charAt(j);
                                        if (caracter != '-') {
                                            codigoUnico += caracter;
                                        }
                                    }
                                    codigoUnicoNum = Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                    codigoUnicoNum /= 5; //Aqui hacemos una division para disminuir la longitud del numero
                                    codigoUnico = ""; //Inicializamos la variable donde irá el codigo
                                    for (int j = 0; j < horaActualTexto.length(); j++) {
                                        caracter = horaActualTexto.charAt(j);
                                        if (caracter != ':' && caracter != '.') { //Aqui hacemos un bucle para concatenar solo los numeros y no los puntos
                                            codigoUnico += caracter;
                                        }
                                    }

                                    precio *= cantidadEntradas;
                                    precio = (precio * iva / 100) + precio;
                                    System.out.printf("""
                                            ╔────────────────────────────────────────────╗
                                                               RECIBO:
                                                 Número de entradas: %18d
                                            
                                                 Precio: %29.2f euros
                                            ╚───────────────────────────────────────────╝""", cantidadEntradas, precio);

                                    System.out.print("\nPulse para continuar...");
                                    s.nextLine();
                                    //El cliente indica la cantidad de dinero a introducir y le damos su cambio
                                    do {
                                        System.out.println("¿Cuánto dinero va a introducir?");
                                        dineroInsertado = Float.parseFloat(s.nextLine());
                                        if (precio > dineroInsertado) System.out.println("Dinero insuficiente");
                                    } while (dineroInsertado < precio);
                                    cambio = dineroInsertado - precio;

                                    System.out.print("Calculando su cambio");
                                    for (int j = 0; j < 3; j++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println(" ");

                                    System.out.printf("Su cambio es de %.2f y le daremos...\n", cambio);

                                    //Calculo los billetes de 500 euros
                                    while (cambio >= 500) {
                                        contBillete500++;
                                        billete500--;
                                        cambio -= 500;
                                    }
                                    //Calculo los billetes de 200 euros
                                    while (cambio >= 200) {
                                        contBillete200++;
                                        billete200--;
                                        cambio -= 200;
                                    }
                                    //Calculo los billetes de 100 euros
                                    while (cambio >= 100) {
                                        contBillete100++;
                                        billete100--;
                                        cambio -= 100;
                                    }
                                    //Calculo los billetes de 50 euros
                                    while (cambio >= 50) {
                                        contBillete50++;
                                        billete50--;
                                        cambio -= 50;
                                    }
                                    //Calculo los billetes de 20 euros
                                    while (cambio >= 20) {
                                        contBillete20++;
                                        billete20--;
                                        cambio -= 20;
                                    }
                                    //Calculo los billetes de 10 euros
                                    while (cambio >= 10) {
                                        contBillete10++;
                                        billete10--;
                                        cambio -= 10;
                                    }
                                    //Calculo los billetes de 5 euros
                                    while (cambio >= 5) {
                                        contBillete5++;
                                        billete5--;
                                        cambio -= 5;
                                    }
                                    //Calculo las monedas de 2 euros
                                    while (cambio >= 2) {
                                        moneda2e--;
                                        contMoneda2e++;
                                        cambio -= 2;
                                    }
                                    //Calculo las monedas de 1 euros
                                    while (cambio >= 1) {
                                        contMoneda1e++;
                                        moneda1e--;
                                        cambio -= 1;
                                    }
                                    //Calculo las monedas de 0,50 euros
                                    while (cambio >= 0.50) {
                                        contMoneda50cent++;
                                        moneda50cent--;
                                        cambio -= 0.50f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,20 euros
                                    while (cambio >= 0.20) {
                                        contMoneda20cent++;
                                        moneda20cent--;
                                        cambio -= 0.20f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,10 euros
                                    while (cambio >= 0.10) {
                                        contMoneda10cent++;
                                        moneda10cent--;
                                        cambio -= 0.10f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,05 euros
                                    while (cambio >= 0.05) {
                                        contMoneda5cent++;
                                        moneda5cent--;
                                        cambio -= 0.05f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,02 euros
                                    while (cambio >= 0.0147) {
                                        contMoneda2cent++;
                                        moneda2cent--;
                                        cambio -= 0.02f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }
                                    //Calculo las monedas de 0,01 euros
                                    while (cambio > 0) {
                                        contMoneda1cent++;
                                        moneda1cent--;
                                        cambio -= 0.01f;
                                        cambio = (float) Math.round(cambio * 100) / 100;
                                    }

                                    if (contBillete500 > 0) System.out.println("Billetes de 500€: " + contBillete500);
                                    if (contBillete200 > 0) System.out.println("Billetes de 200€: " + contBillete200);
                                    if (contBillete100 > 0) System.out.println("Billetes de 100€: " + contBillete100);
                                    if (contBillete50 > 0) System.out.println("Billetes de 50€: " + contBillete50);
                                    if (contBillete20 > 0) System.out.println("Billetes de 20€: " + contBillete20);
                                    if (contBillete10 > 0) System.out.println("Billetes de 10€: " + contBillete10);
                                    if (contBillete5 > 0) System.out.println("Billetes de 5€: " + contBillete5);
                                    if (contMoneda2e > 0) System.out.println("Monedas de 2€: " + contMoneda2e);
                                    if (contMoneda1e > 0) System.out.println("Monedas de 1€: " + contMoneda1e);
                                    if (contMoneda50cent > 0)
                                        System.out.println("Monedas de 50 céntimos: " + contMoneda50cent);
                                    if (contMoneda20cent > 0)
                                        System.out.println("Monedas de 20 céntimos: " + contMoneda20cent);
                                    if (contMoneda10cent > 0)
                                        System.out.println("Monedas de 10 céntimos: " + contMoneda10cent);
                                    if (contMoneda5cent > 0)
                                        System.out.println("Monedas de 5 céntimos: " + contMoneda5cent);
                                    if (contMoneda2cent > 0)
                                        System.out.println("Monedas de 2 céntimos: " + contMoneda2cent);
                                    if (contMoneda1cent > 0)
                                        System.out.println("Monedas de 1 céntimo: " + contMoneda1cent);
                                    System.out.print("Pulse para continuar...");
                                    s.nextLine();

                                    ingresosTotales += precio;

                                    for (int i = 1; i <= cantidadEntradas; i++) {
                                        codigoUnicoNum += Long.parseLong(codigoUnico); //Pasamos el String a una variable Long
                                        codigoUnicoNum /= 999999; //Aqui hacemos una division para disminuir la longitud del numero
                                        //Imprimimos la entrada
                                        System.out.println("ESTA ES TU ENTRADA " + i + " de " + cantidadEntradas);
                                        System.out.println("\nPRESENTA LA PAGINA ENTERA EN EL EVENTO");
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");
                                        System.out.printf("""
                                                ╔───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╗
                                                         ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄\s
                                                        ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌
                                                        ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌         \s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌ ▐░▌   ▐░▌▐░▌               ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌               ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░░░░░░░░░░░▌
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌   ▐░▌ ▐░▌▐░▌               ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀\s
                                                        ▐░▌          ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌               ▐░▌     ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌         \s
                                                        ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌      ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄\s
                                                        ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌     ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌
                                                         ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                                                                           \s
                                                                                                          ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\s
                                                                                                         ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                          ▀▀▀▀▀█░█▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌
                                                                                                               ▐░▌    ▐░▌       ▐░▌          ▐░▌          ▐░▌
                                                                                                               ▐░▌    ▐░█▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌
                                                                                                               ▐░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                               ▐░▌    ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀\s
                                                                                                               ▐░▌    ▐░▌       ▐░▌▐░▌          ▐░▌         \s
                                                                                                          ▄▄▄▄▄█░▌    ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄\s
                                                                                                         ▐░░░░░░░▌    ▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                                                                                                          ▀▀▀▀▀▀▀      ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                                                                            \s
                                                           FECHA DEL EVENTO: %s                 Hora: %s
                                                           LUGAR DEL EVENTO: Teatro Maestro Alvarez Alonso, Martos - Jaén
                                                           EVENTO: CONCIERTO DE JAZZ
                                                           Entrada General Anfiteatro                                                                                  Eventos AL.ML
                                                           CODIGO UNICO: %d                                                                              Empresa distribuidora de entradas
                                                                                                                                                        -------------------------------------
                                                                                                                                                         Esta empresa no está encargada del evento
                                                
                                                           Precio (el descuento está aplicado si es usted es beneficiario): %3.2f + IVA del %d %% = %.2f
                                                ╚──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╝
                                                """, fechaEventoJazz.toString(), horaEventoJazz.toString(), codigoUnicoNum, precioAnfiteatroJazz, iva, ((float) (precioAnfiteatroJazz * iva / 100) + precioAnfiteatroJazz));
                                        //System.out.println("⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘");

                                        System.out.print("Pulse ENTER para continuar: ");
                                        s.nextLine();
                                    }
                                    break;
                            }

                            break;
                        default:
                            System.out.print("HA ELEGIDO UNA OPCIÓN NO PRESENTE EN EL MENÚ ");
                            for (int i = 0; i < 3; i++) {
                                System.out.print(".");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (i == 2) System.out.println();
                            }
                            break;
                    }
                    break;
                case "b":
                    System.out.println("""
                             ██████╗ ██████╗ ███╗   ██╗███████╗██╗   ██╗██╗  ████████╗ █████╗ ██████╗     ███████╗███████╗████████╗ █████╗ ██████╗  ██████╗\s
                            ██╔════╝██╔═══██╗████╗  ██║██╔════╝██║   ██║██║  ╚══██╔══╝██╔══██╗██╔══██╗    ██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██╔═══██╗
                            ██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     ██║   ███████║██████╔╝    █████╗  ███████╗   ██║   ███████║██║  ██║██║   ██║
                            ██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██║   ██╔══██║██╔══██╗    ██╔══╝  ╚════██║   ██║   ██╔══██║██║  ██║██║   ██║
                            ╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗██║   ██║  ██║██║  ██║    ███████╗███████║   ██║   ██║  ██║██████╔╝╚██████╔╝
                             ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝    ╚══════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝  ╚═════╝\s
                                                                                                                                                           \s
                            ███████╗██╗   ██╗███████╗███╗   ██╗████████╗ ██████╗\s
                            ██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝██╔═══██╗
                            █████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║   ██║   ██║
                            ██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ██║   ██║
                            ███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║   ╚██████╔╝
                            ╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝\s
                                                                                \s                                                                                                                               
                            
                            """);
                    System.out.print("""
                            ╔═══════════════════════════════════╗
                               ¿Que evento desea consultar?
                               1.Las Criadas
                               2.II Concierto de otoño
                               3.Concierto de Jazz
                            ╚════════════════════════════════════╝
                            Introduzca un valor:\s""");
                    opConsultar = s.nextLine();
                    switch (opConsultar) {
                        case "1":
                            if ((int) fechaActual.until(fechaEventoCriadas, ChronoUnit.DAYS) >= 7) descuentoDias = true;
                            else descuentoDias = false;
                            System.out.printf("""
                                                     ENTRADAS LIBRES
                                    ╔═══════════════════════════════════════════════════════════╗
                                      Platea: %d            Precio platea: %.2f euros
                                      Butacas: %d           Precio butacas: %.2f euros
                                      Anfiteatro: %d        Precio anfiteatro: %.2f euros
                                    
                                      Fecha evento: %s      Dias hasta el evento: %s""", plateaCriadas, precioPlateaCriadas, butacasCriadas, precioButacasCriadas, anfiteatroCriadas, precioAnfiteatroCriadas, fechaEventoCriadas, (int) fechaActual.until(fechaEventoCriadas, ChronoUnit.DAYS));
                            System.out.println();
                            System.out.print(descuentoDias ? "\s\sDescuento 7 dias: Disponible" : "\s\sDescuento 7 dias: No disponible");
                            System.out.print("""
                                    
                                    \s
                                     ╚═══════════════════════════════════════════════════════════╝
                                     \s""");
                            System.out.print("Pulse para continuar...");
                            s.nextLine();
                            break;
                        case "2":
                            if ((int) fechaActual.until(fechaEventoOtono, ChronoUnit.DAYS) >= 7) descuentoDias = true;
                            else descuentoDias = false;
                            System.out.printf("""
                                                     ENTRADAS LIBRES
                                    ╔═══════════════════════════════════════════════════════════╗
                                      Platea: %d            Precio platea: %.2f euros
                                      Butacas: %d           Precio butacas: %.2f euros
                                      Anfiteatro: %d        Precio anfiteatro: %.2f euros
                                    
                                      Fecha evento: %s      Dias hasta el evento: %s""", plateaOtono, precioPlateaOtono, butacasOtono, precioButacasOtono, anfiteatroOtono, precioAnfiteatroOtono, fechaEventoOtono, (int) fechaActual.until(fechaEventoOtono, ChronoUnit.DAYS));
                            System.out.println();
                            System.out.print(descuentoDias ? "\s\sDescuento 7 dias: Disponible" : "\s\sDescuento 7 dias: No disponible");
                            System.out.print("""
                                    
                                    \s
                                     ╚═══════════════════════════════════════════════════════════╝
                                     \s""");
                            System.out.print("Pulse para continuar...");
                            s.nextLine();
                            break;
                        case "3":
                            if ((int) fechaActual.until(fechaEventoJazz, ChronoUnit.DAYS) >= 7) descuentoDias = true;
                            else descuentoDias = false;
                            System.out.printf("""
                                                     ENTRADAS LIBRES
                                    ╔═══════════════════════════════════════════════════════════╗
                                      Platea: %d            Precio platea: %.2f euros
                                      Butacas: %d           Precio butacas: %.2f euros
                                      Anfiteatro: %d        Precio anfiteatro: %.2f euros
                                    
                                      Fecha evento: %s      Dias hasta el evento: %s""", plateaJazz, precioPlateaJazz, butacasJazz, precioButacasJazz, anfiteatroJazz, precioAnfiteatroJazz, fechaEventoJazz, (int) fechaActual.until(fechaEventoJazz, ChronoUnit.DAYS));
                            System.out.println();
                            System.out.print(descuentoDias ? "\s\sDescuento 7 dias: Disponible" : "\s\sDescuento 7 dias: No disponible");
                            System.out.print("""
                                    
                                    \s
                                     ╚═══════════════════════════════════════════════════════════╝
                                     \s""");
                            System.out.print("Pulse para continuar...");
                            s.nextLine();
                            break;
                        default:
                            System.out.println("Opción incorrecta.");

                            break;
                    }
                    break;
                case "c":
                    System.out.print("ENTRANDO AL INICIO DE SESIÓN DE ADMIN ");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println();
                    System.out.println("   ▄▄▄▄███▄▄▄▄      ▄████████ ███▄▄▄▄   ███    █▄          ▄████████ ████████▄    ▄▄▄▄███▄▄▄▄    ▄█  ███▄▄▄▄   \n" + " ▄██▀▀▀███▀▀▀██▄   ███    ███ ███▀▀▀██▄ ███    ███        ███    ███ ███   ▀███ ▄██▀▀▀███▀▀▀██▄ ███  ███▀▀▀██▄ \n" + " ███   ███   ███   ███    █▀  ███   ███ ███    ███        ███    ███ ███    ███ ███   ███   ███ ███▌ ███   ███ \n" + " ███   ███   ███  ▄███▄▄▄     ███   ███ ███    ███        ███    ███ ███    ███ ███   ███   ███ ███▌ ███   ███ \n" + " ███   ███   ███ ▀▀███▀▀▀     ███   ███ ███    ███      ▀███████████ ███    ███ ███   ███   ███ ███▌ ███   ███ \n" + " ███   ███   ███   ███    █▄  ███   ███ ███    ███        ███    ███ ███    ███ ███   ███   ███ ███  ███   ███ \n" + " ███   ███   ███   ███    ███ ███   ███ ███    ███        ███    ███ ███   ▄███ ███   ███   ███ ███  ███   ███ \n" + "  ▀█   ███   █▀    ██████████  ▀█   █▀  ████████▀         ███    █▀  ████████▀   ▀█   ███   █▀  █▀    ▀█   █▀  \n" + "                                                                                                               ");
                    System.out.println();
                    System.out.print("Introduzca usuario de administrador:");
                    adminUserIntro = s.nextLine();
                    System.out.print("Introduzca contraseña de administrador:\s");
                    adminPassIntro = s.nextLine();

                    if (adminUserIntro.equals(adminUser) && adminPassIntro.equals(adminPass)) {
                        System.out.print("""
                                \s
                                 ╔═══════════════════════════════════════════════════╗
                                   1. Consultar los ingresos totales por evento
                                   2. Consultar las monedas restantes para el cambio
                                   3. Apagar el software
                                 ╚═══════════════════════════════════════════════════╝
                                 Seleccione una opción:\s""");
                        opMenuAdmin = s.nextLine();
                        switch (opMenuAdmin) {
                            case "1":
                                System.out.println("██╗███╗   ██╗ ██████╗ ██████╗ ███████╗███████╗ ██████╗ ███████╗    ████████╗ ██████╗ ████████╗ █████╗ ██╗     ███████╗███████╗\n" + "██║████╗  ██║██╔════╝ ██╔══██╗██╔════╝██╔════╝██╔═══██╗██╔════╝    ╚══██╔══╝██╔═══██╗╚══██╔══╝██╔══██╗██║     ██╔════╝██╔════╝\n" + "██║██╔██╗ ██║██║  ███╗██████╔╝█████╗  ███████╗██║   ██║███████╗       ██║   ██║   ██║   ██║   ███████║██║     █████╗  ███████╗\n" + "██║██║╚██╗██║██║   ██║██╔══██╗██╔══╝  ╚════██║██║   ██║╚════██║       ██║   ██║   ██║   ██║   ██╔══██║██║     ██╔══╝  ╚════██║\n" + "██║██║ ╚████║╚██████╔╝██║  ██║███████╗███████║╚██████╔╝███████║       ██║   ╚██████╔╝   ██║   ██║  ██║███████╗███████╗███████║\n" + "╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝ ╚═════╝ ╚══════╝       ╚═╝    ╚═════╝    ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝\n" + "                                                                                                                              ");
                                System.out.printf("""
                                        \n─────────────────────────────
                                         LOS INGRESOS TOTALES SON:
                                        ─────────────────────────────
                                        %23.2f euros\n""", ingresosTotales);

                                break;
                            case "2":
                                System.out.println(" ██████╗ █████╗ ███╗   ███╗██████╗ ██╗ ██████╗ \n" + "██╔════╝██╔══██╗████╗ ████║██╔══██╗██║██╔═══██╗\n" + "██║     ███████║██╔████╔██║██████╔╝██║██║   ██║\n" + "██║     ██╔══██║██║╚██╔╝██║██╔══██╗██║██║   ██║\n" + "╚██████╗██║  ██║██║ ╚═╝ ██║██████╔╝██║╚██████╔╝\n" + " ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═════╝ ╚═╝ ╚═════╝ \n" + "                                               ");
                                System.out.println();
                                System.out.printf("""
                                        ─────────────────────────────────────────
                                        LAS MONEDAS RESTANTES PARA EL CAMBIO SON:
                                        ─────────────────────────────────────────
                                        MONEDA DE 2 EUROS:      %d
                                        MONEDA DE 1 EURO:       %d
                                        MONEDAS DE 50 CÉNTIMOS: %d
                                        MONEDAS DE 20 CÉNTIMOS: %d
                                        MONEDAS DE 10 CÉNTIMOS: %d
                                        MONEDAS DE 5 CÉNTIMOS:  %d
                                        MONEDAS DE 2 CÉNTIMOS:  %d
                                        MONEDAS DE 1 CÉNTIMO:   %d
                                        
                                        ─────────────────────────────────────────
                                        LOS BILLETES RESTANTES PARA EL CAMBIO SON
                                        ─────────────────────────────────────────
                                        BILLETE DE 500 EUROS:     %d
                                        BILLETE DE 200 EUROS:     %d
                                        BILLETE DE 100 EUROS:     %d
                                        BILLETE DE 50 EUROS:      %d
                                        BILLETE DE 20 EUROS:      %d
                                        BILLETE DE 10 EUROS:      %d
                                        BILLETE DE 5 EUROS:       %d
                                        
                                        """, moneda2e, moneda1e, moneda50cent, moneda20cent, moneda10cent, moneda5cent, moneda2cent, moneda1cent, billete500, billete200, billete100, billete50, billete20, billete10, billete5);
                                break;
                            case "3":
                                System.out.println();
                                System.out.print("APAGANDO SOFTWARE");
                                for (int i = 0; i < 3; i++) {
                                    System.out.print(".");
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                                salirMenu = false;
                                break;
                            default:
                                System.out.print("HA ELEGIDO UNA OPCIÓN NO PRESENTE EN EL MENÚ ");
                                for (int i = 0; i < 3; i++) {
                                    System.out.print(".");
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    if (i == 2) System.out.println();
                                }
                                break;
                        }
                    } else break;
                    break;
                default:
                    System.out.print("HA ELEGIDO UNA OPCIÓN NO PRESENTE EN EL MENÚ ");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (i == 2) System.out.println();
                    }
                    break;

            }
        } while (salirMenu);


    }
}
