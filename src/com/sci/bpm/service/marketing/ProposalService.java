package com.sci.bpm.service.marketing;

import com.sci.bpm.command.marketing.ProposalCommand;
import com.sci.bpm.db.model.SciProposalMasterEntity;

import java.util.List;

public interface ProposalService {


    public void addProposal(SciProposalMasterEntity entity);

    public List<SciProposalMasterEntity> viewProposal(ProposalCommand command);

    public void editProposal(SciProposalMasterEntity entity);

    public SciProposalMasterEntity findProposal(Long seqProposalId);
}
