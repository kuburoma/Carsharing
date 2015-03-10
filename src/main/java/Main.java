import cz.carsharing.entities.Carr;
import cz.carsharing.utilities.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class Main {

    public static void main(final String[] args) throws Exception {
        Carr carr = new Carr();
        carr.setName("asd");
        carr.setType("8vdd");

        Session session = HibernateUtil.currentSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        session.save(carr);
        session.flush();
        tx.commit();
    }
}
