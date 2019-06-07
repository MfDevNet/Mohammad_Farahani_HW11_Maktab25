package animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setBreed(BreedType.Aegean);

        List<Cat> listCat = new ArrayList<>();
        List<BreedType> arr = Arrays.asList(BreedType.values());

        for (int i = 0; i < 99; i++) {
            cat = new Cat();
            cat.setName("cat" + i);
            cat.setBreed(arr.get(i));
            listCat.add(cat);
        }

        List<Cat> list = new ArrayList<>();
        list = filterByName(listCat);
        System.out.println("---------------Filter By First Character----------------");
        printCat(list);

        list = filterByLastEven(list);
        System.out.println("---------------Filter By Last Character----------------");
        printCat(list);

        List<BreedType> listBreed=breedList(list);
        System.out.println("--------------Print and Map Breed Type------------------");
        printBreed(listBreed);


    }

    static void printCat(List<Cat> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    static void printBreed(List<BreedType> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static List<Cat> filterByName(List<Cat> catList) {
        Stream<Cat> listAPC = catList.stream().filter(e -> e.getBreed().name().startsWith("A") || e.getBreed()
                .name().startsWith("C") || e.getBreed()
                .name().startsWith("P"));

        List<Cat> listCollectCharAPC = listAPC.collect(Collectors.toList());
        return listCollectCharAPC;
    }

    public static List<Cat> filterByLastEven(List<Cat> catList) {
        Stream<Cat> l1 = catList.stream().filter(e -> e.getName().endsWith("2") || e.getName().endsWith("4")
                || e.getName().endsWith("6") || e.getName().endsWith("8") || e.getName().endsWith("0"));
        List<Cat> list = l1.collect(Collectors.toList());
        return list;
    }

    public static List<BreedType> breedList(List<Cat> list) {
        List<BreedType> typeList = list.stream().map(Cat::getBreed).collect(Collectors.toList());
        return typeList;

    }


}



