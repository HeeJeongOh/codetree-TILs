import java.util.*;
/*
- 수업 시작시간 전에 활동 기록 있을 것
- 수업 종료 후 
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int s = Integer.parseInt(sc.next().replace(":", ""));
        int e = Integer.parseInt(sc.next().replace(":", ""));
        int q = Integer.parseInt(sc.next().replace(":", ""));
        int n = sc.nextInt();

        // System.out.println(s + " " + e + " " + q);
        
        Map<Integer, ArrayList<String>> students = new TreeMap<>();
        for(int i = 0; i < n; i++){
            int time = Integer.parseInt(sc.next().replace(":", ""));
            String name = sc.next();
            
            ArrayList<String> tmp = new ArrayList<>();
            if(students.containsKey(time)){
                tmp = students.get(time);
                tmp.add(name);

                students.put(time, tmp);
            }
            else{
                tmp.add(name);
                students.put(time, tmp);
            }
        }

        int answer = 0;

        Set<String> first = new HashSet<>();
        Set<String> second = new HashSet<>();

        // 08:00 11:22 18:33
        for (int key : students.keySet()) {
            
            // 조건 1
            if(key <= s){
                first.addAll(students.get(key));
            }
            
            // 조건 2
            if(e <= key && key <= q){
                second.addAll(students.get(key));
            }

        }        

        // System.out.println(first);
        // System.out.println(second);
        first.retainAll(second);

        // System.out.println(first);
        System.out.println(first.size());
        
        
    }
}