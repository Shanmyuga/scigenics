package com.sci.bpm.command.marketing;

import java.io.Serializable;

public class SciInstruDetailsCommand implements Serializable {
	private Long seqInstruDet;
	private Long seqWorkId;
	private String panelControl;
	private String contollerType;
	private String controllerName;
	private String controlPanel;
	private String software;
	private String scada;
	private String sensorType;
	private String sensorName;
	private String sensorEntry;
	private String transmiType;
	private String transmiName;
	private String tempRange;
	private String accuracyMeas;
	private String accuracyCont;
	private String motoDrive;
	private String accuRpm;
	private String accuRpmCont;
	private String powerHp;
	private String peristaticPump;
	private String flowRate;
	private String flowRateType;
	private String phQuantity;
	private String mounting;
	private String foamControl;
	private String sensorCable;
	private String foamEnrty;
	private String foamPeristaltic;
	private String foamPumpType;
	private String foamPumpRate;
	private String foamPumpQuantity;
	private String foamPumpMount;
	private String innoAdd;
	private String innoPerist;
	private String innoFlowrate;
	private String innoVessel;
	private String innoType;
	private String innoQuantity;
	private String innoMount;
	private String innoCapacity;
	private String doMeasurement;
	private String doRange;
	private String doAccuMeasu;
	private String doAccuCont;
	private String doSensortype;
	private String doSensName;
	private String doSensorEntry;
	private String doLength;
	private String doTransmitter;
	private String doContType;
	private String doAircontDevice;
	private String doMembKit;
	private String presMeasuCont;
	private String pressureRange;
	private String pressAccuracy;
	private String pressAccContro;
	private String presTrans;
	private String presEndFitting;
	private String presContValve;
	private String utilitiesSteamgen;
	private String utilityCapacity;
	private String utilityChiller;
	private String utilityStablizer;
	private String phMeasurement;
	private String phSensor;
	private String phSensorEntry;
	private String phLength;
	private String phTransmitterMake;
	private String phTemperatureComp;
	private String phAccuracy;
	private String phAccuracyCont;
	private String innoFlowml;
	private String utilityChillerCapac;
	private String utilAircompress;
	private String utilAircompressCapac;
	private String utilUps;
	private String utilWatercir;
	private String utilSteamMake;
	private String utilChillerType;
	private String utilAircompType;

	
	public String getUtilityChillerCapac() {
		return utilityChillerCapac;
	}
	public void setUtilityChillerCapac(String utilityChillerCapac) {
		this.utilityChillerCapac = utilityChillerCapac;
	}
	public String getUtilAircompress() {
		return utilAircompress;
	}
	public void setUtilAircompress(String utilAircompress) {
		this.utilAircompress = utilAircompress;
	}
	public String getUtilAircompressCapac() {
		return utilAircompressCapac;
	}
	public void setUtilAircompressCapac(String utilAircompressCapac) {
		this.utilAircompressCapac = utilAircompressCapac;
	}
	public String getUtilUps() {
		return utilUps;
	}
	public void setUtilUps(String utilUps) {
		this.utilUps = utilUps;
	}
	public String getUtilWatercir() {
		return utilWatercir;
	}
	public void setUtilWatercir(String utilWatercir) {
		this.utilWatercir = utilWatercir;
	}
	public String getInnoFlowml() {
		return innoFlowml;
	}
	public void setInnoFlowml(String innoFlowml) {
		this.innoFlowml = innoFlowml;
	}
	public Long getSeqInstruDet() {
		return seqInstruDet;
	}
	public void setSeqInstruDet(Long seqInstruDet) {
		this.seqInstruDet = seqInstruDet;
	}
	public Long getSeqWorkId() {
		return seqWorkId;
	}
	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}
	public String getPanelControl() {
		return panelControl;
	}
	public void setPanelControl(String panelControl) {
		this.panelControl = panelControl;
	}
	public String getContollerType() {
		return contollerType;
	}
	public void setContollerType(String contollerType) {
		this.contollerType = contollerType;
	}
	public String getControllerName() {
		return controllerName;
	}
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
	public String getControlPanel() {
		return controlPanel;
	}
	public void setControlPanel(String controlPanel) {
		this.controlPanel = controlPanel;
	}
	public String getSoftware() {
		return software;
	}
	public void setSoftware(String software) {
		this.software = software;
	}
	public String getScada() {
		return scada;
	}
	public void setScada(String scada) {
		this.scada = scada;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public String getSensorName() {
		return sensorName;
	}
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	public String getSensorEntry() {
		return sensorEntry;
	}
	public void setSensorEntry(String sensorEntry) {
		this.sensorEntry = sensorEntry;
	}
	public String getTransmiType() {
		return transmiType;
	}
	public void setTransmiType(String transmiType) {
		this.transmiType = transmiType;
	}
	public String getTransmiName() {
		return transmiName;
	}
	public void setTransmiName(String transmiName) {
		this.transmiName = transmiName;
	}
	public String getTempRange() {
		return tempRange;
	}
	public void setTempRange(String tempRange) {
		this.tempRange = tempRange;
	}
	public String getAccuracyMeas() {
		return accuracyMeas;
	}
	public void setAccuracyMeas(String accuracyMeas) {
		this.accuracyMeas = accuracyMeas;
	}
	public String getAccuracyCont() {
		return accuracyCont;
	}
	public void setAccuracyCont(String accuracyCont) {
		this.accuracyCont = accuracyCont;
	}
	public String getMotoDrive() {
		return motoDrive;
	}
	public void setMotoDrive(String motoDrive) {
		this.motoDrive = motoDrive;
	}
	public String getAccuRpm() {
		return accuRpm;
	}
	public void setAccuRpm(String accuRpm) {
		this.accuRpm = accuRpm;
	}
	public String getAccuRpmCont() {
		return accuRpmCont;
	}
	public void setAccuRpmCont(String accuRpmCont) {
		this.accuRpmCont = accuRpmCont;
	}
	public String getPowerHp() {
		return powerHp;
	}
	public void setPowerHp(String powerHp) {
		this.powerHp = powerHp;
	}
	public String getPeristaticPump() {
		return peristaticPump;
	}
	public void setPeristaticPump(String peristaticPump) {
		this.peristaticPump = peristaticPump;
	}
	public String getFlowRate() {
		return flowRate;
	}
	public void setFlowRate(String flowRate) {
		this.flowRate = flowRate;
	}
	public String getFlowRateType() {
		return flowRateType;
	}
	public void setFlowRateType(String flowRateType) {
		this.flowRateType = flowRateType;
	}
	public String getPhQuantity() {
		return phQuantity;
	}
	public void setPhQuantity(String phQuantity) {
		this.phQuantity = phQuantity;
	}
	public String getMounting() {
		return mounting;
	}
	public void setMounting(String mounting) {
		this.mounting = mounting;
	}
	public String getFoamControl() {
		return foamControl;
	}
	public void setFoamControl(String foamControl) {
		this.foamControl = foamControl;
	}
	public String getSensorCable() {
		return sensorCable;
	}
	public void setSensorCable(String sensorCable) {
		this.sensorCable = sensorCable;
	}
	public String getFoamEnrty() {
		return foamEnrty;
	}
	public void setFoamEnrty(String foamEnrty) {
		this.foamEnrty = foamEnrty;
	}
	public String getFoamPeristaltic() {
		return foamPeristaltic;
	}
	public void setFoamPeristaltic(String foamPeristaltic) {
		this.foamPeristaltic = foamPeristaltic;
	}
	public String getFoamPumpType() {
		return foamPumpType;
	}
	public void setFoamPumpType(String foamPumpType) {
		this.foamPumpType = foamPumpType;
	}
	public String getFoamPumpRate() {
		return foamPumpRate;
	}
	public void setFoamPumpRate(String foamPumpRate) {
		this.foamPumpRate = foamPumpRate;
	}
	public String getFoamPumpQuantity() {
		return foamPumpQuantity;
	}
	public void setFoamPumpQuantity(String foamPumpQuantity) {
		this.foamPumpQuantity = foamPumpQuantity;
	}
	public String getFoamPumpMount() {
		return foamPumpMount;
	}
	public void setFoamPumpMount(String foamPumpMount) {
		this.foamPumpMount = foamPumpMount;
	}
	public String getInnoAdd() {
		return innoAdd;
	}
	public void setInnoAdd(String innoAdd) {
		this.innoAdd = innoAdd;
	}
	public String getInnoPerist() {
		return innoPerist;
	}
	public void setInnoPerist(String innoPerist) {
		this.innoPerist = innoPerist;
	}
	public String getInnoFlowrate() {
		return innoFlowrate;
	}
	public void setInnoFlowrate(String innoFlowrate) {
		this.innoFlowrate = innoFlowrate;
	}
	public String getInnoVessel() {
		return innoVessel;
	}
	public void setInnoVessel(String innoVessel) {
		this.innoVessel = innoVessel;
	}
	public String getInnoType() {
		return innoType;
	}
	public void setInnoType(String innoType) {
		this.innoType = innoType;
	}
	public String getInnoQuantity() {
		return innoQuantity;
	}
	public void setInnoQuantity(String innoQuantity) {
		this.innoQuantity = innoQuantity;
	}
	public String getInnoMount() {
		return innoMount;
	}
	public void setInnoMount(String innoMount) {
		this.innoMount = innoMount;
	}
	public String getInnoCapacity() {
		return innoCapacity;
	}
	public void setInnoCapacity(String innoCapacity) {
		this.innoCapacity = innoCapacity;
	}
	public String getDoMeasurement() {
		return doMeasurement;
	}
	public void setDoMeasurement(String doMeasurement) {
		this.doMeasurement = doMeasurement;
	}
	public String getDoRange() {
		return doRange;
	}
	public void setDoRange(String doRange) {
		this.doRange = doRange;
	}
	public String getDoAccuMeasu() {
		return doAccuMeasu;
	}
	public void setDoAccuMeasu(String doAccuMeasu) {
		this.doAccuMeasu = doAccuMeasu;
	}
	public String getDoAccuCont() {
		return doAccuCont;
	}
	public void setDoAccuCont(String doAccuCont) {
		this.doAccuCont = doAccuCont;
	}
	public String getDoSensortype() {
		return doSensortype;
	}
	public void setDoSensortype(String doSensortype) {
		this.doSensortype = doSensortype;
	}
	public String getDoSensName() {
		return doSensName;
	}
	public void setDoSensName(String doSensName) {
		this.doSensName = doSensName;
	}
	public String getDoSensorEntry() {
		return doSensorEntry;
	}
	public void setDoSensorEntry(String doSensorEntry) {
		this.doSensorEntry = doSensorEntry;
	}
	public String getDoLength() {
		return doLength;
	}
	public void setDoLength(String doLength) {
		this.doLength = doLength;
	}
	public String getDoTransmitter() {
		return doTransmitter;
	}
	public void setDoTransmitter(String doTransmitter) {
		this.doTransmitter = doTransmitter;
	}
	public String getDoContType() {
		return doContType;
	}
	public void setDoContType(String doContType) {
		this.doContType = doContType;
	}
	public String getDoAircontDevice() {
		return doAircontDevice;
	}
	public void setDoAircontDevice(String doAircontDevice) {
		this.doAircontDevice = doAircontDevice;
	}
	public String getDoMembKit() {
		return doMembKit;
	}
	public void setDoMembKit(String doMembKit) {
		this.doMembKit = doMembKit;
	}
	public String getPresMeasuCont() {
		return presMeasuCont;
	}
	public void setPresMeasuCont(String presMeasuCont) {
		this.presMeasuCont = presMeasuCont;
	}
	public String getPressureRange() {
		return pressureRange;
	}
	public void setPressureRange(String pressureRange) {
		this.pressureRange = pressureRange;
	}
	public String getPressAccuracy() {
		return pressAccuracy;
	}
	public void setPressAccuracy(String pressAccuracy) {
		this.pressAccuracy = pressAccuracy;
	}
	public String getPressAccContro() {
		return pressAccContro;
	}
	public void setPressAccContro(String pressAccContro) {
		this.pressAccContro = pressAccContro;
	}
	public String getPresTrans() {
		return presTrans;
	}
	public void setPresTrans(String presTrans) {
		this.presTrans = presTrans;
	}
	public String getPresEndFitting() {
		return presEndFitting;
	}
	public void setPresEndFitting(String presEndFitting) {
		this.presEndFitting = presEndFitting;
	}
	public String getPresContValve() {
		return presContValve;
	}
	public void setPresContValve(String presContValve) {
		this.presContValve = presContValve;
	}
	public String getUtilitiesSteamgen() {
		return utilitiesSteamgen;
	}
	public void setUtilitiesSteamgen(String utilitiesSteamgen) {
		this.utilitiesSteamgen = utilitiesSteamgen;
	}
	public String getUtilityCapacity() {
		return utilityCapacity;
	}
	public void setUtilityCapacity(String utilityCapacity) {
		this.utilityCapacity = utilityCapacity;
	}
	public String getUtilityChiller() {
		return utilityChiller;
	}
	public void setUtilityChiller(String utilityChiller) {
		this.utilityChiller = utilityChiller;
	}
	public String getUtilityStablizer() {
		return utilityStablizer;
	}
	public void setUtilityStablizer(String utilityStablizer) {
		this.utilityStablizer = utilityStablizer;
	}
	public String getPhMeasurement() {
		return phMeasurement;
	}
	public void setPhMeasurement(String phMeasurement) {
		this.phMeasurement = phMeasurement;
	}
	public String getPhSensor() {
		return phSensor;
	}
	public void setPhSensor(String phSensor) {
		this.phSensor = phSensor;
	}
	public String getPhSensorEntry() {
		return phSensorEntry;
	}
	public void setPhSensorEntry(String phSensorEntry) {
		this.phSensorEntry = phSensorEntry;
	}
	public String getPhLength() {
		return phLength;
	}
	public void setPhLength(String phLength) {
		this.phLength = phLength;
	}
	public String getPhTransmitterMake() {
		return phTransmitterMake;
	}
	public void setPhTransmitterMake(String phTransmitterMake) {
		this.phTransmitterMake = phTransmitterMake;
	}
	public String getPhTemperatureComp() {
		return phTemperatureComp;
	}
	public void setPhTemperatureComp(String phTemperatureComp) {
		this.phTemperatureComp = phTemperatureComp;
	}
	public String getPhAccuracy() {
		return phAccuracy;
	}
	public void setPhAccuracy(String phAccuracy) {
		this.phAccuracy = phAccuracy;
	}
	public String getPhAccuracyCont() {
		return phAccuracyCont;
	}
	public void setPhAccuracyCont(String phAccuracyCont) {
		this.phAccuracyCont = phAccuracyCont;
	}
	public String getUtilSteamMake() {
		return utilSteamMake;
	}
	public void setUtilSteamMake(String utilSteamMake) {
		this.utilSteamMake = utilSteamMake;
	}
	public String getUtilChillerType() {
		return utilChillerType;
	}
	public void setUtilChillerType(String utilChillerType) {
		this.utilChillerType = utilChillerType;
	}
	public String getUtilAircompType() {
		return utilAircompType;
	}
	public void setUtilAircompType(String utilAircompType) {
		this.utilAircompType = utilAircompType;
	}
	
	
}
