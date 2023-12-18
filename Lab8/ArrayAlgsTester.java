import java.util.Random;
import java.util.Scanner;

public class ArrayAlgsTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayAlgs a = new ArrayAlgs();
        int dim = 0;
        int max = 0;
        int min = 0;
        int[] arr;
        while (true) {
            try {
                System.out.println("Inserisci la dimensione dell'array");
                dim = Integer.parseInt(scanner.nextLine());
                if (dim <= 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("argomento inserito in modo errato");
            } catch (IllegalArgumentException e) {
                System.out.println("argomento inserito in modo errato");
            }
        }

        while (true) {
            try {
                System.out.println("Inserisci il numero massimo che si puo generare");
                max = Integer.parseInt(scanner.nextLine());
                if (max <= 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("argomento inserito in modo errato");
            } catch (IllegalArgumentException e) {
                System.out.println("argomento inserito in modo errato");
            }
        }

        while (true) {
            try {
                System.out.println("Inserisci il numero minimo che si puo generare");
                min = Integer.parseInt(scanner.nextLine());
                if (max < min || min < 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("argomento inserito in modo errato");
            } catch (IllegalArgumentException e) {
                System.out.println("argomento inserito in modo errato");
            }
        }
        arr = generateArray(dim, (max - min), min);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        while (true) {
            System.out.println(
                    "Inserisci una lettera tra le seguenti per ordinare l'array con l'algoritmo indicato:\nS per selection sort \n I per Insertion sort\nM per Merge Sort\nQ per uscire dall'ordinamento");
            String rep = scanner.nextLine();
                    if (rep.equalsIgnoreCase("S")) {
                ArrayAlgs.selectionSort(arr, dim);
            } else if (rep.equalsIgnoreCase("I")) {
                ArrayAlgs.insertionSort(arr, dim);
            } else if (rep.equalsIgnoreCase("M")) {
                ArrayAlgs.mergeSort(arr, min);
            } else if (rep.equalsIgnoreCase("Q")) {
                break;
            } else {
                System.out.println("Inserimento errato");
            }
        }
        while (true) {
            System.out.println(
                    "Inserisci una lettera tra le seguenti per ordinare l'array con l'algoritmo indicato:\nL per linear search\nB per binary search\nQ per uscire dalla ricerca");
            String rep = scanner.nextLine();
                    if (rep.equalsIgnoreCase("L")) {
                int find = checkInput(scanner);
                int pos = ArrayAlgs.linearSearch(arr, dim, find);
                stampResult(pos);
            } else if (rep.equalsIgnoreCase("B")) {
                int find = checkInput(scanner);
                int pos = ArrayAlgs.binarySearch(arr, dim, find);
                stampResult(pos);
            } else if (scanner.nextLine().equalsIgnoreCase("Q")) {
                break;
            } else {
                System.out.println("Inserimento errato");
            }
        }
        scanner.close();
    }

    public static int[] generateArray(int dim, int range, int min) {
        Random r = new Random();
        int[] res = new int[dim];
        for (int i = 0; i < res.length; i++) {
            res[i] = r.nextInt(range) + min +1;
        }
        return res;
    }

    public static int checkInput(Scanner scanner) {
        while (true) {
            System.out.println("Inserisci un numero");
            try {
                int min = Integer.parseInt(scanner.nextLine());
                return min;
            } catch (Exception e) {
                System.out.println("Inserimento errato");
            }
        }
    }

    public static void stampResult(int pos) {
        if (pos == -1) {
            System.out.println("Non si trova nell'array");
        } else {
            System.out.println("Trovato in posizione " + pos);
        }
    }
}
