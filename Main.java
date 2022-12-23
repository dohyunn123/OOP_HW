import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Visitors> visitorsArrayList = VisitorParser.parse("C:/Users/Dohyun/Desktop/OOPHW/2021visitors.txt");
        //2개의 상속된 프린터
        HashMap<Seasons, SeasonsVisitor> converted = VisitorToSeasons.convert(visitorsArrayList);

        Printer[] printer = {new SeasonPrinter(), new SortedPrinter()};
        //각 상속된 프린터에 따라 프린트 함.
        for(int i=0;i< printer.length;i++){
            printer[i].print(converted);
        }
    }
}