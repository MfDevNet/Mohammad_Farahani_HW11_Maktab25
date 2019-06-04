import animal.BreedType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<BreedType> l= Arrays.asList(BreedType.values());
//        System.out.println(l);
        Stream<BreedType> ll=l.stream().filter(e ->e.name().endsWith("b")||e.name().endsWith("c"));
        l=ll.collect(Collectors.toList());
        System.out.println(l);
    }


}
