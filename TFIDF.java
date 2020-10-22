/*
* Use upto 3 documents
*/
import java.util.*;
public class TFIDF
{
    public static double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    public static double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    public static double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }

    public static void main(String[] args) {
        System.out.println("Enter Sentences to calculate TfIdf:");
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();
        List<String> doc1 = Arrays.asList(str1.split(" ")); 
        List<String> doc2 = Arrays.asList(str2.split(" "));
        List<String> doc3 = Arrays.asList(str3.split(" "));
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);
        System.out.println("Doc 1");
        for(String str: doc1){
            double tfidf = tfIdf(doc1, documents, str);
            System.out.println("TF-IDF ("+str+") = " + tfidf);
        }
        System.out.println("\nDoc 2");
        for(String str: doc2){
            double tfidf = tfIdf(doc2, documents, str);
            System.out.println("TF-IDF ("+str+") = " + tfidf);
        }
        System.out.println("\nDoc 3");
        for(String str: doc3){
            double tfidf = tfIdf(doc3, documents, str);
            System.out.println("TF-IDF ("+str+") = " + tfidf);
        }
    }
}
