package com.sci.bpm.dao.marketing;

import com.sci.bpm.command.marketing.ProposalCommand;
import com.sci.bpm.db.model.SciProposalMasterEntity;

import java.util.List;

public interface ProposalDAO {

    public void addProposal(SciProposalMasterEntity entity);

    public List<SciProposalMasterEntity> viewProposal(ProposalCommand command);

    public void editProposal(SciProposalMasterEntity entity);

    public SciProposalMasterEntity findProposal(Long seqProposalId);
}
