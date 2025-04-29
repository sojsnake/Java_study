import java.util.*;

class Solution2 {
    public String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 커스텀 정렬: (a+b) vs (b+a) 비교해서 더 큰 쪽이 먼저 오게
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // 0이 여러 개인 경우 ("000")를 방지
        if (nums[0].equals("0")) return "0";

        // 정렬된 배열 이어붙이기
        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{6, 10, 2}));
    }
}