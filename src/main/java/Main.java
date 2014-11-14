import com.google.common.base.*;
import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static public void main(String[] args){
        List<Integer> inputList = new ArrayList<Integer>();
        inputList.add(1);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);
        inputList.add(7);

        //Java 8
        System.out.println(new Main().map(inputList, (x) -> x * 3)); // implemented by me with lambda
        System.out.println(new Main().map(inputList, (x) -> x % 2 == 0)); // implemented by me with lambda
        System.out.println(FluentIterable.from(inputList).transform((x) -> x * 3).toList()); //guava with lambda
        System.out.println(inputList.stream().map((x) -> x % 2 == 0).collect(Collectors.toList())); //streams


        //Java 7
        Function<Integer, Boolean> oddNumer = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer input) {
                return input % 2 == 0;
            }
        };
        Function<Integer, Integer> multiplyBy2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                return input *2;
            }
        };
        System.out.println(new Main().map(inputList, oddNumer)); // implemented by me without lambda
        System.out.println(new Main().map(inputList, multiplyBy2)); // implemented by me without lambda
        System.out.println(FluentIterable.from(inputList).transform(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                return input *8;
            }
        }).toList()); //guava

    }

    private <T, R> List<R> map(List<T> inputList, Function<T, R> function) {
        List<R> result = new ArrayList<R>();
        for (T element : inputList) {
            result.add(function.apply(element));
        }
        return result;
    }


}
