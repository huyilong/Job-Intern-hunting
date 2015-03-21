/**
 * Problem: Find two lines containing the most water
 *
 * Solution: Use two pointers for left and right side of the container. 
 *           Note that volume of the container always depends on the shortest side.
 */

public class ContainerWithMostWater{
	public int maxArea(int[] height){
		if(height==null || height.length<2){
			return 0;
		}
		int left = 0;
		int right = height.length - 1;
		int area = 0;

		while(left < right){
			area = Math.max(area, (right-left)*Math.min(height[left], height[right]));

			//move the shorter side
			if(height[left] > height[right]){
				right --;
			}else{
				left ++;
			}
		}
		return area;
	}
}