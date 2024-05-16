import java.util.*;

public class P4_PantojaF {

    static int TISMINIM = 100000;
    static int TISMAXIM = 999999;
    static int SIMPTOMAMINIM = 0;
    static int SIMPTOMAMAXIM = 3;
    static int EXPLORACIOMINIM = 0;
    static int EXPLORACIOMAXIM = 3;
    static int NIVELLPRIORITATMINIM = 0;
    static int NIVELLPRIORITATMAXIM = 5;
    static int TEMPACTUALMINIM = 27;
    static int TEMPACTUALMAXIM = 45;

    static int MAXIMINTENTS = 3; // Constant per a la validació d'intents màxim. Ampliació P2.
    static int PACIENTSMAXIM = 10; //Constants màxima de pacients a emmagatzemar. Ampliació P3.
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        // Array bidimensional per emmagatzemar les dades dels pacients
        int[][] pacients = new int[PACIENTSMAXIM][5]; // Cada fila conté les dades d'un pacient: TIS, simptoma, exploracio, nivell de prioritat, temperatura

        int comptemPacients = 0; // Comptador de pacients correctament introduïts
        boolean MesPacients = true; // Controla si es continua l'entrada de pacients

        // Bucle principal per introduir pacients
        while (MesPacients && comptemPacients < PACIENTSMAXIM) {
            boolean errorDada = true; // Indicador de dades vàlides
            int intents = 0; // Comptador d'intents

            int tisActual = 0, simptomaActual = 0, exploracioActual = 0, nivellPrioritatActual = 0, temperaturaActual = 0;

            // Entrada de la TIS amb fins a 3 intents
            errorDada = false;
            intents = 0;
            while (intents < MAXIMINTENTS && !errorDada) {
                System.out.print("\nIntrodueixi el número de la Targeta Individual Sanitària (TIS): ");
                tisActual = entrada.nextInt();

                if(tisActual >= TISMINIM && tisActual <= TISMAXIM) {
                    errorDada = true; // Dades correctes
                } else {
                    intents++;
                    System.out.println("Error de dades: La TIS ha de ser entre 100000 i 999999.");
                }
            }

            if (intents >= MAXIMINTENTS) {
                System.out.println("Pacient descartat. Reiniciant...");
                errorDada = false; // S'han esgotat els intents
            }

            if (!errorDada) {
                System.out.print("\nVol introduir un altre pacient? (1 per sí, 0 per no): ");
                int resposta = entrada.nextInt();

                MesPacients = (resposta == 1); // El bucle continuarà si es respon amb 1
                continue; // Passa a la següent iteració del bucle principal
            }

            // Entrada del símptoma amb fins a 3 intents
            errorDada = false;
            intents = 0;
            while (intents < MAXIMINTENTS && !errorDada) {
                System.out.println("Tria el símptoma:");
                System.out.println("0 - Dolor");
                System.out.println("1 - Lesió traumàtica");
                System.out.println("2 - Febre alta");
                System.out.println("3 - Confusió o canvis en l'estat mental");
                System.out.print("Opció: ");
                simptomaActual = entrada.nextInt();

                if(simptomaActual >= SIMPTOMAMINIM && simptomaActual <= SIMPTOMAMAXIM){
                    errorDada = true;
                } else {
                    intents++;
                    System.out.println("Error de dades: El símptoma ha de ser entre 0 i 3.");
                }
            }

            if (intents >= MAXIMINTENTS) {
                System.out.println("Intents exharuits.");
                errorDada = false; // S'han esgotat els intents
            }

            if (!errorDada) {
                System.out.println("Pacient descartat. Reiniciant el procés...");
                continue; // Torna a començar el bucle
            }

            // Exploració inicial amb fins a 3 intents
            errorDada = false;
            intents = 0;
            while (intents < MAXIMINTENTS && !errorDada) {
                switch (simptomaActual) {
                    case 0:
                        System.out.println("Exploració per dolor:");
                        System.out.println("0 - Dolor toràcic");
                        System.out.println("1 - Dolor abdominal");
                        System.out.println("2 - Dolor de cap");
                        System.out.println("3 - Migranya");
                        break;
                    case 1:
                        System.out.println("Exploració per lesió traumàtica:");
                        System.out.println("0 - Fractura òssia");
                        System.out.println("1 - Ferida de bala");
                        System.out.println("2 - Cremada");
                        System.out.println("3 - Lesió cerebral traumàtica");
                        break;
                    case 2:
                        System.out.println("Exploració per febre alta:");
                        System.out.println("0 - Pneumònia");
                        System.out.println("1 - Meningitis");
                        System.out.println("2 - Infecció viral");
                        System.out.println("3 - Reacció al·lèrgica");
                        break;
                    case 3:
                        System.out.println("Exploració per confusió:");
                        System.out.println("0 - Intoxicació per drogues o alcohol");
                        System.out.println("1 - Deshidratació severa");
                        System.out.println("2 - Accident cerebrovascular");
                        System.out.println("3 - Hipoglucèmia severa");
                        break;
                }

                System.out.print("Opció: ");
                exploracioActual = entrada.nextInt();

                if(exploracioActual >= EXPLORACIOMINIM && exploracioActual <= EXPLORACIOMAXIM){
                    errorDada = true;
                } else {
                    intents++;
                    System.out.println("Error de dades: L'exploració ha de ser entre 0 i 3.");
                }
            }

            if (intents >= MAXIMINTENTS) {
                System.out.println("Intents exhaurtis.");
                errorDada = false; // S'han esgotat els intents
            }

            if (!errorDada) {
                System.out.println("Pacient descartat. Reiniciant el procés...");
                continue; // Torna a començar el bucle
            }

            // Entrada del nivell de prioritat amb fins a 3 intents
            errorDada = false;
            intents = 0;
            while (intents < MAXIMINTENTS && !errorDada) {
                System.out.print("Introdueixi el nivell de prioritat: ");
                nivellPrioritatActual = entrada.nextInt();

                if (nivellPrioritatActual >= NIVELLPRIORITATMINIM && nivellPrioritatActual <= NIVELLPRIORITATMAXIM) {
                    errorDada = true;
                } else {
                    intents++;
                    System.out.println("Error de dades: El nivell de prioritat ha de ser entre 0 i 5.");
                }
            }

            if (intents >= MAXIMINTENTS) {
                System.out.println("Intents exhaurtis.");
                errorDada = false; // S'han esgotat els intents
            }

            if (!errorDada) {
                System.out.println("Pacient descartat. Reiniciant el procés...");
                continue; // Torna a començar el bucle
            }

            // Entrada de la temperatura actual amb fins a 3 intents
            errorDada = false;
            intents = 0;
            while (intents < MAXIMINTENTS && !errorDada) {
                System.out.print("Introdueixi la temperatura actual: ");
                temperaturaActual = entrada.nextInt();

                if (temperaturaActual >= TEMPACTUALMINIM && temperaturaActual <= TEMPACTUALMAXIM) {
                    errorDada = true;
                } else {
                    intents++;
                    System.out.println("Error de dades: La temperatura ha de ser entre 27 i 45 graus.");
                }
            }

            if (intents >= MAXIMINTENTS) {
                System.out.println("Intents exhaurtis.");
                errorDada = false; // S'han esgotat els intents
            }

            if (!errorDada) {
                System.out.println("Pacient descartat. Reiniciant el procés...");
                continue; // Torna a començar el bucle
            }

            // Afegir el pacient a l'array si totes les dades són correctes
            if (errorDada) {
                pacients[comptemPacients][0] = tisActual;
                pacients[comptemPacients][1] = simptomaActual;
                pacients[comptemPacients][2] = exploracioActual;
                pacients[comptemPacients][3] = nivellPrioritatActual;
                pacients[comptemPacients][4] = temperaturaActual;

                comptemPacients++; // Incrementem el comptador
            }

            // Pregunta si es vol introduir un altre pacient
            System.out.print("\nVol introduir un altre pacient? (1 per sí, 0 per no): ");
            int resposta = entrada.nextInt();
            
            
            if (resposta == 0) {
                MesPacients = false; // Finalitza el bucle si no es volen més pacients
            
            }
        }

        // Mostra un llistat de tots els pacients introduïts
        System.out.println("\nLlistat de pacients introduïts:");
        for (int i = 0; i < comptemPacients; i++) {
            System.out.println("TIS: " + pacients[i][0] + ", Simptoma: " + pacients[i][1] + ", Exploració: " + pacients[i][2] + ", Nivell de prioritat: " + pacients[i][3] + ", Temperatura: " + pacients[i][4]);
        }

        // Demana si es vol consultar per tipus de símptoma
        System.out.print("\nVol consultar per tipus de símptoma? (1 per sí, 0 per no): ");
        int consultarSimptoma = entrada.nextInt();

        if (consultarSimptoma == 1) {
            System.out.print("Quin tipus de símptoma? ");
            int tipusSimptoma = entrada.nextInt();

            // Ordena per nivell de prioritat (ordenació de la bombolla)
            for (int i = 0; i < comptemPacients - 1; i++) {
                for (int j = i + 1; j < comptemPacients; j++) {
                    if (pacients[i][3] < pacients[j][3]) {
                        // Intercanviem les dades
                        for (int k = 0; k < 5; k++) {
                            int temp = pacients[i][k];
                            pacients[i][k] = pacients[j][k];
                            pacients[j][k] = temp;
                        }
                    }
                }
            }

            // Mostra els pacients amb el tipus de símptoma especificat
            System.out.println("\nPacients amb símptoma " + tipusSimptoma + ":");
            for (int i = 0; i < comptemPacients; i++) {
                if (pacients[i][1] == tipusSimptoma) {
                    System.out.println("TIS: " + pacients[i][0] + ", Simptoma: " + tipusSimptoma + ", Exploració: " + pacients[i][2] + ", Nivell de prioritat: " + pacients[i][3] + ", Temperatura: " + pacients[i][4]);
                }
            }
        }

        // Demana si es vol veure un resum estadístic
        System.out.print("\nVols veure un resum estadístic? (1 per sí, 0 per no): ");
        int resum = entrada.nextInt();

        if (resum == 1) {
            System.out.println("\nResum estadístic:");
            System.out.println("Número de pacients introduïts: " + comptemPacients);

            // Comptar pacients per símptoma
            int[] comptaSimptoma = new int[SIMPTOMAMAXIM + 1];
            for (int i = 0; i < comptemPacients; i++) {
                comptaSimptoma[pacients[i][1]]++;
            }

            // Mostra el recompte per símptoma
            System.out.println("Número de pacients per símptoma:");
            for (int i = 0; i < comptaSimptoma.length; i++) {
                System.out.println("Simptoma " + i + ": " + comptaSimptoma[i]);
            }

            // Comptar pacients per nivell de prioritat
            int[] comptaPrioritat = new int[NIVELLPRIORITATMAXIM + 1];
            for (int i = 0; i < comptemPacients; i++) {
                comptaPrioritat[pacients[i][3]]++;
            }

            // Mostra el recompte per nivell de prioritat
            System.out.println("Número de pacients per nivell de prioritat:");
            for (int i = 0; i < comptaPrioritat.length; i++) {
                System.out.println("Prioritat " + i + ": " + comptaPrioritat[i]);
            }
        }

        // Tanquem l'entrada per consola
        entrada.close();
    }
    
}
