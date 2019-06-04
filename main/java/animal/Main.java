package animal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setBreed(BreedType.Aegean);

        List<Cat> list = new ArrayList<>();
        List<BreedType> arr = Arrays.asList(BreedType.values());

        for (int i = 0; i < 99; i++) {
            cat = new Cat();
            cat.setName("cat" + i);
            cat.setBreed(arr.get(i));
            list.add(cat);
        }


        Stream<Cat> l = list.stream().filter(e -> e.getBreed().name().startsWith("A") || e.getBreed()
                .name().startsWith("C") || e.getBreed()
                .name().startsWith("P"));

        List<Cat> listCollectCharAPC = l.collect(Collectors.toList());
        System.out.println("-------------------------------");
        System.out.println(listCollectCharAPC);

        Stream<Cat> l1 = listCollectCharAPC.stream().filter(e ->e.getName().endsWith("2")||e.getName().endsWith("4")
                ||e.getName().endsWith("6")||e.getName().endsWith("8")||e.getName().endsWith("0"));
        List<Cat> list1=l1.collect(Collectors.toList());
        System.out.println("-------------------------------");
        System.out.println(list1);

        List<BreedType> l2 = list1.stream().map(Cat::getBreed).collect(Collectors.toList());
        System.out.println("-------------------------------");

        for(BreedType b:l2){
            System.out.println(b);
        }
    }
}
