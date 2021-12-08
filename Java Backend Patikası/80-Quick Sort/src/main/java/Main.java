import java.util.Arrays;

public class Main {

    public static void main(String... args) {
        int[] data = { 5, 3, 2, 8, 9, 4, 0, 23, 12, 99, 1 };
        System.out.print("Sıralanmamış: [");
        Arrays.stream(data).forEach(element -> {
            if (element == data[data.length-1])
                System.out.println(element + "]");
            else
                System.out.print(element + ", ");
        });
        quickSort(data, 0, data.length-1);
        System.out.print("Sıralanmış: [");
        Arrays.stream(data).forEach(element -> {
            if (element == data[data.length-1])
                System.out.print(element + "]");
            else
                System.out.print(element + ", ");
        });
    }

    public static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    public static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
}
