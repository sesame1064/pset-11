import java.util.ArrayList;

public class Exercises {
//1
  public int findMe(int[] list, int target) {
    for(int i = 0; i < list.length; i++){
      if(list[i] == target){
        return i;
      }
    }
    return -1;
  }
//2
  public int findMe(ArrayList<String> list, String target) {
    if(target.equals(null)){
      return -1;
    }
    for(int i = 0; i < list.size(); i++){
      if(target.equals(list.get(i))){
        return i;
      }
    }
    return -1;
  }
//3
  public int findMeFaster(ArrayList<Integer> list, int target) {
    if(list.isEmpty()){
      return -1;
    }
    int start = 0;
    int end = list.size() - 1;
    int middle = 0;
    while(start <= end){
      middle = (start + end) / 2;
      if(list.get(middle) < target){
        start = middle + 1;
      }else if(list.get(middle) > target){
        end = middle - 1;
      }else{
        return middle;
      }
    }
    return -1;
  }
//4
  public int findMeFaster(String[] list, String target) {
    if(list.length == 0){
      return -1;
    }
    int start = 0; 
    int end = list.length - 1;
    int middle = 0;

    while(start <= end){
      middle = (start + end) / 2;

      if(list[middle].compareTo(target) < 0){
        start = middle + 1;
      }else if(list[middle].compareTo(target) > 0){
        end = middle - 1;
      }
    }    
    return -1;

  }
//5
  public int[] bubble(int[] list, boolean ascending) {

    for(int i = 0; i < list.length - 1; i++){
      for(int j = 0; j < list.length - 1; j++){
        if(ascending == true){
          if(list[j] > list[j + 1]) {
            int temp = list[j];
            list[j] = list[j + 1];
            list[j + 1] = temp;
          }
        }else{
          if(list[j] < list[j + 1]){
            int temp = list[j];
            list[j] = list[j + 1];
            list[j + 1] = temp;
          }
        }
      }
    }
    return list;
  }
//6
  public ArrayList<String> bubble(ArrayList<String> list, boolean ascending) {
    for(int i = 0; i < list.size() - 1; i++) {
      for(int j = 0; j < list.size() -1; j++){
        if(ascending == true){
          if(list.get(j).compareTo(list.get(j + 1)) > 0){
            String temp = list.get(j); 
            list.set(j, list.get(j + 1));
            list.set(j + 1, temp);
          }
        }else{
          if(list.get(j).compareTo(list.get(j + 1)) < 0){
            String temp = list.get(j);
            list.set(j, list.get(j +1 ));
            list.set(j + 1, temp);
          }
        }
      }
    }
    return list;
  }
//7

  public ArrayList<Integer> insertion(ArrayList<Integer> list, boolean ascending) {
    for(int i = 1; i < list.size(); i++){
      int j = i;
      if(ascending){
        while (j > 0 && list.get(j -1) > list.get(j)) {
          int temp = list.get(j);
          list.set(j, list.get(j - 1));
          list.set(j - 1, temp);
          j--;
        }
      }else{
        while(j > 0 && list.get(j -1) < list.get(j)) {
          int temp = list.get(j);
          list.set(j, list.get(j - 1));
          list.set(j - 1, temp);
          j--;
        }
      }
    }
    return list;
  }
//8
  public String[] insertion(String[] list, boolean ascending) {
    for(int i = 1; i < list.length; i++) {
      int j = i; 
      if(ascending == true){
        while(j > 0 && list[j - 1].compareTo(list[j]) > 0) {
          String temp = list[j];
          list[j] = list[j - 1];
          list[j - 1]  = temp;
          j--;
        }
      }else {
        while (j > 0 && list[j - 1].compareTo(list[j]) < 0) {
          String temp = list[j];
          list[j] = list[j - 1];
          list[j - 1] = temp;
        }
      }
    }
    return list;
  }

  public int[] selection(int[] list, boolean ascending) {
    if(ascending == true) {
      for (int i = 0; i < list.length - 1; i++){
        int j = i;
        for(int x = i + 1; x < list.length; x++){
          if(list[x] < list[j]){
            j = x;
          }
        }
        int smolNum = list[j];
        list[j] = list[i]; 
        list[i] = smolNum;
      }
    }else if (ascending == false){
      for (int i = 0; i < list.length - 1; i++){
        int j = i;
        for(int x = i + 1; x < list.length; x++){
          if(list[x] > list[j]){
            j = x;
          }
        }
        int smolNum = list[j];
        list[j] = list[i]; 
        list[i] = smolNum;
      }
    }
    return list;
  }

  public ArrayList<String> selection(ArrayList<String> list, boolean ascending) {
    for(int i = 0; i < list.size() - 1; i++){
      int outInd = i; 
      for(int j = i + 1; j < list.size(); j++){
        if(ascending == true){
          if(list.get(j).compareTo(list.get(outInd)) < 0) {
            outInd = j;
          }
        }else{
          if(list.get(j).compareTo(list.get(outInd)) > 0) {
            outInd = j;
          }
        }
      }
      String temp =list.get(i); 
      list.set(i, list.get(outInd));
      list.set(outInd, temp);
    }
    return list;
  }

  public ArrayList<Integer> merge(ArrayList<Integer> list, boolean ascending) {
    if (list == null || list.size() == 0) {
			return null;
		}

		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		int mid;

		if (list.size() == 1) {
			return list;
		} else {
			mid = list.size() / 2;
			for (int i = 0; i < mid; i++) {
				left.add(list.get(i));
			}

			for (int i = mid; i < list.size(); i++) {
				right.add(list.get(i));
			}

			left = merge(left, true);
			right = merge(right, true);
			int leftIndex = 0;
			int rightIndex = 0;
			int completeArrayIndex = 0;
			
			while (leftIndex < left.size() && rightIndex < right.size()) {
				
				if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
					list.set(completeArrayIndex, left.get(leftIndex));
					leftIndex++;
				} else {
					list.set(completeArrayIndex, right.get(rightIndex));
					rightIndex++;
				}
				completeArrayIndex++;
			}
			
			ArrayList<Integer> other;
			int otherIndex;
			
			if (leftIndex >= left.size()) {
				other = right;
				otherIndex = rightIndex;
			} else {
				other = left;
				otherIndex = leftIndex;
			}

			for (int i = otherIndex; i < other.size(); i++) {
				list.set(completeArrayIndex, other.get(i));
				completeArrayIndex++;
			}
		}

		return list;
  }

  public String[] merge(String[] list, boolean ascending) {
    if (list == null || list.length == 0) {
			return null;
		}

		if (list.length >= 2) {
			String[] left = new String[list.length / 2];
			String[] right = new String[list.length - list.length / 2];

			for (int i = 0; i < left.length; i++) {
				left[i] = list[i];
			}
			
			for (int i = 0; i < right.length; i++) {
				right[i] = list[i + list.length / 2];
			}

			merge(left, true);
			merge(right, true);
			int a = 0;
			int b = 0;
			
			for (int i = 0; i < list.length; i++) {
				if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
					list[i] = left[a];
					a++;
				} else {
					list[i] = right[b];
					b++;
				}
			}
			
		}

		return list;
	}
}