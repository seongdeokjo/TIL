package chap02.primeNumber.training;

public class PrimeNumber3 {
	// 1,000 이하의 소수를 열거(ver 3)
	public static void main(String[] args) {
		int counter = 0;
		int ptr = 0;
		int[] prime = new int[500];
		
		prime[ptr++] = 2;
		prime[ptr++] = 3;
		
		for(int n = 5; n <= 1000; n += 2) {
			boolean flag = false;
			for(int i = 1; prime[i] * prime[i] <= n; i++) {
				counter += 2;
				if(n % prime[i] == 0) { 	// 나누어떨어지면 소수가 아님
					flag = true;			
					break;
				}
			}
			if(!flag) {					// 마지막까지 나누어 떨어지지 않음
				prime[ptr++] = n;		// 소수라고 배열에 저장
				counter++;
			}
		}
		
		for(int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		
		System.out.println("곱셈과 나눗셈을 수행한 횟수 : "+counter);
		
	}
}
