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
        return "Name="+getName()+","+
                "breed=" + breed +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;

        Cat cat = (Cat) o;
if (getBreed()==cat.getBreed() && getName()== cat.getName())return true;return false;
//        return getBreed() == cat.getBreed();

    }

    @Override
    public int hashCode() {
        return getBreed().hashCode();
    }
}
