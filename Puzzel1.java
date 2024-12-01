import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
public class Puzzle1 {
	public static void main(String[] args) throws IOException {
            RandomAccessFile raf = new RandomAccessFile("input.txt", "r");
            String line;
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            while ((line = raf.readLine()) != null) {
                String[] tokens = line.split("   ");
                
                a.add(Integer.parseInt(tokens[0]));
                b.add(Integer.parseInt(tokens[1]));
            }
            Collections.sort(a);
            Collections.sort(b);
            int sum = 0;
            for (int i = 0; i < a.size(); i++) {
                if(a.get(i) > b.get(i)) {
                    sum += a.get(i)-b.get(i);
                } else if (a.get(i) < b.get(i)) {
                    sum += b.get(i)-a.get(i);
                }
                else{
                    sum+=0;
                }
            }
            System.out.println(+sum);
            Map<Integer, Integer> bFrequency = new HashMap<>();
            for (int num : b) {
                bFrequency.put(num, bFrequency.getOrDefault(num, 0) + 1);
            }

            
            int similarityScoreSum = 0;
            for (int num : a) {
                int occurrences = bFrequency.getOrDefault(num, 0); 
                similarityScoreSum += num * occurrences;
            }

            
            System.out.println(+ similarityScoreSum);
        }
    }
