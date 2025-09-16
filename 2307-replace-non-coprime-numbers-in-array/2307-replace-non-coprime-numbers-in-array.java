class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            stack.add(num);
            while (stack.size() > 1) {
                int a = stack.get(stack.size() - 2);
                int b = stack.get(stack.size() - 1);
                int g = gcd(a, b);

                if (g > 1) {
                    stack.pop();
                    stack.pop();
                    long lcm = (long) a / g * b; // prevent overflow
                    stack.add((int) lcm);
                } else {
                    break;
                }
            }
        }

         return new ArrayList<>(stack);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}