
import java.util.List;

// --- Day 1: Not Quite Lisp ---
public class Day1 extends AoC2015Puzzle {

    public Day1()
    {
        super("1");
    }

    @Override
    void solve(List<String> input) {
        int currentFloor = 0;
        int posInArray = 0;
        var checkOnce = false;
        char[] cArray = input.get(0).toCharArray();

        for(char c: cArray) {
            posInArray++;
            if(c == '(') {
                currentFloor++;
            } else if(c == ')') {
                currentFloor--;
            } else {
                System.err.println("bad input");
                return;
            }

            if(currentFloor == -1) {
                if(checkOnce) continue;
                System.out.println("Pos. of first char that makes currentFloor -1 is: " + posInArray);
                checkOnce = true;
            }
        }

        System.out.println("Final floor is: " + currentFloor);
    }
}
