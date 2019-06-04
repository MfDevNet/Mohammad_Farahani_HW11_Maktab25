package animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
//        cat.setName("ani");
        cat.setBreed(BreedType.Aegean);
//        System.out.println(cat);
        List<Cat> list = new ArrayList<>();
        List<BreedType> arr = Arrays.asList(BreedType.values());

        for (int i = 0; i < 99; i++) {
            cat = new Cat();
            cat.setName("cat" + i);
            cat.setBreed(arr.get(i));
            list.add(cat);
        }


        Stream<Cat> l = list.stream().filter(e -> e.getBreed().name().startsWith("A") || e.getBreed()
                .name().startsWith("P") || e.getBreed()
                .name().startsWith("C"));

        List<Cat> listCollectCharAPC = l.collect(Collectors.toList());
        System.out.println(listCollectCharAPC);




//        System.out.println(list);


    }
}
