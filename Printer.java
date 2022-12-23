import java.util.ArrayList;
import java.util.HashMap;

//2. 인터페이스 사용
public interface Printer {
    //4. 다형성(상속 /인터페이스)
    void print(HashMap<Seasons, SeasonsVisitor> converted);
}
