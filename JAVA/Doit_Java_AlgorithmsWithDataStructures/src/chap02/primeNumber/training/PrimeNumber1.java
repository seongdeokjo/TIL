package chap02.primeNumber.training;

public class PrimeNumber1 {
	// 1,000 이하의 소수를 열거(ver 1)
	public static void main(String[] args) {
		int counter = 0; // 나눗셈의 횟수
		
		for(int i = 2; i <= 1000; i++) {
			int n;
			for(n = 2; n < i; n++) {
				counter++;
				if(i % n == 0) // 나누어떨어지면 소수가 아님
					break; // 더 이상 반복문 불필요
			}
			if(i == n) {
				System.out.println(i);
			}
		}
		
		System.out.println("나눗셈을 수행한 횟수 : "+counter);
	}
	
	
}
