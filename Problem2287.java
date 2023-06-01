class Solution {
    public int rearrangeCharacters(String s, String target) {

        if (target.length() > s.length()) {
            return 0;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int i = 0;
        while (i < s.length() || i < target.length()) {

            if (i < s.length()) {
                map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            }


            if (i < target.length()) {
                map2.put(target.charAt(i), map2.getOrDefault(target.charAt(i), 0) + 1);
            }
            i++;
        }

        int common = Integer.MAX_VALUE;
        for (Character c: target.toCharArray()) {
            if (map2.get(c) <= map1.getOrDefault(c, 0) ) {
                int diff = map1.getOrDefault(c, 0)  / map2.get(c);
                common = Math.min(common, diff);
            } else {
                return 0;
            }
        }
        
        return common;

    }
}
