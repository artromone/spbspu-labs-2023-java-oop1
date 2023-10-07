package Animals.Felidae;

public class Lynx extends Felidae{
    public boolean canClawLiverOut(){
        return true;
    }

    @Override
    public void makeSound() {
        System.out.println("Hiss!");
    }
}
