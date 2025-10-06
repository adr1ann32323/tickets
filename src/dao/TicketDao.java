package dao;

import domain.Ticket;
import java.util.List;
import java.util.Map;

public interface TicketDao {
    Ticket create(Ticket t) throws Exception;
    void update(Ticket t) throws Exception;
    void changeState(int ticketId, int stateId) throws Exception;
    void assign(int ticketId, int assigneeId) throws Exception;
    Ticket findById(int id) throws Exception;
    List<Ticket> listByAssignee(int assigneeId) throws Exception;
    List<Ticket> listStateAndCategory(String state, String category) throws Exception;
    List<Map<String,Object>> topCategorys(int limit) throws Exception; // nombre + total
}
