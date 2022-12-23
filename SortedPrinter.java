import java.util.ArrayList;
import java.util.HashMap;

//1. 클래스 상속 사용
public class SortedPrinter implements Printer{
    @Override
    public void print(HashMap<Seasons, SeasonsVisitor> converted) {
        //맵에 있는거를 리스트로 변환
        ArrayList<SeasonsVisitor> arrayList = new ArrayList<>(converted.values());
        SeasonsVisitor[] list = new SeasonsVisitor[4];
        for(int i=0;i<arrayList.size();i++){
            list[i] = arrayList.get(i);
        }

        //정렬
        for(int i=0;i<arrayList.size();i++){
            int big = i;
            for(int j=i;j<arrayList.size();j++){
                if(list[big].count < list[j].count){
                    big = j;
                }
            }
            SeasonsVisitor temp = list[big];
            list[big] = list[i];
            list[i] = temp;
        }
        System.out.println("\n총 관광객 수 계절 순위:\n");
        for(int i=0;i<arrayList.size();i++){
            if(list[i].seasons == Seasons.Spring){
                System.out.println(i + 1 + "위 SPRING");
            }else if(list[i].seasons == Seasons.Summer){
                System.out.println(i + 1 + "위 SUMMER");
            }else if(list[i].seasons == Seasons.Fall){
                System.out.println(i + 1 + "위 FALL");
            }else{
                System.out.println(i + 1 + "위 WINTER");
            }
        }
    }
}
