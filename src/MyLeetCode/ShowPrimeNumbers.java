package MyLeetCode;

import java.util.ArrayList;

public class ShowPrimeNumbers {
    private Boolean isPrime(Double n, Double length) {
        ArrayList<Double> helper = new ArrayList<>();

        if (n <= 1) {
            return false;
        }
        for (Double i = 1.0; i <= length; i++) {
            if (n % i == 0.0) {
                helper.add(n);
            }

            if(helper.size() > 2.0) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Double> showPrimeNumbers(Double n) {
        ArrayList<Double> primeNumbers = new ArrayList<>();

        for (Double i = 0.0; i <= n; i++) {
            if(isPrime(i, n)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public static void main(String[] args) {
        ShowPrimeNumbers showPrimeNumbers = new ShowPrimeNumbers();

        System.out.println(showPrimeNumbers.showPrimeNumbers(100.0));
    }
}
