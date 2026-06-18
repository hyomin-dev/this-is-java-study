package ch17.pratice;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class PraOptional {
    public static void main(String[] args) {
        //Optional<String> opt = Optional.of(null); //NullPointerException 발생
        OptionalInt optInt = OptionalInt.of(3);
        OptionalLong optLong = OptionalLong.of(3);
        OptionalDouble optDouble = OptionalDouble.of(3.3);



        Optional<String> opt2 = Optional.ofNullable(null);


        Optional<String> opt3 = Optional.empty();
        Optional<String> opt4 = Optional.ofNullable("효민");
        OptionalInt opt3Int = OptionalInt.empty();
        opt3Int.ifPresentOrElse(n-> System.out.println(n),
                ()->System.out.println("값이 없어요"));

        System.out.println(optInt.isPresent());
        opt3.ifPresent(System.out::println);

        System.out.println(opt3.orElse("있냐"));

        String name =opt3.or(()->Optional.ofNullable("누구")).orElse("신가");
        System.out.println(name);

        String name2 =opt4.or(()->Optional.ofNullable("누구")).orElse("신가");
        System.out.println(name2);

    }
}
