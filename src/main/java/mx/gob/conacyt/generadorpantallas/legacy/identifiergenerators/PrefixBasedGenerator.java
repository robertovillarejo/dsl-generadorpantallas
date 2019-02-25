package mx.gob.conacyt.generadorpantallas.legacy.identifiergenerators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.query.Query;

public class PrefixBasedGenerator implements IdentifierGenerator {

    private static final String prefix = "13";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        EntityPersister ep = session.getEntityPersister(null, object);
        String idPropertyName = ep.getIdentifierPropertyName();
        String entityName = ep.getEntityName();
        Query<Long> query = ((Session) session).createQuery("select max(e." + idPropertyName + ") from " + entityName
                + " e where e." + idPropertyName + " like '" + prefix + "%'", Long.class);
        Long maxId = query.uniqueResult();
        if (maxId == null) {
            return Long.parseLong(prefix.concat("1"));
        }
        return maxId + 1;
    }

}
