public interface Car {
    default Integer door(){
        return 5;
    }
    String nazwa();
}
