package com.sci.bpm.dao.marketing;

import com.sci.bpm.command.marketing.ProposalCommand;
import com.sci.bpm.db.model.SciProposalMasterEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProposalDAOImpl implements ProposalDAO {

    @PersistenceContext
    private EntityManager em;
    @Override
    public void addProposal(SciProposalMasterEntity entity) {

        em.persist(entity);

    }

    @Override
    public List<SciProposalMasterEntity> viewProposal(ProposalCommand command) {



        return null;
    }



    @Override
    public void editProposal(SciProposalMasterEntity entity) {

    }

    @Override
    public SciProposalMasterEntity findProposal(Long seqProposalId) {
        SciProposalMasterEntity  master =  em.find(SciProposalMasterEntity.class,seqProposalId);
        return master;
    }
}
