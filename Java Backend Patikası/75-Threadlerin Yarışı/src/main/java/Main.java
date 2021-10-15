import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {

    static List<Integer> odd = new ArrayList<>();
    static List<Integer> even = new ArrayList<>();
    static List<Integer> numbers = new ArrayList<>();


    public static void main(String args[]) {

        for (int i = 1; i <= 10000; i++)
            numbers.add(i);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Scheduler schedule = new Scheduler();

        for (int i = 0; i < numbers.size(); i++)
            executor.execute(schedule);

    }

}
