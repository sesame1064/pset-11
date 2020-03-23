import java.util.ArrayList;

public class Exercises {

  public int findMe(int[] list, int target) {
    for(int i = 0; i < list.length; i++){
      if(list[i] == target){
        return i;
      }
    }
    return -1;
  }

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

  public ArrayList<Integer> insertion(ArrayList<Integer> list, boolean ascending) {
    return null;
  }

  public String[] insertion(String[] list, boolean ascending) {
    return null;
  }

  public int[] selection(int[] list, boolean ascending) {
    return null;
  }

  public ArrayList<String> selection(ArrayList<String> list, boolean ascending) {
    return null;
  }

  public ArrayList<Integer> merge(ArrayList<Integer> list, boolean ascending) {
    return null;
  }

  public String[] merge(String[] list, boolean ascending) {
    return null;
  }
}