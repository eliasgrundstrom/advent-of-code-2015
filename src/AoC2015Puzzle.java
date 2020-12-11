import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AoC2015Puzzle {

    public AoC2015Puzzle(String day)
    {
        File file = new File("res/day" + day + ".txt");
        if(!file.exists())
        {
            solve(new ArrayList<>());
            return;
        }

        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(file));
        } catch(FileNotFoundException e)
        {
            System.err.println("File not found!");
            solve(new ArrayList<>());
            return;
        }

        List<String> inputLines = new ArrayList<>();
        try
        {
            String line;
            while((line = reader.readLine()) != null)
                inputLines.add(line);

            reader.close();
        } catch(IOException e)
        {
            e.printStackTrace();
        }

        solve(inputLines);
    }

    abstract void solve(List<String> input);
}
