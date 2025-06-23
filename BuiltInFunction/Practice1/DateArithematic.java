import java.time.LocalDate;

public class DateArithematic {
    public static void main(String[] args) {
        LocalDate inputDate = LocalDate.of(2023, 6, 23); // You can change this to take user input

        LocalDate modifiedDate = inputDate
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);

        System.out.println("Original Date: " + inputDate);
        System.out.println("Modified Date: " + modifiedDate);
    }
}
