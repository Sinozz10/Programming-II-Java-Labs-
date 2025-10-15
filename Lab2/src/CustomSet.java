import java.util.*;

public class CustomSet {
    //Attributes definition
    private ArrayList<Integer> data;
    private int size;

    //Constructor
    public CustomSet(ArrayList<Integer> number) {
        data = new ArrayList<>();
        for(int i = 0; i < number.size(); i++) {
            int num = number.get(i);
            if( !data.contains(num)){
                data.add(num);
            }
        }
        this.size =data.size();
    }

    //Methods ->Contains & ->union
    public boolean contains(int num){
        return data.contains(num);
    }

    public CustomSet union(CustomSet s2){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(this.data);
        for(int i = 0; i < s2.getData().size(); i++) {
            int num = s2.getData().get(i);
            if(!temp.contains(num)) {
                temp.add(num);
            }
        }
        return new CustomSet(temp);
    }

    //Getters and Setters

    @Override //Automatic sorter
    public String toString() {
        Collections.sort(data);
        return data.toString();
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setData(ArrayList<Integer> data) {
        this.data = data;
    }
}