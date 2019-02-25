package mx.gob.conacyt.generadorpantallas.legacy.domain.identifiergenerators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Value;

public class PrefixBasedGenerator implements IdentifierGenerator {

    @Value("#{prefix}")
    private String prefix;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "13";
        AbstractEntityPersister entity = ((AbstractEntityPersister) object);
        String idPropertyName = entity.getIdentifierPropertyName();
        String entityName = entity.getEntityName();
        Query<Long> query = ((Session) session).createQuery("select max(e." + idPropertyName + ") from " + entityName
                + " e where " + idPropertyName + " like " + "^" + prefix, Long.class);
        Long maxId = query.uniqueResult();
        return maxId + 1;
    }

}
