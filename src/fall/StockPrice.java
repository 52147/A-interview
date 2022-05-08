package fall;

import java.util.HashSet;
/**
 * 
 * 给一个int数组，里面是股票, 全是正数，stock表示第i个月的股票。还有一个int k。问连续k个月的股票和的最大值。这连续k个月里不能有重复的数字。sliding window。注意返回值是long int， 如果用了int有隐藏的test case会过不了。
 *
 */
// max average stock price
public class StockPrice {

	public int maximumPrice(int[] stockPrice) {

		int left = 0;
		int sum = 0;
		int res = 0;

	

		HashSet<Integer> map = new HashSet<>();

		for (int i = 0; i < stockPrice.length; i++) {

			if (i - left == 3) {
				res = Math.max(res, sum);

				sum = sum - stockPrice[left];

				map.remove(stockPrice[left]);

				left++;
			}

			if (i - left < 3 && !map.contains(stockPrice[i])) {
				sum = sum + stockPrice[i];

				map.add(stockPrice[i]);

				continue;
			}

			if (i - left < 3 && map.contains(stockPrice[i])) {
				while (map.contains(stockPrice[i])) {

					map.remove(stockPrice[left]);

					sum = sum - stockPrice[left];

					left++;

				}

				map.add(stockPrice[i]);
				sum += stockPrice[i];
				continue;

			}

		}

		if (map.size() < 3) {
			return -1;
		}

		res = Math.max(res, sum);

		return res;

	}

	public static void main(String[] args) {
		
		System.out.println("Hello World!");
		
		StockPrice b = new StockPrice();

		int[] a = new int[] { 7, 7, 6, 7, 7, 6 };

		System.out.println(b.maximumPrice(a));

	}

}
