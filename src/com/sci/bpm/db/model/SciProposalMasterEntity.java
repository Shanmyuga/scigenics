package com.sci.bpm.db.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "SCI_PROPOSAL_MASTER", schema = "SCIGENICS", catalog = "")
public class SciProposalMasterEntity implements Serializable {
    private long seqPropId;
    private String proposalName;
    private String proposalClient;
    private String proposalRemarks;
    private Date insertedDate;
    private String insertedBy;
    private Date updatedDate;
    private String updatedBy;
    private Collection<SciProposalDetailsEntity> sciProposalDetailsBySeqPropId = new ArrayList<SciProposalDetailsEntity>();



    @Id
    @Column(name = "SEQ_PROP_ID", nullable = false, precision = 0)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_PROPOSAL_MAST_SEQ")
    @SequenceGenerator(allocationSize=1, sequenceName="SCI_PROPOSAL_MAST_SEQ" ,name="SCI_PROPOSAL_MAST_SEQ" )
    public long getSeqPropId() {
        return seqPropId;
    }

    public void setSeqPropId(long seqPropId) {
        this.seqPropId = seqPropId;
    }

    @Basic
    @Column(name = "PROPOSAL_NAME", nullable = false, length = 200)
    public String getProposalName() {
        return proposalName;
    }

    public void setProposalName(String proposalName) {
        this.proposalName = proposalName;
    }

    @Basic
    @Column(name = "PROPOSAL_CLIENT", nullable = false, length = 200)
    public String getProposalClient() {
        return proposalClient;
    }

    public void setProposalClient(String proposalClient) {
        this.proposalClient = proposalClient;
    }

    @Basic
    @Column(name = "PROPOSAL_REMARKS", nullable = true, length = 200)
    public String getProposalRemarks() {
        return proposalRemarks;
    }

    public void setProposalRemarks(String proposalRemarks) {
        this.proposalRemarks = proposalRemarks;
    }

    @Basic
    @Column(name = "INSERTED_DATE", nullable = false)
    public Date getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        this.insertedDate = insertedDate;
    }

    @Basic
    @Column(name = "INSERTED_BY", nullable = true, length = 20)
    public String getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }

    @Basic
    @Column(name = "UPDATED_DATE", nullable = false)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Basic
    @Column(name = "UPDATED_BY", nullable = true, length = 20)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SciProposalMasterEntity that = (SciProposalMasterEntity) o;

        if (seqPropId != that.seqPropId) return false;
        if (proposalName != null ? !proposalName.equals(that.proposalName) : that.proposalName != null) return false;
        if (proposalClient != null ? !proposalClient.equals(that.proposalClient) : that.proposalClient != null)
            return false;
        if (proposalRemarks != null ? !proposalRemarks.equals(that.proposalRemarks) : that.proposalRemarks != null)
            return false;
        if (insertedDate != null ? !insertedDate.equals(that.insertedDate) : that.insertedDate != null) return false;
        if (insertedBy != null ? !insertedBy.equals(that.insertedBy) : that.insertedBy != null) return false;
        if (updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null) return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seqPropId ^ (seqPropId >>> 32));
        result = 31 * result + (proposalName != null ? proposalName.hashCode() : 0);
        result = 31 * result + (proposalClient != null ? proposalClient.hashCode() : 0);
        result = 31 * result + (proposalRemarks != null ? proposalRemarks.hashCode() : 0);
        result = 31 * result + (insertedDate != null ? insertedDate.hashCode() : 0);
        result = 31 * result + (insertedBy != null ? insertedBy.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        return result;
    }

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "masterEntity")
    public Collection<SciProposalDetailsEntity> getSciProposalDetailsBySeqPropId() {
        return sciProposalDetailsBySeqPropId;
    }

    public void setSciProposalDetailsBySeqPropId(Collection<SciProposalDetailsEntity> sciProposalDetailsBySeqPropId) {
        this.sciProposalDetailsBySeqPropId = sciProposalDetailsBySeqPropId;
    }
}
