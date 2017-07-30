package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SciInstruDetails entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_INSTRU_DETAILS", schema = "SCIGENICS",uniqueConstraints = {})
public class SciInstruDetails implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public SciInstruDetails() {
	}

	/** minimal constructor */
	public SciInstruDetails(Long seqInstruDet) {
		this.seqInstruDet = seqInstruDet;
	}

	/** full constructor */
	public SciInstruDetails(Long seqInstruDet, Long seqWorkId,
			String panelControl, String contollerType, String controllerName,
			String controlPanel, String software, String scada,
			String sensorType, String sensorName, String sensorEntry,
			String transmiType, String transmiName, String tempRange,
			String accuracyMeas, String accuracyCont, String motoDrive,
			String accuRpm, String accuRpmCont, String powerHp,
			String peristaticPump, String flowRate, String flowRateType,
			String phQuantity, String mounting, String foamControl,
			String sensorCable, String foamEnrty, String foamPeristaltic,
			String foamPumpType, String foamPumpRate, String foamPumpQuantity,
			String foamPumpMount, String innoAdd, String innoPerist,
			String innoFlowrate, String innoVessel, String innoType,
			String innoQuantity, String innoMount, String innoCapacity,
			String doMeasurement, String doRange, String doAccuMeasu,
			String doAccuCont, String doSensortype, String doSensName,
			String doSensorEntry, String doLength, String doTransmitter,
			String doContType, String doAircontDevice, String doMembKit,
			String presMeasuCont, String pressureRange, String pressAccuracy,
			String pressAccContro, String presTrans, String presEndFitting,
			String presContValve, String utilitiesSteamgen,
			String utilityCapacity, String utilityChiller,
			String utilityStablizer, String phMeasurement, String phSensor,
			String phSensorEntry, String phLength, String phTransmitterMake,
			String phTemperatureComp, String phAccuracy, String phAccuracyCont,
			String innoFlowml, String utilityChillerCapac,
			String utilAircompress, String utilAircompressCapac,
			String utilUps, String utilWatercir, String utilSteamMake,
			String utilChillerType, String utilAircompType) {
		this.seqInstruDet = seqInstruDet;
		this.seqWorkId = seqWorkId;
		this.panelControl = panelControl;
		this.contollerType = contollerType;
		this.controllerName = controllerName;
		this.controlPanel = controlPanel;
		this.software = software;
		this.scada = scada;
		this.sensorType = sensorType;
		this.sensorName = sensorName;
		this.sensorEntry = sensorEntry;
		this.transmiType = transmiType;
		this.transmiName = transmiName;
		this.tempRange = tempRange;
		this.accuracyMeas = accuracyMeas;
		this.accuracyCont = accuracyCont;
		this.motoDrive = motoDrive;
		this.accuRpm = accuRpm;
		this.accuRpmCont = accuRpmCont;
		this.powerHp = powerHp;
		this.peristaticPump = peristaticPump;
		this.flowRate = flowRate;
		this.flowRateType = flowRateType;
		this.phQuantity = phQuantity;
		this.mounting = mounting;
		this.foamControl = foamControl;
		this.sensorCable = sensorCable;
		this.foamEnrty = foamEnrty;
		this.foamPeristaltic = foamPeristaltic;
		this.foamPumpType = foamPumpType;
		this.foamPumpRate = foamPumpRate;
		this.foamPumpQuantity = foamPumpQuantity;
		this.foamPumpMount = foamPumpMount;
		this.innoAdd = innoAdd;
		this.innoPerist = innoPerist;
		this.innoFlowrate = innoFlowrate;
		this.innoVessel = innoVessel;
		this.innoType = innoType;
		this.innoQuantity = innoQuantity;
		this.innoMount = innoMount;
		this.innoCapacity = innoCapacity;
		this.doMeasurement = doMeasurement;
		this.doRange = doRange;
		this.doAccuMeasu = doAccuMeasu;
		this.doAccuCont = doAccuCont;
		this.doSensortype = doSensortype;
		this.doSensName = doSensName;
		this.doSensorEntry = doSensorEntry;
		this.doLength = doLength;
		this.doTransmitter = doTransmitter;
		this.doContType = doContType;
		this.doAircontDevice = doAircontDevice;
		this.doMembKit = doMembKit;
		this.presMeasuCont = presMeasuCont;
		this.pressureRange = pressureRange;
		this.pressAccuracy = pressAccuracy;
		this.pressAccContro = pressAccContro;
		this.presTrans = presTrans;
		this.presEndFitting = presEndFitting;
		this.presContValve = presContValve;
		this.utilitiesSteamgen = utilitiesSteamgen;
		this.utilityCapacity = utilityCapacity;
		this.utilityChiller = utilityChiller;
		this.utilityStablizer = utilityStablizer;
		this.phMeasurement = phMeasurement;
		this.phSensor = phSensor;
		this.phSensorEntry = phSensorEntry;
		this.phLength = phLength;
		this.phTransmitterMake = phTransmitterMake;
		this.phTemperatureComp = phTemperatureComp;
		this.phAccuracy = phAccuracy;
		this.phAccuracyCont = phAccuracyCont;
		this.innoFlowml = innoFlowml;
		this.utilityChillerCapac = utilityChillerCapac;
		this.utilAircompress = utilAircompress;
		this.utilAircompressCapac = utilAircompressCapac;
		this.utilUps = utilUps;
		this.utilWatercir = utilWatercir;
		this.utilSteamMake = utilSteamMake;
		this.utilChillerType = utilChillerType;
		this.utilAircompType = utilAircompType;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_INSTRU_DET", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	
	
	public Long getSeqInstruDet() {
		return this.seqInstruDet;
	}

	public void setSeqInstruDet(Long seqInstruDet) {
		this.seqInstruDet = seqInstruDet;
	}

	@Column(name = "SEQ_WORK_ID", precision = 22, scale = 0)
	public Long getSeqWorkId() {
		return this.seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	@Column(name = "PANEL_CONTROL", length = 100)
	public String getPanelControl() {
		return this.panelControl;
	}

	public void setPanelControl(String panelControl) {
		this.panelControl = panelControl;
	}

	@Column(name = "CONTOLLER_TYPE", length = 100)
	public String getContollerType() {
		return this.contollerType;
	}

	public void setContollerType(String contollerType) {
		this.contollerType = contollerType;
	}

	@Column(name = "CONTROLLER_NAME", length = 100)
	public String getControllerName() {
		return this.controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	@Column(name = "CONTROL_PANEL", length = 100)
	public String getControlPanel() {
		return this.controlPanel;
	}

	public void setControlPanel(String controlPanel) {
		this.controlPanel = controlPanel;
	}

	@Column(name = "SOFTWARE", length = 100)
	public String getSoftware() {
		return this.software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	@Column(name = "SCADA", length = 100)
	public String getScada() {
		return this.scada;
	}

	public void setScada(String scada) {
		this.scada = scada;
	}

	@Column(name = "SENSOR_TYPE", length = 100)
	public String getSensorType() {
		return this.sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	@Column(name = "SENSOR_NAME", length = 100)
	public String getSensorName() {
		return this.sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	@Column(name = "SENSOR_ENTRY", length = 100)
	public String getSensorEntry() {
		return this.sensorEntry;
	}

	public void setSensorEntry(String sensorEntry) {
		this.sensorEntry = sensorEntry;
	}

	@Column(name = "TRANSMI_TYPE", length = 100)
	public String getTransmiType() {
		return this.transmiType;
	}

	public void setTransmiType(String transmiType) {
		this.transmiType = transmiType;
	}

	@Column(name = "TRANSMI_NAME", length = 100)
	public String getTransmiName() {
		return this.transmiName;
	}

	public void setTransmiName(String transmiName) {
		this.transmiName = transmiName;
	}

	@Column(name = "TEMP_RANGE", length = 1000)
	public String getTempRange() {
		return this.tempRange;
	}

	public void setTempRange(String tempRange) {
		this.tempRange = tempRange;
	}

	@Column(name = "ACCURACY_MEAS", length = 100)
	public String getAccuracyMeas() {
		return this.accuracyMeas;
	}

	public void setAccuracyMeas(String accuracyMeas) {
		this.accuracyMeas = accuracyMeas;
	}

	@Column(name = "ACCURACY_CONT", length = 100)
	public String getAccuracyCont() {
		return this.accuracyCont;
	}

	public void setAccuracyCont(String accuracyCont) {
		this.accuracyCont = accuracyCont;
	}

	@Column(name = "MOTO_DRIVE", length = 100)
	public String getMotoDrive() {
		return this.motoDrive;
	}

	public void setMotoDrive(String motoDrive) {
		this.motoDrive = motoDrive;
	}

	@Column(name = "ACCU_RPM", length = 100)
	public String getAccuRpm() {
		return this.accuRpm;
	}

	public void setAccuRpm(String accuRpm) {
		this.accuRpm = accuRpm;
	}

	@Column(name = "ACCU_RPM_CONT", length = 100)
	public String getAccuRpmCont() {
		return this.accuRpmCont;
	}

	public void setAccuRpmCont(String accuRpmCont) {
		this.accuRpmCont = accuRpmCont;
	}

	@Column(name = "POWER_HP", length = 100)
	public String getPowerHp() {
		return this.powerHp;
	}

	public void setPowerHp(String powerHp) {
		this.powerHp = powerHp;
	}

	@Column(name = "PERISTATIC_PUMP", length = 100)
	public String getPeristaticPump() {
		return this.peristaticPump;
	}

	public void setPeristaticPump(String peristaticPump) {
		this.peristaticPump = peristaticPump;
	}

	@Column(name = "FLOW_RATE", length = 100)
	public String getFlowRate() {
		return this.flowRate;
	}

	public void setFlowRate(String flowRate) {
		this.flowRate = flowRate;
	}

	@Column(name = "FLOW_RATE_TYPE", length = 100)
	public String getFlowRateType() {
		return this.flowRateType;
	}

	public void setFlowRateType(String flowRateType) {
		this.flowRateType = flowRateType;
	}

	@Column(name = "PH_QUANTITY", length = 100)
	public String getPhQuantity() {
		return this.phQuantity;
	}

	public void setPhQuantity(String phQuantity) {
		this.phQuantity = phQuantity;
	}

	@Column(name = "MOUNTING", length = 50)
	public String getMounting() {
		return this.mounting;
	}

	public void setMounting(String mounting) {
		this.mounting = mounting;
	}

	@Column(name = "FOAM_CONTROL", length = 100)
	public String getFoamControl() {
		return this.foamControl;
	}

	public void setFoamControl(String foamControl) {
		this.foamControl = foamControl;
	}

	@Column(name = "SENSOR_CABLE", length = 100)
	public String getSensorCable() {
		return this.sensorCable;
	}

	public void setSensorCable(String sensorCable) {
		this.sensorCable = sensorCable;
	}

	@Column(name = "FOAM_ENRTY", length = 100)
	public String getFoamEnrty() {
		return this.foamEnrty;
	}

	public void setFoamEnrty(String foamEnrty) {
		this.foamEnrty = foamEnrty;
	}

	@Column(name = "FOAM_PERISTALTIC", length = 100)
	public String getFoamPeristaltic() {
		return this.foamPeristaltic;
	}

	public void setFoamPeristaltic(String foamPeristaltic) {
		this.foamPeristaltic = foamPeristaltic;
	}

	@Column(name = "FOAM_PUMP_TYPE", length = 100)
	public String getFoamPumpType() {
		return this.foamPumpType;
	}

	public void setFoamPumpType(String foamPumpType) {
		this.foamPumpType = foamPumpType;
	}

	@Column(name = "FOAM_PUMP_RATE", length = 100)
	public String getFoamPumpRate() {
		return this.foamPumpRate;
	}

	public void setFoamPumpRate(String foamPumpRate) {
		this.foamPumpRate = foamPumpRate;
	}

	@Column(name = "FOAM_PUMP_QUANTITY", length = 100)
	public String getFoamPumpQuantity() {
		return this.foamPumpQuantity;
	}

	public void setFoamPumpQuantity(String foamPumpQuantity) {
		this.foamPumpQuantity = foamPumpQuantity;
	}

	@Column(name = "FOAM_PUMP_MOUNT", length = 100)
	public String getFoamPumpMount() {
		return this.foamPumpMount;
	}

	public void setFoamPumpMount(String foamPumpMount) {
		this.foamPumpMount = foamPumpMount;
	}

	@Column(name = "INNO_ADD", length = 100)
	public String getInnoAdd() {
		return this.innoAdd;
	}

	public void setInnoAdd(String innoAdd) {
		this.innoAdd = innoAdd;
	}

	@Column(name = "INNO_PERIST", length = 100)
	public String getInnoPerist() {
		return this.innoPerist;
	}

	public void setInnoPerist(String innoPerist) {
		this.innoPerist = innoPerist;
	}

	@Column(name = "INNO_FLOWRATE", length = 100)
	public String getInnoFlowrate() {
		return this.innoFlowrate;
	}

	public void setInnoFlowrate(String innoFlowrate) {
		this.innoFlowrate = innoFlowrate;
	}

	@Column(name = "INNO_VESSEL", length = 100)
	public String getInnoVessel() {
		return this.innoVessel;
	}

	public void setInnoVessel(String innoVessel) {
		this.innoVessel = innoVessel;
	}

	@Column(name = "INNO_TYPE", length = 100)
	public String getInnoType() {
		return this.innoType;
	}

	public void setInnoType(String innoType) {
		this.innoType = innoType;
	}

	@Column(name = "INNO_QUANTITY", length = 100)
	public String getInnoQuantity() {
		return this.innoQuantity;
	}

	public void setInnoQuantity(String innoQuantity) {
		this.innoQuantity = innoQuantity;
	}

	@Column(name = "INNO_MOUNT", length = 100)
	public String getInnoMount() {
		return this.innoMount;
	}

	public void setInnoMount(String innoMount) {
		this.innoMount = innoMount;
	}

	@Column(name = "INNO_CAPACITY", length = 100)
	public String getInnoCapacity() {
		return this.innoCapacity;
	}

	public void setInnoCapacity(String innoCapacity) {
		this.innoCapacity = innoCapacity;
	}

	@Column(name = "DO_MEASUREMENT", length = 100)
	public String getDoMeasurement() {
		return this.doMeasurement;
	}

	public void setDoMeasurement(String doMeasurement) {
		this.doMeasurement = doMeasurement;
	}

	@Column(name = "DO_RANGE", length = 100)
	public String getDoRange() {
		return this.doRange;
	}

	public void setDoRange(String doRange) {
		this.doRange = doRange;
	}

	@Column(name = "DO_ACCU_MEASU", length = 100)
	public String getDoAccuMeasu() {
		return this.doAccuMeasu;
	}

	public void setDoAccuMeasu(String doAccuMeasu) {
		this.doAccuMeasu = doAccuMeasu;
	}

	@Column(name = "DO_ACCU_CONT", length = 100)
	public String getDoAccuCont() {
		return this.doAccuCont;
	}

	public void setDoAccuCont(String doAccuCont) {
		this.doAccuCont = doAccuCont;
	}

	@Column(name = "DO_SENSORTYPE", length = 100)
	public String getDoSensortype() {
		return this.doSensortype;
	}

	public void setDoSensortype(String doSensortype) {
		this.doSensortype = doSensortype;
	}

	@Column(name = "DO_SENS_NAME", length = 100)
	public String getDoSensName() {
		return this.doSensName;
	}

	public void setDoSensName(String doSensName) {
		this.doSensName = doSensName;
	}

	@Column(name = "DO_SENSOR_ENTRY", length = 100)
	public String getDoSensorEntry() {
		return this.doSensorEntry;
	}

	public void setDoSensorEntry(String doSensorEntry) {
		this.doSensorEntry = doSensorEntry;
	}

	@Column(name = "DO_LENGTH", length = 100)
	public String getDoLength() {
		return this.doLength;
	}

	public void setDoLength(String doLength) {
		this.doLength = doLength;
	}

	@Column(name = "DO_TRANSMITTER", length = 100)
	public String getDoTransmitter() {
		return this.doTransmitter;
	}

	public void setDoTransmitter(String doTransmitter) {
		this.doTransmitter = doTransmitter;
	}

	@Column(name = "DO_CONT_TYPE", length = 100)
	public String getDoContType() {
		return this.doContType;
	}

	public void setDoContType(String doContType) {
		this.doContType = doContType;
	}

	@Column(name = "DO_AIRCONT_DEVICE", length = 100)
	public String getDoAircontDevice() {
		return this.doAircontDevice;
	}

	public void setDoAircontDevice(String doAircontDevice) {
		this.doAircontDevice = doAircontDevice;
	}

	@Column(name = "DO_MEMB_KIT", length = 100)
	public String getDoMembKit() {
		return this.doMembKit;
	}

	public void setDoMembKit(String doMembKit) {
		this.doMembKit = doMembKit;
	}

	@Column(name = "PRES_MEASU_CONT", length = 100)
	public String getPresMeasuCont() {
		return this.presMeasuCont;
	}

	public void setPresMeasuCont(String presMeasuCont) {
		this.presMeasuCont = presMeasuCont;
	}

	@Column(name = "PRESSURE_RANGE", length = 100)
	public String getPressureRange() {
		return this.pressureRange;
	}

	public void setPressureRange(String pressureRange) {
		this.pressureRange = pressureRange;
	}

	@Column(name = "PRESS_ACCURACY", length = 100)
	public String getPressAccuracy() {
		return this.pressAccuracy;
	}

	public void setPressAccuracy(String pressAccuracy) {
		this.pressAccuracy = pressAccuracy;
	}

	@Column(name = "PRESS_ACC_CONTRO", length = 100)
	public String getPressAccContro() {
		return this.pressAccContro;
	}

	public void setPressAccContro(String pressAccContro) {
		this.pressAccContro = pressAccContro;
	}

	@Column(name = "PRES_TRANS", length = 100)
	public String getPresTrans() {
		return this.presTrans;
	}

	public void setPresTrans(String presTrans) {
		this.presTrans = presTrans;
	}

	@Column(name = "PRES_END_FITTING", length = 100)
	public String getPresEndFitting() {
		return this.presEndFitting;
	}

	public void setPresEndFitting(String presEndFitting) {
		this.presEndFitting = presEndFitting;
	}

	@Column(name = "PRES_CONT_VALVE", length = 100)
	public String getPresContValve() {
		return this.presContValve;
	}

	public void setPresContValve(String presContValve) {
		this.presContValve = presContValve;
	}

	@Column(name = "UTILITIES_STEAMGEN", length = 100)
	public String getUtilitiesSteamgen() {
		return this.utilitiesSteamgen;
	}

	public void setUtilitiesSteamgen(String utilitiesSteamgen) {
		this.utilitiesSteamgen = utilitiesSteamgen;
	}

	@Column(name = "UTILITY_CAPACITY", length = 100)
	public String getUtilityCapacity() {
		return this.utilityCapacity;
	}

	public void setUtilityCapacity(String utilityCapacity) {
		this.utilityCapacity = utilityCapacity;
	}

	@Column(name = "UTILITY_CHILLER", length = 100)
	public String getUtilityChiller() {
		return this.utilityChiller;
	}

	public void setUtilityChiller(String utilityChiller) {
		this.utilityChiller = utilityChiller;
	}

	@Column(name = "UTILITY_STABLIZER", length = 100)
	public String getUtilityStablizer() {
		return this.utilityStablizer;
	}

	public void setUtilityStablizer(String utilityStablizer) {
		this.utilityStablizer = utilityStablizer;
	}

	@Column(name = "PH_MEASUREMENT", length = 100)
	public String getPhMeasurement() {
		return this.phMeasurement;
	}

	public void setPhMeasurement(String phMeasurement) {
		this.phMeasurement = phMeasurement;
	}

	@Column(name = "PH_SENSOR", length = 1000)
	public String getPhSensor() {
		return this.phSensor;
	}

	public void setPhSensor(String phSensor) {
		this.phSensor = phSensor;
	}

	@Column(name = "PH_SENSOR_ENTRY", length = 100)
	public String getPhSensorEntry() {
		return this.phSensorEntry;
	}

	public void setPhSensorEntry(String phSensorEntry) {
		this.phSensorEntry = phSensorEntry;
	}

	@Column(name = "PH_LENGTH", length = 1000)
	public String getPhLength() {
		return this.phLength;
	}

	public void setPhLength(String phLength) {
		this.phLength = phLength;
	}

	@Column(name = "PH_TRANSMITTER_MAKE", length = 1000)
	public String getPhTransmitterMake() {
		return this.phTransmitterMake;
	}

	public void setPhTransmitterMake(String phTransmitterMake) {
		this.phTransmitterMake = phTransmitterMake;
	}

	@Column(name = "PH_TEMPERATURE_COMP", length = 100)
	public String getPhTemperatureComp() {
		return this.phTemperatureComp;
	}

	public void setPhTemperatureComp(String phTemperatureComp) {
		this.phTemperatureComp = phTemperatureComp;
	}

	@Column(name = "PH_ACCURACY", length = 100)
	public String getPhAccuracy() {
		return this.phAccuracy;
	}

	public void setPhAccuracy(String phAccuracy) {
		this.phAccuracy = phAccuracy;
	}

	@Column(name = "PH_ACCURACY_CONT", length = 100)
	public String getPhAccuracyCont() {
		return this.phAccuracyCont;
	}

	public void setPhAccuracyCont(String phAccuracyCont) {
		this.phAccuracyCont = phAccuracyCont;
	}

	@Column(name = "INNO_FLOWML", length = 100)
	public String getInnoFlowml() {
		return this.innoFlowml;
	}

	public void setInnoFlowml(String innoFlowml) {
		this.innoFlowml = innoFlowml;
	}

	@Column(name = "UTILITY_CHILLER_CAPAC", length = 100)
	public String getUtilityChillerCapac() {
		return this.utilityChillerCapac;
	}

	public void setUtilityChillerCapac(String utilityChillerCapac) {
		this.utilityChillerCapac = utilityChillerCapac;
	}

	@Column(name = "UTIL_AIRCOMPRESS", length = 100)
	public String getUtilAircompress() {
		return this.utilAircompress;
	}

	public void setUtilAircompress(String utilAircompress) {
		this.utilAircompress = utilAircompress;
	}

	@Column(name = "UTIL_AIRCOMPRESS_CAPAC", length = 100)
	public String getUtilAircompressCapac() {
		return this.utilAircompressCapac;
	}

	public void setUtilAircompressCapac(String utilAircompressCapac) {
		this.utilAircompressCapac = utilAircompressCapac;
	}

	@Column(name = "UTIL_UPS", length = 100)
	public String getUtilUps() {
		return this.utilUps;
	}

	public void setUtilUps(String utilUps) {
		this.utilUps = utilUps;
	}

	@Column(name = "UTIL_WATERCIR", length = 100)
	public String getUtilWatercir() {
		return this.utilWatercir;
	}

	public void setUtilWatercir(String utilWatercir) {
		this.utilWatercir = utilWatercir;
	}

	@Column(name = "UTIL_STEAM_MAKE", length = 100)
	public String getUtilSteamMake() {
		return this.utilSteamMake;
	}

	public void setUtilSteamMake(String utilSteamMake) {
		this.utilSteamMake = utilSteamMake;
	}

	@Column(name = "UTIL_CHILLER_TYPE", length = 100)
	public String getUtilChillerType() {
		return this.utilChillerType;
	}

	public void setUtilChillerType(String utilChillerType) {
		this.utilChillerType = utilChillerType;
	}

	@Column(name = "UTIL_AIRCOMP_TYPE", length = 100)
	public String getUtilAircompType() {
		return this.utilAircompType;
	}

	public void setUtilAircompType(String utilAircompType) {
		this.utilAircompType = utilAircompType;
	}

}