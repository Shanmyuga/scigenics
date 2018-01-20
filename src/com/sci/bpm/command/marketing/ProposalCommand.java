package com.sci.bpm.command.marketing;

import com.sci.bpm.command.mi.MatCollectionCommand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProposalCommand implements Serializable{

    private String proposalName;


    private String propRemarks;

    private String proposalClient;

    private List<MatCollectionCommand> matList = new ArrayList();

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

    public List<MatCollectionCommand> getMatList() {
        return matList;
    }

    public void setMatList(List<MatCollectionCommand> matList) {
        this.matList = matList;
    }

    public ProposalCommand() {
        super();
        for (int idx = 0; idx < 11; idx++) {
            this.matList.add(new MatCollectionCommand());
        }
    }
}
