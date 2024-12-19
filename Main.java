import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int xmasCount = 0;
        ArrayList<String> fileData = getFileData("src/day4input.txt");
        String input = "";
        for (int i = 0; i < fileData.size(); i++) {
            input += fileData.get(i);
        }

        for (int i = 0; i < input.length() - 4; i++) {
            if (input.substring(i, i + 4).equals("XMAS") || input.substring(i, i + 4).equals("SAMX")) {
                xmasCount++;
            }
        }


        int i = 0;
        String[][] crossword = new String[fileData.size()][fileData.get(0).length()];
        for (int r = 0; r < crossword[0].length; r++) {
            for (int c = 0; c < crossword.length; c++) {
                crossword[r][c] = input.substring(i, i+1);
                i++;
            }
        }

        for (int r = 0; r < crossword[0].length; r++) {
            for (int c = 0; c < crossword.length; c++) {
                if (crossword[r][c].equals("X") && r > 4 && c > 4) {
                       if (crossword[r-1][c-1].equals("M") && crossword[r-2][c-2].equals("A") && crossword[r-3][c-3].equals("S")) {
                           xmasCount++;
                       }
                }

                if (crossword[r][c].equals("X") && r + 3 < crossword[0].length && c + 3 < crossword.length) {
                    if (crossword[r + 1][c + 1].equals("M") &&  crossword[r + 2][c + 2].equals("A") && crossword[r + 3][c + 3].equals("S")) {
                        xmasCount++;
                    }
                }
            }
        }

        System.out.println(xmasCount);

    }

//
//    public void checkDiagonal() {
//        for (int i = 0; i < 4; i++) {
//            if ()
//        }
//    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}