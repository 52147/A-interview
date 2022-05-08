package fall;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class moveLocation {

	public int[] moveZeroes(int location[], int[] moveFrom, int[] moveTo) {
		// int index=0;
		// for(int i=0;i<nums.length;i++)
		// {
		// if(nums[i]!=0)
		// nums[index++]=nums[i];
		// }
		// for(int i=index;i<nums.length;i++)
		// nums[i]=0;

//        int index = 0;
//        
//        for(int i = 0; i < nums.length ; i++){
//            if(nums[i] != 0){
//                nums[index] = nums[i];
//                index++;
//            }
//        }
//        
//        for(int i =  index; i < nums.length ; i++){
//            nums[i] = 0;
//        }

		Set<Integer> s = new HashSet<>();
		
		int[] res = new int[location.length];

		for (int i = 0; i < location.length; i++) {

			s.add(location[i]);
		}

		for (int i = 0; i < moveFrom.length; i++) {

			if(s.contains(moveFrom[i])) {
				
				s.add(moveTo[i]);
				s.remove(moveFrom[i]);
			}
		}
		int index = 0;
		for(int se: s) {
			res[index++] = se;
		}
		// System.out.println(s);
		
		//Arrays.sort(res);
		
//		for(int r: res) {
//			System.out.println(r);
//		}
		
		return res;

	}
	
	
	public static void main(String[] args) {
		
		int location[] = {1, 7, 6, 8};
		
		int[] moveFrom = {1, 7, 2};
		
		int[] moveTo = {2, 9, 5};
		
		
		moveLocation m = new moveLocation();
		System.out.println(m.moveZeroes(location, moveFrom, moveTo)); // output: 5689
		
		
		
	}

}
