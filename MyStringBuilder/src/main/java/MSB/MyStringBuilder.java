package MSB;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MyStringBuilder {
    private char[] value;
    private int count;
    private final Deque<MyStringBuilderSnapshot> history =  new ArrayDeque<>();

    public MyStringBuilder() {}

    public MyStringBuilder(String str) {
        this.value = str.toCharArray();
        this.count = str.length();
    }

    public MyStringBuilder append(String str) {

        makeSnapshot();

        if (str == null) {
            str = "null";
        }

        int len = str.length();
        ensureCapacity(len + count);
        str.getChars(0, len, value, count);
        count += len;

        return this;
    }

    public MyStringBuilder undo() {

        if(!history.isEmpty()) {
            MyStringBuilderSnapshot snapshot = history.pop();
            this.count = snapshot.count();
            this.value = snapshot.value();
        }

        return this;
    }

    private void ensureCapacity(int minLength) {
        if(minLength >= value.length) {
            int newLength = Math.min(value.length * 2, Integer.MAX_VALUE);
            value = Arrays.copyOf(value, newLength);
        }
    }

    public void makeSnapshot() {
        history.push(new MyStringBuilderSnapshot(value, count));
    }

//    public String build() {
//        return String.copyValueOf(value, 0, count);
//    }

    @Override
    public String toString() {
        return String.copyValueOf(value, 0, count);
    }
}

record MyStringBuilderSnapshot(char[] value, int count) {
    MyStringBuilderSnapshot(char[] value, int count) {
        this.value = value.clone();
        this.count = count;
    }
}
