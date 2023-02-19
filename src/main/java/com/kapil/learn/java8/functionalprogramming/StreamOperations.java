package com.kapil.learn.java8.functionalprogramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    static class Book implements Comparable<Book> {
        private long isbn;
        private String title;
        private double rating;
        private double price;
        private String source;

        public Book(long isbn, String title, double rating, double price, String source) {
            this.isbn = isbn;
            this.title = title;
            this.rating = rating;
            this.price = price;
            this.source = source;
        }

        public long getIsbn() {
            return isbn;
        }

        public void setIsbn(long isbn) {
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        @Override
        public String toString() {
            return "StreamOperations {" +
                    "isbn=" + isbn +
                    ", title='" + title + '\'' +
                    ", rating=" + rating +
                    ", price=" + price +
                    ", source='" + source + '\'' +
                    "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Book book = (Book) o;

            return isbn == book.isbn;
        }

        @Override
        public int hashCode() {
            return (int) (isbn ^ (isbn >>> 32));
        }

        @Override
        public int compareTo(Book book) {
            return Long.compare(isbn, book.getIsbn());
        }
    }

    // Print at most 5 DISTINCT books with rating >= 4.5
    // DB world: select distinct (ISBN) from book where rating >= 4.5 limit 0, 5;
    private static void slice(List<Book> books) {
        System.out.println("\nSlice ... ");
        List<Book> result = books.stream()
                .filter(book -> book.getRating() >= 4.5)
                .distinct()
//                .limit(5)
//                .peek(d -> System.out.println(d.getTitle() + " " + d.getRating()))
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("\nResulted List: ");
        result.forEach(book -> System.out.println(book.getTitle()));
    }

    // Queries:
    //  (a) Is there at least one highly rated book (>= 4.8) that is inexpensive (<= $50)?
    //  (b) Do all the books have a rating >= 4.8
    //  (c) Check if none of books have bad rating (2.0)?
    private static void match(List<Book> books) {
        System.out.println("\nMatching ... ");

        boolean anyMatch = books.stream()
                .anyMatch(b -> b.getRating() >= 4.8 && b.getPrice() <= 50);
        System.out.println("anyMatch? " + anyMatch);

        boolean allMatch = books.stream()
                .allMatch(b -> b.getRating() >= 4.8);
        System.out.println("allMatch? " + allMatch);


        boolean noneMatch = books.stream()
                .noneMatch(b -> b.getRating() <= 2.0);
        System.out.println("noneMatch? " + noneMatch);
    }

    private static void find(List<Book> books) {
        print.accept("\nFinding ...");
        /*Optional<Book> result = */
        books.stream()
                .filter(book -> book.getRating() >= 5.0 && book.getPrice() <= 50)
                .findAny().ifPresentOrElse(print::accept, StreamOperations::getDefault);

        Optional<Book> opt = Optional.ofNullable(books.get(0));
        print.accept(opt.get());

       /* if(result.isPresent()){
            print.accept(result.get());
        } else {
            print.accept("not found!");
        }*/
    }

    // Find the lowest priced book with a rating >= 4.5
    private static void reduce(List<Book> books) {
        books.stream()
                .filter(book -> book.getRating() >= 5)
                .reduce((book1, book2) -> book1.getPrice() <= book2.getPrice() ? book1 : book2)
                .ifPresentOrElse(
                        book -> System.out.println("Lowest priced book: " + book),
                        () -> System.out.println(" Such book not found!"));
    }

    // Limitations:
    //   1. Cumbersome
    //   2. Paralleling is painful
    //   3. Synchronizing shared mutable variable is expensive
    private static void reduceImperatively(List<Book> books) {
        System.out.println("\nReducing imperatively ...");
        Book result = null;

        for (Book book : books) {
            // Initialize result with first book having rating >= 4.5
            if (result == null) {
                if (book.getRating() >= 4.5) {
                    result = book;
                }
                continue;
            }

            if (book.getRating() >= 4.5 && result.getPrice() > book.getPrice()) {
                result = book;
            }
        }

        System.out.println("(Imperative) Lowest priced book with rating >= 4.5: " + result);
    }

    private static final Consumer<Object> print = System.out::println;

    private static Book getDefault() {
        System.out.println("default ...");
        return new Book(0, "", 4.0, 25.0, "Amazon");
    }

    private static void overloadedReductions() {
        System.out.println("\noverloadedReductions ... ");

        String[] grades = {"A", "A", "B"};

        String concat1 = Arrays.stream(grades)//Stream.of(grades)
                .reduce("", (s1, s2) -> s1 + s2);
        System.out.println("concat1:" + concat1);

        StringBuilder concat2 = Stream.of(grades)
                .reduce(new StringBuilder(),
                        (sb, s) -> sb.append(s),
                        (sb1, sb2) -> sb1.append(sb2));
        System.out.println("concat2:" + concat2);

        // Not efficient: Each accumulation step creates a new StringBuilder
        StringBuilder concat3 = Stream.of(grades).parallel()
                .reduce(new StringBuilder(),
                        (sb, s) -> new StringBuilder().append(sb).append(s),
                        (sb1, sb2) -> sb1.append(sb2));
        System.out.println("concat3:" + concat3);
    }

    // if accumulator mutates, use collect(). Otherwise, use reduce()
    private static void mutableReduction() {
        System.out.println("\nmutableReduction ... ");
        String[] grades = {"A", "A", "B"};
        StringBuilder concatUsingCollect = Arrays.stream(grades).parallel()
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);
                /*.collect(() -> new StringBuilder(),
                        (sb, s) -> sb.append(s),
                        (sb1, sb2) -> sb1.append(sb2));*/
        System.out.println("contactUsingCollect: " + concatUsingCollect);

        String concatUsingJoining = Arrays.stream(grades).parallel()
                .collect(Collectors.joining());
        System.out.println("concatUsingJoining: " + concatUsingJoining);
    }

    private static void collectToCollection(List<Book> books) {
        System.out.println("\nIn collectToCollection ...");
        List<Book> list1 = books.stream()
                .filter(b -> b.getRating() >= 4.5)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("list1.size: " + list1.size());
        System.out.println("list1: " + list1);

        Set<Book> set1 = books.stream()
                .filter(b -> b.getRating() >= 4.5)
                .collect(Collectors.toSet());
        System.out.println("Set1.size: " + set1.size());
        System.out.println("Set1: " + set1);

        TreeSet<Book> treeSet = books.stream()
                .filter(b -> b.getRating() >= 4.5)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet.size: " + treeSet.size());
        System.out.println("treeSet: " + treeSet);
    }

    private static void collectToMap(List<Book> books) {
        System.out.println("\nIn collectToMap ...");

        // Create a HashMap: {Key: isbn, value: book}
        Map<Long, Book> mapUsingToMap = books.stream()
                /*.collect(Collectors.toMap(
                        book -> book.getIsbn(),
                        book -> book,
                        (book1, book2) -> book1.getPrice() < book2.getPrice() ? book1 : book2));*/
                .collect(Collectors.toMap(
                        Book::getIsbn,
                        Function.identity(),
                        (book1, book2) -> book1.getPrice() < book2.getPrice() ? book1 : book2));
        mapUsingToMap.entrySet().forEach(book -> System.out.println("ISBN: " + book.getKey() + ", book: " + book.getValue()));

        System.out.println("Is mapUsingToMap a HashMap? Ans: " + (mapUsingToMap instanceof HashMap));

        // Create a TreeMap: {Key: isbn, value: book}
        Map<Long, Book> treeMapUsingToMap = books.stream()
                .collect(Collectors.toMap(
                        Book::getIsbn,
                        Function.identity(),
                        (book1, book2) -> book1.getPrice() < book2.getPrice() ? book1 : book2,
                        TreeMap::new));
        treeMapUsingToMap.forEach((key, value) -> System.out.println("ISBN: " + key + ", book: " + value));

        //TreeMap - Group by rating
        /*Map<Double, List<Book>> treeMapGroupedByRating = treeMapUsingToMap.values().stream()
                .collect(Collectors.toMap(
                        Book::getRating,
                        Collections::singleton,
                        (list1, list2) -> {
                            ArrayList<Book> list = new ArrayList<>(list1);
                            list.addAll(list2);
                            return list;
                        }));*/

        System.out.println("\nTreeMap - Group by rating - treeMapGroupedByRating {key: rating, value: List.of(book)}");
        Map<Double, List<Book>> treeMapGroupedByRating1 = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(Book::getRating));

        treeMapGroupedByRating1.forEach((key, value) -> {
            System.out.println("\nRating: " + key);
            value.forEach(System.out::println);
        });


        System.out.println("\nTreeMap - Group by rating - treeMapGroupedByRating {key: rating, value: Set.of(book)}");
        //TreeMap - Group by rating - treeMapGroupedByRating {key: rating, value: List.of(book)}
        Map<Double, Set<Book>> treeMapGroupedByRating2 = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(
                        Book::getRating,
                        TreeMap::new,
                        Collectors.toSet()));

        treeMapGroupedByRating2.forEach((key, value) -> {
            System.out.println("\nRating: " + key);
            value.forEach(System.out::println);
        });

        Map<Double, Map<String, List<Book>>> multiLevelMap = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(
                        Book::getRating,
                        TreeMap::new,
                        Collectors.groupingBy(
                                Book::getSource,
                                Collectors.toList())));
        System.out.println("\nmultiLevelMap: " + multiLevelMap);

        Map<Double, Long> ratingsCountMap = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(Book::getRating, Collectors.counting()));
        System.out.println("\nratingsCountMap: " + ratingsCountMap);
        System.out.println("\ncount: " + treeMapUsingToMap.values().stream().collect(Collectors.counting()));

        Map<Double, Double> ratingsAvgPriceMap = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(Book::getRating, Collectors.averagingDouble(Book::getPrice)));
        System.out.println("\nratingsAvgPriceMap: " + ratingsAvgPriceMap);

        Map<Double, Optional<Book>> ratingsMinPriceMap = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(
                        Book::getRating,
                        Collectors.minBy(Comparator.comparing(Book::getPrice))));
        System.out.println("\nratingsMinPriceMap: " + ratingsMinPriceMap);

        Map<Double, Optional<Book>> ratingsMaxPriceMap = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(
                        Book::getRating,
                        Collectors.maxBy(Comparator.comparing(Book::getPrice))));
        System.out.println("\nratingsMaxPriceMap: " + ratingsMaxPriceMap);

        Map<Double, DoubleSummaryStatistics> ratingsSummaryMap = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(
                        Book::getRating,
                        Collectors.summarizingDouble(Book::getPrice)));
        System.out.println("\nDoubleSummaryStatistics: " + ratingsSummaryMap);

        Map<Boolean, List<Book>> partitionedMap = treeMapUsingToMap.values().stream()
                .collect(Collectors.partitioningBy(book -> book.getRating() >= 4.5));
        System.out.println("\npartitionedMap: " + partitionedMap);

        Map<Double, List<String>> ratingsTitleMap = treeMapUsingToMap.values().stream()
                .collect(Collectors.groupingBy(
                        Book::getRating,
                        Collectors.mapping(
                                Book::getTitle,
                                Collectors.toList())));
        System.out.println("\nratingsTitleMap: " + ratingsTitleMap);
    }


    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.addAll(DataExtractor.getFromAmazon("java"));
        books.addAll(DataExtractor.getFromBarnesAndNoble("java"));

        // intermediate operations (return stream objects)
        // slice(books);

        // terminal operations (return non-stream objects)
        // match(books);  // matching stream elements to some criteria

        // All matching & finding operations + limit
        //    are short-circuit operations (recall &&, ||)
        // find(books);

        // reduce(books);
        // reduceImperatively(books);
        // overloadedReductions();

//         mutableReduction();

        // collectToCollection(books);

        collectToMap(books);
    }


}


