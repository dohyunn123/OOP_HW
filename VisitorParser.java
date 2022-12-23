import java.io.*;
import java.util.ArrayList;

//7. 파일 입/출력 사용
public class VisitorParser {
    //입력 파일을 받아서 객체로 바꿔줌.
    public static ArrayList<Visitors> parse(String path){
        //6. 컬렉션 프레임워크 사용 - list나 map사용하여 입력 데이터 처리
        BufferedReader reader = null;
        ArrayList<Visitors> response = new ArrayList<>();
        try {
            reader = new BufferedReader(
                    new FileReader(path)
            );
            //3. 예외 처리 - 열 파일이 없으면 예외처리
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
            System.exit(0);
        }

        int month = 1;

        String str;
        while (true) {
            try {
                if (!((str = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //현재 한줄에서 방문자 객체를 생성함.
            Visitors current = new Visitors();
            try {
                current.count = Integer.parseInt(str);
            }catch (NumberFormatException e){
                //3. 예외 처리 - 숫자가 아님
                System.out.println("숫자가 아닙니다.");
                System.exit(0);
            }
            //월 생성 및 월에 따라 계절 생성
            current.month = month++;
            if(current.month < 4){
                current.seasons = Seasons.Spring;
            }else if(current.month < 7){
                current.seasons = Seasons.Summer;
            }else if(current.month<10){
                current.seasons = Seasons.Fall;
            }else{
                current.seasons = Seasons.Winter;
            }
            response.add(current);
        }

        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
