package br.com.carstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;

import br.com.carstore.servlet.dao.CarDao;
import br.com.carstore.servlet.model.Car;


@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String carName = req.getParameter("car-name");
        
        Car car = new Car(carName);

        new CarDao().createCar(car);

        System.out.println(carName);

        resp.sendRedirect("/find-all-cars");


    }

}