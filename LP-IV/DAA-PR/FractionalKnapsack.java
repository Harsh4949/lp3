import java.util.*;

class Item {
	int weight, profit;
	double ratio;

	Item(int weight, int profit) {
		this.weight = weight;
		this.profit = profit;
		this.ratio = (double) profit / weight;
	}
}

public class FractionalKnapsack {
	// Time Complexity: O(n log n + n) = O(n log n)  // sorting dominates
	// Space Complexity: O(n)                          // items array storage
	public static void main(String[] args) {
		Item[] items = {
			new Item(5, 30),
			new Item(10, 40),
			new Item(15, 45),
			new Item(22, 77),
			new Item(25, 90)
		};

		int capacity = 60;

		Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

		double totalProfit = 0;

		for (Item item : items) {
			if (capacity == 0) {
				break;
			}

			if (item.weight <= capacity) {
				capacity -= item.weight;
				totalProfit += item.profit;
			} else {
				totalProfit += item.ratio * capacity;
				capacity = 0;
			}
		}

		System.out.printf("Maximum Profit: %.2f", totalProfit);
	}
}