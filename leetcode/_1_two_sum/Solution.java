package _1_two_sum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> vals = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            vals.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            Integer possibleIndex = vals.get(target - nums[i]);
            if (possibleIndex != null && i != possibleIndex) {
                return new int[] {i, possibleIndex};
            }
        }
        
        return null;
    }
}