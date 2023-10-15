package modelo;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import javax.persistence.*;

@WebServlet(urlPatterns = {"/miservlet"})
public class VisualizarMensajes extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        //Creo un mensaje y lo persisto
        Mensaje m = new Mensaje();
        m.setTexto("Soy un EJB3.0");
        m.setDia(new java.util.Date());
        etx.begin(); //solo como ejemplo por si necesitamos usar transacciones
        em.persist(m);
        m.setTexto("buenas");
        //si ahora hiciéramos m.setTexto(“Otro texto”); este cambio también sería persistido

        etx.commit();
        //Obtengo todos los mensajes
        /*
        List<Mensaje> mensajes=(List<Mensaje>)(em.createQuery("from modelo.Mensaje m order by m.texto asc")).getResultList();
        for (Mensaje men:mensajes) {System.out.println("Mensaje : " +men.getTexto());}
        em.close();
         */
        response.sendRedirect("indexs.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}