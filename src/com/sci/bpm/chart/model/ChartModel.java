package com.sci.bpm.chart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "name",
        "legendText",
        "showInLegend",
        "dataPoints",
        "axisYType"
})
public class ChartModel {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("legendText")
    private String legendText;
    @JsonProperty("showInLegend")
    private Boolean showInLegend;
    @JsonProperty("dataPoints")
    private List<DataPoint> dataPoints = new ArrayList<DataPoint>();
    @JsonProperty("axisYType")
    private String axisYType;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void addDataPoint(DataPoint point) {
        dataPoints.add(point);
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("legendText")
    public String getLegendText() {
        return legendText;
    }

    @JsonProperty("legendText")
    public void setLegendText(String legendText) {
        this.legendText = legendText;
    }

    @JsonProperty("showInLegend")
    public Boolean getShowInLegend() {
        return showInLegend;
    }

    @JsonProperty("showInLegend")
    public void setShowInLegend(Boolean showInLegend) {
        this.showInLegend = showInLegend;
    }

    @JsonProperty("dataPoints")
    public List<DataPoint> getDataPoints() {
        return dataPoints;
    }

    @JsonProperty("dataPoints")
    public void setDataPoints(List<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }

    @JsonProperty("axisYType")
    public String getAxisYType() {
        return axisYType;
    }

    @JsonProperty("axisYType")
    public void setAxisYType(String axisYType) {
        this.axisYType = axisYType;
    }

}