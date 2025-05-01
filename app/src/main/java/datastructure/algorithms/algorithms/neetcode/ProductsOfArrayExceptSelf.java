package datastructure.algorithms.algorithms.neetcode;

public class ProductsOfArrayExceptSelf {
    public static void main(String[] args) {
        for (int i : new ProductsOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 4, 6})) {
            System.out.print(i + ",");
        }
        System.out.println();
        for (int i : new ProductsOfArrayExceptSelf().productExceptSelf(new int[]{-1,0,1,2,3})) {
            System.out.print(i + ",");
        }

    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }
        return res;
    }

}
