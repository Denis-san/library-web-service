package br.com.san.weblibrary.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.san.weblibrary.entities.Author;
import br.com.san.weblibrary.entities.Book;
import br.com.san.weblibrary.entities.Category;
import br.com.san.weblibrary.entities.Loan;
import br.com.san.weblibrary.entities.Order;
import br.com.san.weblibrary.entities.OrderItem;
import br.com.san.weblibrary.entities.User;
import br.com.san.weblibrary.entities.enums.Language;
import br.com.san.weblibrary.entities.enums.Nationality;
import br.com.san.weblibrary.entities.enums.OrderStatus;
import br.com.san.weblibrary.repositories.AuthorRepository;
import br.com.san.weblibrary.repositories.BookRepository;
import br.com.san.weblibrary.repositories.CategoryRepository;
import br.com.san.weblibrary.repositories.OrderItemRepository;
import br.com.san.weblibrary.repositories.OrderRepository;
import br.com.san.weblibrary.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository UserRepository;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Cientific");
		Category cat2 = new Category(null, "Didatic");
		Category cat3 = new Category(null, "History");
		Category cat4 = new Category(null, "Fiction");

		Book b1 = new Book(null, "Sherlock Holmes", 1988, Language.PORTUGUESE_BRAZIL, 11111111);
		Book b2 = new Book(null, "Math is cool", 2012, Language.ENGLISH_UK, 21324432);
		Book b3 = new Book(null, "World War two", 2005, Language.SPANISH, 8476334);
		Book b4 = new Book(null, "Cold War", 2001, Language.PORTUGUESE_BRAZIL, 59823784);
		Book b5 = new Book(null, "Biomedicine", 1987, Language.PORTUGUESE_PORTUGAL, 4283764);
		Book b6 = new Book(null, "Assassis Creed", 2000, Language.ENGLISH_US, 3714234);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6));

		b1.getCategories().add(cat4);
		b2.getCategories().add(cat2);
		b2.getCategories().add(cat3);
		b3.getCategories().add(cat3);
		b4.getCategories().add(cat3);
		b5.getCategories().add(cat2);
		b6.getCategories().add(cat4);

		Author a1 = new Author(null, "Arthur Conan Doyle", Nationality.BRITISH, "Short biography of Arthur Conan Doyle");
		Author a2 = new Author(null, "Bob Brown", Nationality.ITALIAN, "Short biography of Arthur Bob Brown. Is is a good man");
		Author a3 = new Author(null, "Walter White", Nationality.AMERICAN, "Short biography of Arthur Walter White, the coocker");
		Author a4 = new Author(null, "Jessie Pinkman", Nationality.AMERICAN, "Short biography of Arthur Jessie Pinkman, the robin");
		Author a5 = new Author(null, "Jhon Antony", Nationality.SPANISH, "Short biography of Jhon Antony");
		Author a6 = new Author(null, "Charles ", Nationality.AMERICAN, "Short biography of Charles");
		
		
		a1.getBooks().add(b1);
		
		a2.getBooks().add(b3);
		a2.getBooks().add(b4);
		a2.getBooks().add(b6);
		
		a3.getBooks().add(b6);
		a3.getBooks().add(b5);

		authorRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6));

		b1.getAuthors().add(a1);
		b1.getAuthors().add(a4);
		
		b2.getAuthors().add(a2);
		b2.getAuthors().add(a3);
		b2.getAuthors().add(a1);
		
		b3.getAuthors().add(a3);
		b4.getAuthors().add(a4);
		b5.getAuthors().add(a5);
		b6.getAuthors().add(a6);

		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6));

		User u1 = new User(null, "Maria", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.LOANED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PROCESSING, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.UNAVAILABLE, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrderItem oi1 = new OrderItem(o1, b1, 2, new Date());
		OrderItem oi2 = new OrderItem(o1, b3, 1, new Date());
		OrderItem oi3 = new OrderItem(o2, b3, 2, new Date());
		OrderItem oi4 = new OrderItem(o3, b5, 2, new Date());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Loan pay1 = new Loan(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setLoan(pay1);
		orderRepository.save(o1);

	}

}
