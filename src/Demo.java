import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final List<LocalDate> dates = new ArrayList<>() {{
        add(LocalDate.parse("2032-05-03", dtf));
        add(LocalDate.parse("2005-01-02", dtf));
        add(LocalDate.parse("2007-01-01", dtf));
        add(LocalDate.parse("2004-07-01", dtf));
    }};

    public static void main(String[] args) {
        System.out.println("""
                EXPECTED RESULT:
                2005-01-02
                2007-01-01
                2032-05-03
                2004-07-01
                """);


        // Option 1 - with two lists
        List<LocalDate> testDates1 = new ArrayList<>(dates);

        DateSorter dateSorter = new DateSorter();
        testDates1 = (List<LocalDate>) dateSorter.sortDates(testDates1);

        System.out.println("AFTER Option 1 - with two lists: ");
        testDates1.forEach(System.out::println);


        // Option 2 - with custom comparator
        List<LocalDate> testDates2 = new ArrayList<>(dates);

        DateSorterWithComparator dateSorterWithComparator = new DateSorterWithComparator();
        testDates2 = (List<LocalDate>) dateSorterWithComparator.sortDates(testDates2);

        System.out.println("\nAFTER Option 2 - with custom comparator");
        testDates2.forEach(System.out::println);
    }
}
