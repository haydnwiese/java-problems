class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        
        Map<String, List<String>> ans = new HashMap<>();
        for (String value : strs) {
            char[] chars = value.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!ans.containsKey(key)) 
                ans.put(key, new ArrayList());
            ans.get(key).add(value);
        }
        return new ArrayList(ans.values());
    }
}