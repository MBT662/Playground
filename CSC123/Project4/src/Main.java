import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
    }

    @Entity
    class Person {
        @Id
        private Long id;
        private String name;

        public Person() {}

        public Person(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getters and setters omitted for brevity
    }

    public static void exampleJPAUsage() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Person person = new Person(1L, "Alice");
        em.persist(person);
        em.getTransaction().commit();

        Person found = em.find(Person.class, 1L);
        System.out.println("Found person: " + found.name);

        em.close();
        emf.close();
    }
}
