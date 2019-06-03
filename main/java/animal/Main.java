package animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat=new Cat();
//        cat.setName("ani");
        cat.setBreed(BreedType.Aegean);
//        System.out.println(cat);
        List<Animal> list=new ArrayList<Animal>();
        List<BreedType> arr = Arrays.asList(BreedType.values());

        for (int i=0;i<99;i++){
            cat=new Cat();
            cat.setName("cat"+i);
            cat.setBreed(arr.get(i));
            list.add(cat);
        }


        System.out.println(list);


    }
}
