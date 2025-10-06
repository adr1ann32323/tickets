package view;

import controller.Controller;
import domain.Ticket;
import domain.User;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class View {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void menu() {
        String option;
        do {
            option = JOptionPane.showInputDialog(null,
                    """
                    --- Menú Sistema de Soporte ---
                    1. Registrar usuario
                    2. Crear ticket
                    3. Asignar ticket
                    4. Cambiar estado ticket
                    5. Buscar por estado + categoría
                    6. Listar por assignee
                    7. Top 3 categorías
                    8. Listar usuarios
                    0. Salir
                    """,
                    "Menú principal", JOptionPane.QUESTION_MESSAGE);

            if (option == null) break;

            try {
                switch (option) {
                    case "1" -> handleRegistrarUsuario();/*
                    case "2" -> handleCrearTicket();
                    case "3" -> handleAsignarTicket();
                    case "4" -> handleCambiarEstado();
                    case "5" -> handleBuscarEstadoCategoria();
                    case "6" -> handleListarPorAssignee();
                    case "7" -> handleTopCategorias();*/
                    case "8" -> handleListarUsuarios();
                    case "0" -> JOptionPane.showMessageDialog(null, "Saliendo...");
                    default -> JOptionPane.showMessageDialog(null, "Opción inválida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!"0".equals(option));
    }

    private void handleRegistrarUsuario() throws Exception {
        String name = JOptionPane.showInputDialog("Nombre:");
        String email = JOptionPane.showInputDialog("Email:");
        String rol = JOptionPane.showInputDialog("Rol (REPORTER / ASSIGNEE / COORDINADOR):");

        var user = controller.registerUser(name, email, rol);
        JOptionPane.showMessageDialog(null, "Usuario creado:\n" + user);
    }
/*
    private void handleCrearTicket() throws Exception {
        String title = JOptionPane.showInputDialog("Título:");
        String description = JOptionPane.showInputDialog("Descripción:");
        int reporter = Integer.parseInt(JOptionPane.showInputDialog("Reporter ID:"));

        StringBuilder categorysStr = new StringBuilder("Categorías disponibles:\n");
        controller.listarCategorias().forEach(c -> categorysStr.append(c).append("\n"));
        JOptionPane.showMessageDialog(null, categorysStr.toString());

        int cat = Integer.parseInt(JOptionPane.showInputDialog("Categoria ID:"));

        var t = controller.crearTicket(title, description, reporter, cat);
        JOptionPane.showMessageDialog(null, "Ticket creado:\n" + t);
    }

    private void handleAsignarTicket() throws Exception {
        int ticketId = Integer.parseInt(JOptionPane.showInputDialog("Ticket ID:"));
        int assigneeId = Integer.parseInt(JOptionPane.showInputDialog("Assignee ID:"));
        controller.asignarTicket(ticketId, assigneeId);
        JOptionPane.showMessageDialog(null, "Ticket asignado correctamente.");
    }

    private void handleCambiarEstado() throws Exception {
        int ticketId = Integer.parseInt(JOptionPane.showInputDialog("Ticket ID:"));

        StringBuilder estadosStr = new StringBuilder("Estados disponibles:\n");
        controller.listarEstados().forEach(e -> estadosStr.append(e).append("\n"));
        JOptionPane.showMessageDialog(null, estadosStr.toString());

        String estado = JOptionPane.showInputDialog("Nuevo estado (nombre):");
        int userId = Integer.parseInt(JOptionPane.showInputDialog("Usuario que realiza el cambio (ID):"));

        controller.cambiarEstado(ticketId, estado, userId);
        JOptionPane.showMessageDialog(null, "Estado modificado correctamente.");
    }

    private void handleBuscarEstadoCategoria() throws Exception {
        String estado = JOptionPane.showInputDialog("Estado nombre:");
        String cat = JOptionPane.showInputDialog("Categoria nombre:");

        List<Ticket> list = controller.listarPorEstadoYCategoria(estado, cat);

        StringBuilder result = new StringBuilder("Resultados:\n");
        list.forEach(t -> result.append(t).append("\n"));
        JOptionPane.showMessageDialog(null, result.toString());
    }

    private void handleListarPorAssignee() throws Exception {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Assignee ID:"));
        List<Ticket> list = controller.listarPorAssignee(id);

        StringBuilder result = new StringBuilder("Tickets asignados:\n");
        list.forEach(t -> result.append(t).append("\n"));
        JOptionPane.showMessageDialog(null, result.toString());
    }

    private void handleTopCategorias() throws Exception {
        List<Map<String, Object>> top = controller.topCategorys(3);
        StringBuilder sb = new StringBuilder("Top categorías:\n");
        top.forEach(row -> sb.append(row.get("nombre")).append(" -> ").append(row.get("total")).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }
*/
    private void handleListarUsuarios() throws Exception {
        List<User> users = (List<User>) controller.listUsers();

        StringBuilder sb = new StringBuilder("Usuarios registrados:\n");
        users.forEach(u -> sb.append(u).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
