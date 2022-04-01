package lab.util;

import java.util.List;
import java.util.ArrayList;

import lab.demand.Order;

public class TestUtil {

    public static List<Order> buildOrdersPeru() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("PE", 10L));
        ordersPeru.add(new Order("PE", 10L));
        return ordersPeru;
    }

    public static List<Order> buildOrdersColombia() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("CO", 10L));
        ordersPeru.add(new Order("CO", 10L));
        return ordersPeru;
    }

    public static List<Order> buildOrdersBrazil() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("BR", 10L));
        ordersPeru.add(new Order("BR", 10L));
        return ordersPeru;
    }

    public static List<Order> buildOrdersArgentina() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("AR", 10L));
        ordersPeru.add(new Order("AR", 10L));
        return ordersPeru;
    }

}