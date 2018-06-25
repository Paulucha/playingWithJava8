import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {


        LocalDate valentines = LocalDate.of(2018, 02, 14);
        System.out.println(valentines);
        System.out.println(valentines.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        LocalDate valent = LocalDate.parse("2018-12-24");
        System.out.println(valent);

        LocalTime godzina = LocalTime.of(07, 15, 00);
        System.out.print("Godzina: " + godzina.getHour());
        System.out.print(" minuty: " + godzina.getMinute());
        System.out.println(" sekundy: " + godzina.getSecond());

        String s = "15:25:13";
        LocalTime godz = LocalTime.parse(s);
        System.out.println(godz);

        LocalDateTime czas = LocalDateTime.of(2007, 12, 03, 15, 30, 55);
        System.out.println("Aktualna data + godzina to: " + czas);
        System.out.println("Aktualna data " + czas.toLocalDate() + " Aktualna godzina " + czas.toLocalTime());

        LocalDateTime teraz = LocalDateTime.now();
        ZoneId zone3 = ZoneId.of("Asia/Kolkata");
        System.out.println(teraz.atZone(zone3));

        System.out.println(" do walentynek zostalo : " + Period.between(valentines, LocalDate.from(teraz)));

        Instant pocz = Instant.now();
        for (int i = 0; i < 1000; i++) {
            System.out.print(i);
        }
        Instant kon = Instant.now();
        System.out.println();
        System.out.println("Kod wykonywal sie: " + Duration.between(pocz, kon));
        System.out.println();

        LocalDateTime pozniej = teraz.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("Kolejny piąteczek będzie:  " + pozniej);
        

        System.out.println();
        System.out.println();
        List<Dish> listaDan = Arrays.asList(
                new Dish("zupa", true, 14556),
                new Dish("kotlet", false, 64556),
                new Dish("BigMac", false, 1156),
                new Dish("salatka", true, 6),
                new Dish("kasza", true, 456),
                new Dish("pierogi", false, 5));
        sortByCalory(listaDan).forEach(System.out::println);
        sortByName(listaDan).forEach(System.out::println);
        System.out.println(countCalories(listaDan));
        System.out.println(onlyVege(listaDan));
        mostCallory(listaDan).forEach(System.out::println);
        System.out.println("More than 500 : ");
        moreThan5(listaDan).forEach(System.out::println);
        System.out.println(noRepl());
    }

    public static List<Dish> sortByCalory(List<Dish> dishes) {

        return dishes.stream()
                .sorted((o1, o2) -> o1.getCalories() - o2.getCalories())
                .collect(Collectors.toList());
    }

    public static List<String> sortByName(List<Dish> dishes) {

        return dishes.stream()
                .map(Dish::getName)
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static Integer countCalories(List<Dish> dishes) {


        return dishes.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b);
    }


    public static List<Dish> onlyVege(List<Dish> dishes) {

        return dishes.stream().filter(s -> s.isVege() == true).collect(Collectors.toList());
    }

    public static List<Dish> mostCallory(List<Dish> dishes) {
        return dishes.stream()
                .sorted((o1, o2) -> o2.getCalories() - o1.getCalories())
                .limit(3)
                .collect(Collectors.toList());

    }

    public static List<Dish> moreThan5(List<Dish> dishes) {
        return dishes.stream()
                .filter(s -> s.getCalories() > 500)
                .collect(Collectors.toList());

    }

    public static long noRepl() {
        List<String> lisaa = new ArrayList<>();
        lisaa.add("hello");
        lisaa.add("academy");
        lisaa.add("java");
        lisaa.add("junior");

        long g = lisaa.stream()
                .flatMapToInt(s -> s.chars())
                .distinct()
                .mapToObj(i -> Character.valueOf((char) i))
                .peek(System.out::print)
                .count();

        return g;
    }


//
//        Car c1 = new threeDoors();
//        printCar(c1);
//
//        Car c2 = new fourDoor();
//        printCar(c2);
//
//
//    }
//    private static void printCar(Car car){
//        System.out.println("Car "+ car.nazwa()+" drzwi "+ car.door());
//        System.out.println("");
//    }
//    public static class threeDoors implements Car{
//
//
//        @Override
//        public String nazwa() {
//            return "Samochod";
//        }
//    }
//    public static class fourDoor implements Car{
//        @Override
//        public Integer door() {
//            return 4;
//        }
//
//        @Override
//        public String nazwa() {
//            return "auto";
//        }
//    }
//        List<Integer> list = Arrays.asList(3, 6, 6, 4, 8, 9, -54);
//getResult(list,
////        z -> Collections.max(o),
//        x-> System.out.println("max- " +x));
//
//        List<String> list4 = new ArrayList<>();
//        list4.add("dasd");
//        list4.add("");
//        list4.add("fsdfs");
//        list4.add("");
//        list4.add("fsd");
//        list4.add("");
//
//        printList(list4);
//
//        list4.forEach(System.out::println);
//
//        Predicate<String> p = s -> s.isEmpty();
//        list4.removeIf(p);
//
//        printList(list4);
//
////        Consumer<String> c = u -> System.out.println(u.toUpperCase());
////        list4.forEach(c);
//
//        list4.forEach(u -> System.out.println(u.toUpperCase()));
//
////        Function<String, Integer> f = w -> w.length();
//
//        list4.forEach(w -> System.out.println(w.length()));
//
//Function<List<String>, List<Integer>> f= strings -> {
//    List<Integer> reslts = new ArrayList<>();
//    strings.forEach(s -> reslts.add(s.length()));
//    return reslts;
//};
//
//        List<Integer> list = Arrays.asList(3, 6, 6, 4, 8, 9, -54);
//        System.out.println("min = ");
//        getResult(list,new MinOperation());
//        System.out.println("max = ");
//        getResult(list,new MaxOperation());
//
//
//        System.out.println("max z lambda = ");
//        getResult(list, (jakaslista) -> Collections.max(jakaslista));
//    }
//
//    public static void printList(List<String> list) {
//        for (String list4 : list) {
//            System.out.print("\'" + list4 + "\' ");
//        }
//        System.out.println();
//    }
//
//    public static void getResult(List<Integer> lista2, MathOperation oper, Consumer<Integer>) {
//
//
//        System.out.println(oper.calculate(lista2));
//    }

}
