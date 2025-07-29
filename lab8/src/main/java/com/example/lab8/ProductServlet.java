package com.example.lab8;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private EntityManagerFactory emf;
    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("myPU");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        double price = priceStr != null ? Double.parseDouble(priceStr) :
                0.0;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        em.persist(product);
        em.getTransaction().commit();
        em.close();
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        List<Product> products = em.createQuery("SELECT p FROM Product p",
                Product.class).getResultList();
        em.close();
        req.setAttribute("products", products);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/products.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    public void destroy() {
        if (emf != null) {
            emf.close();
        }
    }
}
