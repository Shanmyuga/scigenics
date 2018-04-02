package com.sci.bpm.dao.marketing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.command.marketing.EnqBean;
import com.sci.bpm.db.model.SciEnquiryDetails;
import com.sci.bpm.db.model.SciEnquiryMaster;
import com.sci.bpm.db.model.SciMatindMaster;

@Repository
public class EnquiryDAOImpl implements EnquiryDAO {

    @PersistenceContext
    private EntityManager em;

    public void addNewEnqMaster(SciEnquiryMaster master) {
        // TODO Auto-generated method stub
        em.persist(master);
    }

    public void addNewEnquiryDetail(SciEnquiryDetails details,
                                    SciEnquiryMaster master) {
        em.persist(details);

    }

    public List loadEnquiryDetails(SciEnquiryMaster master) {

        Query qry = em.createQuery("from SciEnquiryDetails where sciEnquiryMaster =:emaster");
        qry.setParameter("emaster", master);
        return qry.getResultList();
    }

    public List loadOpenEnquiry(EnqBean command) {


        String query = "select  m from SciEnquiryMaster m ";
        // Query query = em.createQuery("Select * from SciMatindMaster m ");
        Map parameters = new HashMap();
        String whereClause = "where";

        if (command.getEnqStatus() != null && !"".equals(command.getEnqStatus())) {
            whereClause = whereClause + " and m.enqStatus = :enqStatus ";
            parameters.put("enqStatus", command.getEnqStatus());
        }
        if (command.getSeqCustomerId() != null) {
            whereClause = whereClause + " and m.sciCustomerMaster.seqCustId = :seqCustomerId ";
            parameters.put("seqCustomerId", command.getSeqCustomerId());
        }

        if (command.getSeqEnqMasterId() != null) {
            whereClause = whereClause + " and m.seqEnqryId = :seqEnqryId ";
            parameters.put("seqEnqryId", command.getSeqEnqMasterId());
        }

        if (command.getEnqPriority() != null) {
            whereClause = whereClause + " and m.enqPriority = :enqPriority ";
            parameters.put("enqPriority", command.getEnqPriority());
        }

        Query wquery = null;
        if (parameters.size() > 0) {
            wquery = em.createQuery(query
                    + whereClause.replaceAll("where and", "where"));
        } else {
            System.out.println("myquery " + query);
            wquery = em.createQuery(query);
        }
        Iterator keyset = parameters.keySet().iterator();

        while (keyset.hasNext()) {
            String key = (String) keyset.next();
            wquery.setParameter(key, parameters.get(key));
        }

        List<SciEnquiryMaster> enqList = wquery.getResultList();
        return enqList;
    }

    public void closeEnquury(SciEnquiryMaster master) {
        em.merge(master);

    }

    public void updateEnquiryMaster(SciEnquiryMaster master) {
        // TODO Auto-generated method stub
        em.merge(master);
    }

}
