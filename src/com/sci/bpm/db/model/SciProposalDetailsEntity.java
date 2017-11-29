package com.sci.bpm.db.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "SCI_PROPOSAL_DETAILS", schema = "SCIGENICS", catalog = "")
public class SciProposalDetailsEntity implements Serializable {
    private long seqPropDetId;
    private Long seqMiId;
    private String matCode;
    private String matSpec;
    private Float matCost;
    private Date insertedDate;
    private String insertedBy;



    private String updatedBy;
    private Date updatedDate;
    private SciProposalMasterEntity masterEntity;

    public void setInsertedDate(Date insertedDate) {
        this.insertedDate = insertedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Id
    @Column(name = "SEQ_PROP_DET_ID", nullable = false, precision = 0)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_PROPOSAL_DET_SEQ")
    @SequenceGenerator(allocationSize=1, sequenceName="SCI_PROPOSAL_DET_SEQ" ,name="SCI_PROPOSAL_DET_SEQ" )
    public long getSeqPropDetId() {
        return seqPropDetId;
    }

    public void setSeqPropDetId(long seqPropDetId) {
        this.seqPropDetId = seqPropDetId;
    }

    @Basic
    @Column(name = "SEQ_MI_ID", nullable = true, precision = 0)
    public Long getSeqMiId() {
        return seqMiId;
    }

    public void setSeqMiId(Long seqMiId) {
        this.seqMiId = seqMiId;
    }

    @Basic
    @Column(name = "MAT_CODE", nullable = false, length = 20)
    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }

    @Basic
    @Column(name = "MAT_SPEC", nullable = true, length = 2000)
    public String getMatSpec() {
        return matSpec;
    }

    public void setMatSpec(String matSpec) {
        this.matSpec = matSpec;
    }

    @Basic
    @Column(name = "MAT_COST", nullable = true, precision = 9,scale = 2)
    public Float getMatCost() {
        return matCost;
    }

    public void setMatCost(Float matCost) {
        this.matCost = matCost;
    }

    @Basic
    @Column(name = "INSERTED_DATE", nullable = false)
    public Date getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(Time insertedDate) {
        this.insertedDate = insertedDate;
    }

    @Basic
    @Column(name = "UPDATED_BY", nullable = false, length = 20)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "UPDATED_DATE", nullable = false)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Time updatedDate) {
        this.updatedDate = updatedDate;
    }


    @ManyToOne(cascade={},
            fetch=FetchType.EAGER)

    @JoinColumn(name="SEQ_PROP_ID", unique=false, nullable=true, insertable=true, updatable=true)
    public SciProposalMasterEntity getMasterEntity() {
        return masterEntity;
    }

    public void setMasterEntity(SciProposalMasterEntity masterEntity) {
        this.masterEntity = masterEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SciProposalDetailsEntity that = (SciProposalDetailsEntity) o;

        if (seqPropDetId != that.seqPropDetId) return false;
        if (seqMiId != null ? !seqMiId.equals(that.seqMiId) : that.seqMiId != null) return false;
        if (matCode != null ? !matCode.equals(that.matCode) : that.matCode != null) return false;
        if (matSpec != null ? !matSpec.equals(that.matSpec) : that.matSpec != null) return false;
        if (matCost != null ? !matCost.equals(that.matCost) : that.matCost != null) return false;
        if (insertedDate != null ? !insertedDate.equals(that.insertedDate) : that.insertedDate != null) return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;
        if (updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seqPropDetId ^ (seqPropDetId >>> 32));
        result = 31 * result + (seqMiId != null ? seqMiId.hashCode() : 0);
        result = 31 * result + (matCode != null ? matCode.hashCode() : 0);
        result = 31 * result + (matSpec != null ? matSpec.hashCode() : 0);
        result = 31 * result + (matCost != null ? matCost.hashCode() : 0);
        result = 31 * result + (insertedDate != null ? insertedDate.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "INSERTED_BY", nullable = false, length = 20)
    public String getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }
}
