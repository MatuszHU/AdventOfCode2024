package day3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("src/day3/input.txt","r");
        StringBuilder data = new StringBuilder();
        String line;

        while ((line = raf.readLine()) != null) {
            data.append(line);
        }
        String regex = "mul\\(\\d{1,3},\\s*\\d{1,3}\\)";
        String doRegex = "do\\(\\)";
        String dontRegex = "don\\'t\\(\\)";
        Pattern pattern = Pattern.compile(regex+"|"+doRegex+"|"+dontRegex);
        Matcher matcher = pattern.matcher(data);
        int sum = 0;
        boolean matchFound = true;
        while (matcher.find()) {
            String match = matcher.group();
            if(match.equals("do()")){
                matchFound = true;
            } else if (match.equals("don't()")) {
                matchFound = false;
            }

            if (matchFound && match.startsWith("mul(")) {

                String[] tokens = match.substring(4, matcher.group().length() - 1).split(",\\s*");
                int a = Integer.parseInt(tokens[0]);
                int b = Integer.parseInt(tokens[1]);
                sum+=a*b;
            }
        }
        System.out.println( sum);
    }
}
