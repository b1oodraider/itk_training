package itk.learn;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public void main(String[] args) {
        String[] arr = {"asdad", "asdasdasd", "123213", "bbbbbbb"};
        System.out.println(Arrays.toString(arrayMapping(arr, new TestClass())));
    }

    public <T> T[] arrayMapping(T[] arr, Function<T,T> func) {
        return Arrays.stream(arr).map(func).toArray(size->Arrays.copyOf(arr, size));
    }
}

class TestClass implements Function<String,String> {
    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }

}
