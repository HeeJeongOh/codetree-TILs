import java.util.*;
/*
수업태도가 두번째로 낮은 학생 구하기
ㄴ 가장 낮은 학생이 여럿일 경우, 그 다음 학생 이름 출력 
ㄴ 두번째로 낮은 학생이 여럿일 경우, tie 출력

1. 각 학생 별 총점 계산하기
    {Gertie=12, Elsie=7, Henrietta=9, Daisy=7, Bessie=7, Annabelle=10, Maggie=13}
2. 각 점수마다 학생 이름 넣기
    7 = [Elsie, Daisy, Bessie]
    9 = [Henrietta]
    10 = [Annabelle]
    12 = [Gertie]
    13 = [Maggie]
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
        Map<String, Integer> map = new HashMap<>();
        int max_score = 0;
        
        for(int i = 0; i < n; i++){
            String name = sc.next();
            int score = sc.nextInt();

            if(score > max_score) { max_score = score; }

            if(map.containsKey(name)){
                int tmp = map.get(name);
                map.put(name, tmp+score);
            }
            else{
                map.put(name, score);
            }
        }
        // System.out.println(map);

        Map<Integer, String> scoreMap = new TreeMap<>();
        for(String name : names){
            if(map.containsKey(name)){
                int score = map.get(name);
                if(scoreMap.containsKey(score)){
                    StringBuffer prep = new StringBuffer(scoreMap.get(score));
                    scoreMap.put(score, prep.append(" " + name).toString());
                }
                else{
                    scoreMap.put(score, name);
                }
            }
        }
        // System.out.println(scoreMap);
        
        String answer = "";
        int cnt = 0;
        for(int score : scoreMap.keySet()){
            if(cnt == 2) {break;}
            answer = scoreMap.get(score);
            cnt += 1;
        }
        String[] candidates = answer.split(" ");
        // System.out.println(Arrays.toString(candidates));

        if(candidates.length > 1){
            System.out.println("Tie");
        }else{
            System.out.println(candidates[0]);
        }
    }
}