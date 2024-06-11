package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Ahorcado {

        private static final int MAX_INTENTOS = 6;
        private static List<String> palabras = new ArrayList<>();

        public static void main(String[] args) {
            cargarPalabras();

            Scanner scanner = new Scanner(System.in);
            boolean jugar = true;

            while (jugar) {
                String palabraSecreta = seleccionarPalabraSecreta();
                StringBuilder palabraActual = new StringBuilder("_".repeat(palabraSecreta.length()));
                List<Character> letrasIntentadas = new ArrayList<>();
                int intentosRestantes = MAX_INTENTOS;

                System.out.println("Bienvenido al Juego del Ahorcado!");
                System.out.println("Intenta adivinar la palabra secreta.");
                System.out.println("Tienes " + intentosRestantes + " intentos.");

                while (intentosRestantes > 0) {
                    System.out.println("Palabra: " + palabraActual.toString());
                    System.out.print("Letras intentadas: ");
                    for (char letra : letrasIntentadas) {
                        System.out.print(letra + " ");
                    }
                    System.out.println("\nIngresa una letra: ");
                    char letra = scanner.next().charAt(0);
                    scanner.nextLine(); // Consumir el salto de línea

                    if (!letrasIntentadas.contains(letra)) {
                        letrasIntentadas.add(letra);
                        if (palabraSecreta.contains(String.valueOf(letra))) {
                            actualizarPalabraActual(palabraSecreta, palabraActual, letra);
                            if (palabraActual.toString().equals(palabraSecreta)) {
                                System.out.println("¡Felicidades! ¡Has adivinado la palabra secreta: " + palabraSecreta + "!");
                                break;
                            }
                        } else {
                            intentosRestantes--;
                            System.out.println("Letra incorrecta. Te quedan " + intentosRestantes + " intentos.");
                        }
                    } else {
                        System.out.println("Ya has intentado esa letra. Por favor, intenta con otra.");
                    }
                }

                if (intentosRestantes == 0) {
                    System.out.println("Lo siento, te has quedado sin intentos. La palabra secreta era: " + palabraSecreta);
                }

                System.out.println("¿Quieres jugar de nuevo? (s/n)");
                char respuesta = scanner.next().charAt(0);
                scanner.nextLine(); // Consumir el salto de línea

                if (respuesta != 's' && respuesta != 'S') {
                    jugar = false;
                }
            }

            System.out.println("Gracias por jugar. ¡Hasta luego!");
        }

        private static void cargarPalabras() {
            // Puedes cargar las palabras desde un archivo o definirlas aquí
            // Por simplicidad, las palabras están definidas en el código
            palabras.add("programacion");
            palabras.add("computadora");
            palabras.add("java");
            palabras.add("algoritmo");
            palabras.add("gato");
            palabras.add("perro");
            palabras.add("casa");
            palabras.add("coche");
            palabras.add("computadora");
            palabras.add("telefono");
            palabras.add("jardin");
            palabras.add("libro");
            palabras.add("laptop");
            palabras.add("juego");
            palabras.add("palabra");
            palabras.add("nube");
            palabras.add("ventana");
            palabras.add("raton");
            palabras.add("mesa");
            palabras.add("silla");
            palabras.add("cama");
            palabras.add("comida");
            palabras.add("musica");
            palabras.add("pelicula");
        }

        private static String seleccionarPalabraSecreta() {
            Random rand = new Random();
            return palabras.get(rand.nextInt(palabras.size()));
        }

        private static void actualizarPalabraActual(String palabraSecreta, StringBuilder palabraActual, char letra) {
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraActual.setCharAt(i, letra);
                }
            }
        }
    }


