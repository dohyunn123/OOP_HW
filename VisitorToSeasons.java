import java.util.ArrayList;
import java.util.HashMap;

//방문자 리스트를 계절별 합산으로 바꿈.
public class VisitorToSeasons {
    public static HashMap<Seasons, SeasonsVisitor> convert(ArrayList<Visitors> visitorsArrayList){
        HashMap<Seasons, SeasonsVisitor> response = new HashMap<>();
        int[] count = new int[4];
        for(int i=0;i<count[i];i++){
            count[i] = 0;
        }
        //각 방문자의 계절별 합산.
        for(int i=0;i< visitorsArrayList.size();i++){
            Seasons current = visitorsArrayList.get(i).seasons;
            //이미 있으면 합산
            if(response.containsKey(current)){
                response.get(current).count += visitorsArrayList.get(i).count;
            }else{
                SeasonsVisitor visitor = new SeasonsVisitor();
                visitor.seasons = current;
                visitor.count = visitorsArrayList.get(i).count;
                //없으면 새로 넣음.
                response.put(current, visitor);
            }
        }
        return response;
    }
}
