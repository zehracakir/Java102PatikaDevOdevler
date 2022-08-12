package BookSorter;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> book=new TreeSet<>();

        Book book1=new Book("Şeker Portakalı",183, "José Mauro de Vasconcelos", 1968);
        Book book2=new Book("Delifişek", 160, "José Mauro de Vasconcelos",1960);
        Book book3=new Book("Kürk Mantolu Madonna",  177,"Sabahattin Ali", 1943);
        Book book4=new Book("Fahrenheit 451", 350, "Ray Bradbury",1953);

        book.add(book1);
        book.add(book2);
        book.add(book3);
        book.add(book4);

        //sort by name
        System.out.println("sort by name:");
        for(Book bookName:book){
            System.out.println("Book Name: "+bookName.getBookName()+
                               "\nNumber of page: "+bookName.getNumberOfPages()+
                               "\nAuthor Name: "+bookName.getAuthorName()+
                               "\nReleased Date: "+bookName.getReleaseDate());
            System.out.println("..........................................");
        }
        
        
        //number of page 
        TreeSet<Book> books=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNumberOfPages()-o2.getNumberOfPages();
            }
        });

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        System.out.println("************************************");
        System.out.println("sorted by number of page");
        for(Book bookPage:books){
            System.out.println("Book Name: "+bookPage.getBookName()+
            "\nNumber of page: "+bookPage.getNumberOfPages()+
            "\nAuthor Name: "+bookPage.getAuthorName()+
            "\nReleased Date: "+bookPage.getReleaseDate());
System.out.println("..........................................");
        }


   
    }
}
