import animal.BreedType;
import animal.Cat;
import animal.Main;
import junitx.framework.ListAssert;
import org.hibernate.mapping.Collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;

public class TestMethod {

    static Main instance = new Main();

    List<Cat> catList() {
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
        return listCat;
    }

    @Test
    void testBreedType() {
        List<Cat> cats = catList();

        ListAssert.assertContains(Main.breedList(cats), BreedType.Cyprus);
        ListAssert.assertContains(Main.breedList(cats), BreedType.Aegean);
        ListAssert.assertContains(Main.breedList(cats), BreedType.American_Curl);
        ListAssert.assertContains(Main.breedList(cats), BreedType.Wila_Krungthep);
    }

    @Test
    void testCatByName() {
        List<Cat> cats = catList();
        List<Cat> filterByname = Main.filterByName(cats);
//        System.out.println(filterByname);
        List<Cat> cc = new ArrayList<>();
        Cat cat = new Cat();
        cat.setName("cat0");
        cat.setBreed(BreedType.Abyssinian);
        cc.add(cat);
        cat = new Cat();
        cat.setName("cat23");
        cat.setBreed(BreedType.Chantilly_Tiffany);
        cc.add(cat);

            Assertions.assertEquals(filterByname,cc);



    }


}
