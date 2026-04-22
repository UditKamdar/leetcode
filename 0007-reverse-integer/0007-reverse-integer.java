class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if( x < 0){
            flag = true;
            x = -x;
        }

        int rev = 0;
        while (x > 0){
            int digit = x % 10;
            x/= 10;

            if( rev > (Integer.MAX_VALUE - digit)/10){
                return 0;
            }
            rev = rev*10 + digit;
        }

        return flag ?  -rev : rev;
    }
}