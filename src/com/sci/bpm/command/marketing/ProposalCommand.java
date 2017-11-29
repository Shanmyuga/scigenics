package com.sci.bpm.command.marketing;

import java.io.Serializable;

public class ProposalCommand implements Serializable{

    private String proposalName;


    private String propRemarks;

    private String proposalClient;

    public String getProposalName() {
        return proposalName;
    }

    public void setProposalName(String proposalName) {
        this.proposalName = proposalName;
    }

    public String getPropRemarks() {
        return propRemarks;
    }

    public void setPropRemarks(String propRemarks) {
        this.propRemarks = propRemarks;
    }

    public String getProposalClient() {
        return proposalClient;
    }

    public void setProposalClient(String proposalClient) {
        this.proposalClient = proposalClient;
    }

    public Long getSeqProposalId() {
        return seqProposalId;
    }

    public void setSeqProposalId(Long seqProposalId) {
        this.seqProposalId = seqProposalId;
    }

    private Long seqProposalId;

}
