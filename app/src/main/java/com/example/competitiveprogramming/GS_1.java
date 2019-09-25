package com.example.competitiveprogramming;

import java.util.ArrayList;
import java.util.List;

public class GS_1 {
}class Result {

	/*
	 * Complete the 'minimizeMeetingCost' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER N
	 *  2. INTEGER M
	 *  3. 2D_INTEGER_ARRAY costs
	 */

	public static int minimizeMeetingCost(int N, int M, List<List<Integer>> costs) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(costs.get(i).get(j)<min)
					min=costs.get(i).get(i);
			}
		}
		return min;
	}

}
