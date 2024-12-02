package day2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Puzzle2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("src/day2/input.txt", "r");
        String line;
        ArrayList<Integer[]> data = new ArrayList<>();

        while ((line = raf.readLine())!= null){
            String[] tokens = line.split(" ");
            Integer[] arr = new Integer[tokens.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }
            data.add(arr);

        }
        int good = 0;
        for (Integer[] report : data) {
            if (isSafe(report) || canBeSafe(report)) {
                good++;
            }
        }
        System.out.println(good);
    }

    public static boolean isSafe(Integer[] arr){

        boolean isRising = arr[1] > arr[0];

        for (int i = 1; i < arr.length; i++) {
            int prevVal = arr[i - 1];
            int currVal = arr[i];
            int diff = currVal - prevVal;


            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }


            if (isRising && diff < 0) {
                return false;
            }
            if (!isRising && diff > 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean canBeSafe(Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            Integer[] checkArray = new Integer[arr.length - 1];
            for (int j = 0, k = 0; j < arr.length; j++) {
                if(j!=i)
                    checkArray[k++] = arr[j];
            }
            if(isSafe(checkArray)){
                return true;
            }
        }
        return false;
    }
}
