package Library;

import java.util.Scanner;

public class AddBooks implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book name: ");
        book.setName(s.next());
        System.out.println("Enter book author: ");
        book.setAuthor(s.next());
        System.out.println("Enter book publisher: ");
        book.setPublisher(s.next());
        System.out.println("Enter book collection: ");
        book.setAdress(s.next());
        System.out.println("Enter qty: ");
        book.setQty(s.nextInt());
        System.out.println("Enter price: ");
        book.setPrice(s.nextDouble());
        System.out.println("Enter borrowing copies: ");
        book.setBrwcopies(s.nextInt());
        s.close();
        database.AddBook(book);
        System.out.println("Book added successfully");
    }
}
