package app;

import controller.Controller;
import dao.*;
import service.*;
import view.View;

public class Main {
    public static void main(String[] args) {
        try {
            // DAO instancias
            userDao usuarioDao = new jdbcUserDao();
            //CategoryDao categoriaDao = new JdbcCategoryDao();
            //TicketDao ticketDao = new JdbcTicketDao();
            //ComentarioDao comentarioDao = new JdbcComentarioDao();

            // Services
            UserService userService = new UserService(usuarioDao);
            //TicketService ticketService = new TicketService(ticketDao, usuarioDao, categoriaDao, estadoDao, comentarioDao);

            // Controller + View
            Controller controller = new Controller(userService);
           View view = new View (controller);

            // Ejecutar menu
            view.menu();    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
