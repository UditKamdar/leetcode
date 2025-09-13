class Solution {
    public int maxFreqSum(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> vowel1 = new HashMap<>();
        Map<Character, Integer> cons1 = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vowel1.put(c, vowel1.getOrDefault(c, 0) + 1);
            } else {
                cons1.put(c, cons1.getOrDefault(c, 0) + 1);
            }
        }

        int maxVowel = vowel1.isEmpty() ? 0 : Collections.max(vowel1.values());
        int maxCons  = cons1.isEmpty()  ? 0 : Collections.max(cons1.values());

        return maxVowel + maxCons;
    }
}