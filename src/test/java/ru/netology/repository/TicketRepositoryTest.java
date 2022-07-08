package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exceptions.*;

public class TicketRepositoryTest {

    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 200, "DME", "KZN", 130);
    Ticket ticket2 = new Ticket(2, 800, "VKO", "VVO", 480);
    Ticket ticket3 = new Ticket(3, 300, "VOZ", "DME", 45);
    Ticket ticket4 = new Ticket(4, 400, "AER", "SVO", 90);
    Ticket ticket5 = new Ticket(5, 550, "IST", "AER", 180);
    Ticket ticket6 = new Ticket(6, 650, "TLV", "HEL", 200);

    @Test
    public void emptyRepo() {
        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneTicket() {
        repo.save(ticket3);

        Ticket[] expected = {ticket3};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveSeveralTickets() {
        repo.save(ticket1);
        repo.save(ticket3);
        repo.save(ticket5);

        Ticket[] expected = {ticket1, ticket3, ticket5};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(ticket5);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.removeById(2);

        Ticket[] expected = {ticket5, ticket3};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenIDNotFound() {
        repo.save(ticket2);
        repo.save(ticket5);
        repo.save(ticket3);


        assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSaveProductAlreadyExists() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);


        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(ticket2);
        });
    }
}
