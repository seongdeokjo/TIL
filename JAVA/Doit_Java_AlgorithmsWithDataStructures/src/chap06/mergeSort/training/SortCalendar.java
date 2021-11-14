package chap06.mergeSort.training;

import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;

import java.util.Arrays;

public class SortCalendar {
	// 달력의 배열을 정렬

	public static void main(String[] args) {
		GregorianCalendar[] x = { new GregorianCalendar(2017, NOVEMBER, 1), new GregorianCalendar(1963, JUNE, 20),
				new GregorianCalendar(2005, APRIL, 2), };

		Arrays.sort(x);

		for (int i = 0; i < x.length; i++) {
			System.out.printf("%04d년 %02d월 %02d일\n", x[i].get(YEAR), x[i].get(MONTH) + 1, x[i].get(DATE));
		}
	}
}
