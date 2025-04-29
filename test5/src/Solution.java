import java.util.*;

class Solution {
    public static boolean[] visited;
    public static ArrayList<String> list = new ArrayList<>();

    public String solution(int[] numbers) {
        visited = new boolean[numbers.length];
        dfs(numbers, "", 0);

        // 모든 조합을 다 저장했으니까, 그냥 내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());

        if (list.get(0).charAt(0) == '0') return "0";

        return list.get(0);
    }

    public static void dfs(int[] numbers, String s, int depth) {
        if (depth == numbers.length) {
            list.add(s);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, s + numbers[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 30, 34, 5, 9}));
    }
}