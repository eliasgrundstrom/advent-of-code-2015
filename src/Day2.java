import java.util.List;

// --- Day 2: I Was Told There Would Be No Math ---
public class Day2 extends AoC2015Puzzle {

    public Day2()
    {
        super("2");
    }

    @Override
    void solve(List<String> input) {
        int totalPaperReq = 0;
        int totalRibbonReq = 0;
        for(String s: input) {
            String[] boxDimensions = s.split("x");
            int l = Integer.parseInt(boxDimensions[0]);
            int w = Integer.parseInt(boxDimensions[1]);
            int h = Integer.parseInt(boxDimensions[2]);

            int wrappingPaperReq = 2*l*w + 2*w*h + 2*h*l;
            int extraPaperReq = Math.min(Math.min(l*w, w*h), h*l);

            totalPaperReq += wrappingPaperReq + extraPaperReq;

            // --- Part 2 ---
            int wrappingRibbonReq = Math.min(Math.min(l+l+w+w, w+w+h+h), h+h+l+l);
            int bowRibbonReq = l*w*h;

            totalRibbonReq += wrappingRibbonReq + bowRibbonReq;
        }
        System.out.println(totalPaperReq + " square feet of paper is needed");
        System.out.println(totalRibbonReq + " square feet of ribbon is needed");
    }
}