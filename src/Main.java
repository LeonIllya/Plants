import java.util.List;

public class Main {

    public static void main(String[] args){
            showData(getData());
    }

    private static List<Plant> getData() {
        ReadData readData = new ReadData();
        return readData.selectAll();
    }

    private static void showData(List<Plant> plants) {
        int count = 0;
        for (Plant plant : plants) {
            count++;
            System.out.printf("%d. %s%n%s%n%n", count, plant.name, plant.description);
        }
    }
}
