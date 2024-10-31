package group2;

import java.util.Date;
import java.util.EmptyStackException;

class Node {
    Node next;
    Book book;

    public Node(Node next, Book book) {
        this.next = next;
        this.book = book;
    }

    public Node getNext() {
        return next;
    }

    public Book getBook() {
        return book;
    }

    public void setNext(Node next) {
        this.next = next;
    } 
}

class Book {
    private String title;
    private long ISBN;
    private String author;
    private int publicationDate;

    public Book(String title, long ISBN, String author, int publicationDate) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }
}

class LinkedLista {
    Node top;
    int countBook = 0;

    public LinkedLista() {
        this.top = null;
    }

    public void insertBook(Book newBook) {
        Node newNode = new Node(top, newBook);
        top = newNode;
        countBook++;
    }
    
    public void removeBook(long ISBN) {
        if (top == null) {
            throw new EmptyStackException();
        }
        
        if (top.getBook().getISBN() == ISBN) {
            top = top.getNext();
            countBook--;
            return;
        }

        Node current = top;
        while (current.getNext() != null) {
            if (current.getNext().getBook().getISBN() == ISBN) {
                current.setNext(current.getNext().getNext());
                countBook--;
                return;
            }
            current = current.getNext();
        }
        
        throw new IllegalArgumentException("Book with ISBN " + ISBN + " not found.");
    }

    public Book findBook(long ISBN) {
        Node current = top;
        while (current != null) {
            if (current.getBook().getISBN() == ISBN) {
                return current.getBook();
            }
            current = current.getNext();
        }
        return null;
    }
    
    public void displayCatalog() {
        Node current = top;
        while (current != null) {
            Book book = current.getBook();
            System.out.println("ISBN: " + book.getISBN() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Publication Date: " + book.getPublicationDate());
            current = current.getNext();
        }
    }
    
    public int countBooks() {
        return countBook;
    }
}

public class App {
    public static void main(String[] args) {
        LinkedLista catalog = new LinkedLista();

        catalog.insertBook(new Book("A Brief History of Time", 9780553109535L, "Stephen Hawking", 1988));
        catalog.insertBook(new Book("The Selfish Gene", 9780316017923L, "Richard Dawkins", 1976));
        catalog.insertBook(new Book("Sophie's World", 9780553109535L, "jostein Gaarder", 1991));
       

        System.out.println("Book Catalog:");
        catalog.displayCatalog();

        System.out.println("Total books: " + catalog.countBooks());
        
        Book foundBook = catalog.findBook(9780316017923L);
        if (foundBook != null) {
            System.out.println("Found Book: " + foundBook.getTitle() + foundBook.getAuthor() + foundBook.getISBN() + foundBook.getPublicationDate());
        }

    
        catalog.removeBook(9780553109535L);
        System.out.println("After removing a book:");
        catalog.displayCatalog();
        System.out.println("Total number of books: " + catalog.countBooks());
    }
}
