package ua.com.alevel.classes;

public class MyNumber {

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MyNumber{" +
                "number=" + number +
                '}';
    }
}
