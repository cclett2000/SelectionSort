import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> numberList = numberData();
        SelectionSort(numberList);
        System.out.println("Sorted Array: " + numberList);
    }

    private static void SelectionSort(ArrayList<Integer> number_list){
        // init vars
        int smallestIndex;
        int temp;
        int numberSize = number_list.size();

        // increment through the array
        for(int i = 0; i < numberSize; i++){
            // index of the smallest value
            smallestIndex = i;
            System.out.println(i + "). List Position Incremented, 'smallestIndex' updated -- New Value: " + smallestIndex);

            // compare value to value at 'i' position
            for (int j = i + 1; j < numberSize; j++){
                // set smallest index if value is less than 'i' position
                if(number_list.get(j) < number_list.get(smallestIndex)){
                    smallestIndex = j;
                    System.out.println(i + "). 'smallestIndex' updated -- New Value: " + smallestIndex + " -- Values: " + number_list.get(j) + ", " + number_list.get(smallestIndex));
                }
            }

            // set temp to value at 'i' position
            temp = number_list.get(i);

            // swap lowest value with value at 'i' position
            Collections.swap(number_list, i, smallestIndex);
            System.out.println(i + "). temp=" + temp + ", number_list@i=" + number_list.get(i) + ", number_list@smallestIndex=" + number_list.get(smallestIndex));
            System.out.println(i + "). Updated List: " + Arrays.toString(number_list.toArray()) + "\n");
        }
    }

    // read from file and generate ArrayList
    private static ArrayList<Integer> numberData() throws FileNotFoundException {
        ArrayList<Integer> temp = new ArrayList<>();
        File file = new File("sample_100.txt");
        Scanner fileReader = new Scanner(file);

        // convert and add values to arrayList
        while (fileReader.hasNextLine()){
            temp.add(Integer.parseInt(fileReader.nextLine()));
        }

        return temp;
    }
}
