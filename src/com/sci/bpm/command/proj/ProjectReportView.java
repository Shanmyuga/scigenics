package com.sci.bpm.command.proj;

import java.io.Serializable;

public class ProjectReportView implements Serializable {

    private String year;

    private String month;

    private String weekStartDate;

    private String weekEndDate;

    private String clientDesc;

    private String jobDesc;

    private String phaseDesc;

    public String getYear() {
        return year;
    }

    public ProjectReportView(String year, String month, String weekStartDate, String weekEndDate, String clientDesc, String jobDesc, String phaseDetail,String phaseDesc, String totalEstimatedManhours, String totalActualManHours) {
        this.year = year;
        this.month = month;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
        this.clientDesc = clientDesc;
        this.jobDesc = jobDesc;
        this.phaseDetail = phaseDetail;
        this.totalEstimatedManhours = totalEstimatedManhours;
        this.totalActualManHours = totalActualManHours;
        this.phaseDesc = phaseDesc;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(String weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public String getWeekEndDate() {
        return weekEndDate;
    }

    public void setWeekEndDate(String weekEndDate) {
        this.weekEndDate = weekEndDate;
    }

    public String getClientDesc() {
        return clientDesc;
    }

    public void setClientDesc(String clientDesc) {
        this.clientDesc = clientDesc;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getPhaseDetail() {
        return phaseDetail;
    }

    public void setPhaseDetail(String phaseDetail) {
        this.phaseDetail = phaseDetail;
    }

    public String getTotalEstimatedManhours() {
        return totalEstimatedManhours;
    }

    public void setTotalEstimatedManhours(String totalEstimatedManhours) {
        this.totalEstimatedManhours = totalEstimatedManhours;
    }

    public String getTotalActualManHours() {
        return totalActualManHours;
    }

    public void setTotalActualManHours(String totalActualManHours) {
        this.totalActualManHours = totalActualManHours;
    }

    public String getPhaseDesc() {
        return phaseDesc;
    }

    public void setPhaseDesc(String phaseDesc) {
        this.phaseDesc = phaseDesc;
    }

    private String phaseDetail;

    private String totalEstimatedManhours;

    private String totalActualManHours;
}
