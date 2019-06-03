package animal;

public class Cat extends Animal {
     private BreedType breed;

    public BreedType getBreed() {
        return breed;
    }

    public void setBreed(BreedType breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Name="+getName()+","+
                "breed=" + breed +
                '}';
    }
}
