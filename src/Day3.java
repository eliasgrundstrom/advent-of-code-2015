import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// --- Day 3: Perfectly Spherical Houses in a Vacuum ---
public class Day3 extends AoC2015Puzzle {

    public Day3() {
        super("3");
    }

    @Override
    void solve(List<String> input) {
        List<Point> houses = new ArrayList<>();

        int x = 0, y = 0;
        houses.add(new Point(x,y));

        char[] cArray = input.get(0).toCharArray();
        for(char c: cArray) {
            if(c == '^') {
                y++;
            } else if(c == '>') {
                x++;
            } else if (c == '<') {
                x--;
            } else if (c == 'v') {
                y--;
            } else {
                System.err.println("Bad input");
                return;
            }
            houses.add(new Point(x,y));
        }

        long uniqueHouses = houses.stream().distinct().count();
        System.out.println(uniqueHouses + " houses got at least one present");

        // --- Del 2 ---
        solve2(input);
    }

    void solve2(List<String> input) {
        List<Point> houses = new ArrayList<>();

        int xSanta = 0, ySanta = 0;
        int xRobot = 0, yRobot = 0;

        // Santa and robot santa both deliver to first house
        houses.add(new Point(xSanta,ySanta));
        houses.add(new Point(xRobot,yRobot));

        char[] cArray = input.get(0).toCharArray();

        // Santas path
        for(int i = 0; i<cArray.length; i=i+2) {
            if(cArray[i] == '^') {
                ySanta++;
            } else if(cArray[i] == '>') {
                xSanta++;
            } else if (cArray[i] == '<') {
                xSanta--;
            } else if (cArray[i] == 'v') {
                ySanta--;
            } else {
                System.err.println("Bad input");
                return;
            }
            houses.add(new Point(xSanta,ySanta));
        }

        // Robo-Santas path
        for(int i = 1; i<cArray.length; i=i+2) {
            if(cArray[i] == '^') {
                yRobot++;
            } else if(cArray[i] == '>') {
                xRobot++;
            } else if (cArray[i] == '<') {
                xRobot--;
            } else if (cArray[i] == 'v') {
                yRobot--;
            } else {
                System.err.println("Bad input");
                return;
            }
            houses.add(new Point(xRobot,yRobot));
        }

        long uniqueHouses = houses.stream().distinct().count();
        System.out.println("In part 2: " + uniqueHouses + " houses got at least one present");
    }
}