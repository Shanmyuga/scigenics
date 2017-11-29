package com.sci.bpm.service.marketing;

import com.sci.bpm.command.marketing.ProposalCommand;
import com.sci.bpm.dao.marketing.ProposalDAO;
import com.sci.bpm.db.model.SciProposalMasterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
@Transactional
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalDAO propDao;
    @Override
    public void addProposal(SciProposalMasterEntity entity) {
        propDao.addProposal(entity);
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
        return propDao.findProposal(seqProposalId);
    }
}
