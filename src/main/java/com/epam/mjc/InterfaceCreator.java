package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                if (!Character.isUpperCase(s.toCharArray()[0]))
                    return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> result = new ArrayList<>();
            for (Integer i : x) {
                if (i % 2 == 0) {
                    result.add(i);
                }
            }
            x.addAll(result);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {

        return () -> {
            List<String> result = new ArrayList<>();
            for (String s : values) {
                if (Character.isUpperCase(s.toCharArray()[0]) && s.split(" ").length > 3 && String.valueOf((s.toCharArray()[s.toCharArray().length - 1])).equals(".")) {
                    result.add(s);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> m = new HashMap<>();
            for (String s : x) {
                m.put(s, s.length());
            }
            return m;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(list1);
            result.addAll(list2);
            return result;
        };
    }
}
