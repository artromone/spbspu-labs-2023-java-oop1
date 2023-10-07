package Animals.Felidae;

public class Manul extends Felidae{
    private static int count;
    public void count(){
        count++;
    }
    public static int getCount() {
        return count;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow " + count);
    }
}
