package com.kapil.learn.java8.functionalprogramming;

import org.htmlcleaner.HtmlCleaner;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamsDemo {
    static String doc1 = "<html><body>One of the most common uses of <i>streams</i> is to represent queries over data in collections</body></html>";
    static String doc2 = "<html><body>Information integration systems provide valuable services to users by integrating information from a number of autonomous, heterogeneous and distributed Web sources</body></html>";
    static String doc3 = "<html><body>Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene</body></html>";
    static String doc4 = "<html><body>Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism</body></html>";

    static List<String> documents = List.of(doc1, doc2, doc3, doc4);

    private static void imperative() {
        System.out.println("Imperative: \n");

        for (String doc : documents) {
            Predicate<String> filter = d -> d.contains("stream");

            if (filter.test(doc)) {
                UnaryOperator<String> htmlCleaner = Indexers::stripHtmlTags;
                doc = htmlCleaner.apply(doc);

                UnaryOperator<String> stopWordsRemover = Indexers::removeStopWords;
                doc = stopWordsRemover.apply(doc);

                System.out.println(doc);
            }
        }
    }

    private static void declarative() {
        System.out.println("\n\nDeclarative: \n");
		/*
		// Stream pipeline (a common structure):
		     (a) set-up stream source (~ tables in SQL world)
		     (b) 0 or more intermediate operations (~ WHERE clause) -- lazy
		              & return Stream<T>, i.e., transforms a stream into another stream
		     (c) terminal operation (~ column names) -- eager
		              & return NON-STREAM. Terminates (closes) a stream
		*/

        Stream<String> stream = Stream.of(doc1, doc2, doc3, doc4)//Arrays.stream(new String[]{doc1, doc2, doc3, doc4})//documents.stream()
                .filter(d -> d.contains("stream"))
                .map(Indexers::stripHtmlTags)
                .map(Indexers::removeStopWords);
              // .forEach(System.out::println);
        print(stream);
    }

    private static void print(Stream<String> stream) {
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        imperative();
        declarative();
    }


}

class Indexers {
    private static List<String> stopWords = List.of("of", "the", "a", "is", "to", "in", "and");

    private Indexers() {
    }

    static String stripHtmlTags(String doc) {
        System.out.println("In stripHtmlTags");
        return new HtmlCleaner().clean(doc).getText().toString();
    }

    static String removeStopWords(String doc) {
        StringBuilder sb = new StringBuilder();
        for (String word : doc.split(" ")) {
            if (!stopWords.contains(word))
                sb.append(word).append(" ");
        }
        return sb.toString();
    }

}
