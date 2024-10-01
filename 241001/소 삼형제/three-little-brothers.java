import java.util.*;
/*
어떤 조합이 가장 많이 나왔는가를 기록하기

1. Map<HashSet<>, Integer> 으로 저장
2. 
*/
public class Main {
    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<HashSet<String>, Integer> mapp = new HashMap<>();
        for(int i = 0; i < n; i++){
            HashSet<String> sett = new HashSet<>();
            for(int j = 0; j < 3; j++){
                sett.add(sc.next());
            }
            mapp.put(sett, mapp.getOrDefault(sett, 0)+1);

            if(mapp.get(sett) > answer){
                answer = mapp.get(sett);
            }
        }
        System.out.println(answer);
    }
}