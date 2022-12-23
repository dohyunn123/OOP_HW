import java.util.ArrayList;
import java.util.HashMap;

//1. 클래스 상속 사용
public class SeasonPrinter implements Printer{
    @Override
    public void print(HashMap<Seasons, SeasonsVisitor> converted) {
        System.out.println("SPRING : " + converted.get(Seasons.Spring).count + "명");
        System.out.println("SUMMER : " + converted.get(Seasons.Summer).count + "명");
        System.out.println("FALL : " + converted.get(Seasons.Fall).count + "명");
        System.out.println("WINTER : " + converted.get(Seasons.Winter).count + "명");
    }
}
