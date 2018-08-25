package hello;

public class Key {

    public Key(String name, long first, float second){
        this.name = name;
        this.first = first;
        this.second = second;
    }

    public String getName() {
        return name;
    }

    public long getFirst() {
        return first;
    }

    public float getSecond(){
        return second;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirst() {
        this.first = first;
    }

    public void setSecond(){
        this.second = second;
    }

    public String toString(){
        return name + Long.toString(first) + Float.toString(second);
    }

    //PRIVATE
    private String name;
    private long first;
    private float second;
}
