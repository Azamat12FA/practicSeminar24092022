import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();
    }

    public static String getStringForTask1() {
        String res = input.next();
        if (res.endsWith(".")) {
            System.out.println("Введите корректное расширение!");
            res = getStringForTask1();
        }
        return res;
    }

    private static void task1() {
        System.out.print("Введите имя файла: ");
        String nameFiles = input.next();
        System.out.println();
        System.out.print("Введите новое расширение: ");
        String newExpansion = getStringForTask1();

        String newNameFiles;
        if (nameFiles.indexOf('.') == -1) {
            newNameFiles = nameFiles;
            if (newExpansion.startsWith(".")) {
                System.out.println(newNameFiles + "_" + newNameFiles.length() + newExpansion);
            } else {
                System.out.println(newNameFiles + "_" + newNameFiles.length() + '.' + newExpansion);
            }
        } else {
            newNameFiles = nameFiles.substring(0, nameFiles.indexOf('.'));
            if (newExpansion.startsWith(".")) {
                System.out.println(newNameFiles + "_" + newNameFiles.length() +
                        nameFiles.substring(nameFiles.indexOf('.'), nameFiles.lastIndexOf('.')) + newExpansion);
            } else {
                System.out.println(newNameFiles + "_" + newNameFiles.length() +
                        nameFiles.substring(nameFiles.indexOf('.'), nameFiles.lastIndexOf('.') + 1) + newExpansion);
            }
        }
    }

    private static void task2() {
        int[] numbers = new int[]{-46, 555, -622, 22, 59, 99, 75, 75, 100, 99, 46, 22, 38, 12, 10, 5};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 0 && numbers[i] < 100) {
                if (i == numbers.length - 1) {
                    System.out.print(numbers[i]);
                } else {
                    System.out.print(numbers[i] + ", ");
                }
            }
        }
        System.out.println();
        numbers = Arrays.stream(numbers).distinct().toArray();
        System.out.println(Arrays.toString(numbers));

        ArrayList<Integer> arrayList = new ArrayList<>();
        String x = "";
        while (true) {
            x = input.next();

            if (x.equals("end")) {
                break;
            } else {
                arrayList.add(Integer.parseInt(x));
            }
        }

        int indexMax1 = arrayList.indexOf(Collections.max(arrayList));
        int max2 = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            if (i != indexMax1) {
                if (arrayList.get(i) > max2) {
                    max2 = arrayList.get(i);
                }
            }
        }

        System.out.println(max2);

    }

}