/**
 * Problem: Count Primes (#204)
 * Date: 08-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Sieve of Eratosthenes
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n log log n)
 * Space Complexity: O(n)
 * ------------------------------------------------------------
 */

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        int[] prime = new int[n + 1];

        // Initially assume every number is prime
        Arrays.fill(prime, 1);

        int cnt = 0;

        // Sieve of Eratosthenes
        for(int i = 2; i * i < n; i++) {
            if(prime[i] == 1) {

                // Mark all multiples of i as non-prime
                for(int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }

        // Count prime numbers strictly less than n
        for(int i = 2; i < n; i++) {
            if(prime[i] == 1) cnt++;
        }

        return cnt;
    }
}