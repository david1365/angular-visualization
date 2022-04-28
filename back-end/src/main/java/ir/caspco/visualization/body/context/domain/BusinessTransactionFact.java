package ir.caspco.visualization.body.context.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static ir.caspco.visualization.body.context.enums.Schema.SYSTEM_MANAGEMENT;


/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Entity
@Table(name = BusinessTransactionFact.TABLE, schema = SYSTEM_MANAGEMENT)
public class BusinessTransactionFact implements Serializable {
    public static final String TABLE = "BIZ_TRANSACTION_LOG_FACT";

    private Long id;

    private String jmsMessageId;
    private String correlationId;
    private Date requestDate;
    private Date responseDate;
    private String transactionUid;
    private Date coreId;
    private Integer processStatus;
    private Integer requestType;
    private Integer transactionType;

    private Integer executionTime;
    private Integer serviceExecutionTime;
    private Integer serviceId;
    private Integer activityId;
    private Integer branchId;
    private Integer channelId;
    private Integer currencyId;
    private Integer faultCodeId;
    private Integer machineCodeId;
    private Integer payloadSchemaId;
    private Integer referralFaultCodeId;
    private Integer versionId;
    private Integer gatewayIpId;
    private Integer clientVersionId;
    private Integer gatewayVersionId;
    private Integer coreVersionId;
    private Integer jmsUrlId;
    private Integer threadNameId;
    private Integer coreIpId;
    private Integer uiVersionId;
    private Integer messageVersionId;

    private String username;
    private String endUsername;

    private String clientIp;
    private String senderFormId;
    private String referralAcceptors;


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BIZ_TRANSACTION_LOG_FACT")
    @SequenceGenerator(name = "SQ_BIZ_TRANSACTION_LOG_FACT", sequenceName = SYSTEM_MANAGEMENT + ".SQ_BIZ_TRANSACTION_LOG_FACT")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "JMS_MESSAGE_ID")
    public String getJmsMessageId() {
        return jmsMessageId;
    }

    public void setJmsMessageId(String jmsMessageId) {
        this.jmsMessageId = jmsMessageId;
    }

    @Column(name = "CORRELATION_ID")
    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @Column(name = "REQUEST_DATE")
    @Temporal(TemporalType.TIME)
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Column(name = "RESPONSE_DATE")
    @Temporal(TemporalType.TIME)
    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    @Column(name = "TRANSACTION_UID")
    public String getTransactionUid() {
        return transactionUid;
    }

    public void setTransactionUid(String transactionUid) {
        this.transactionUid = transactionUid;
    }

    @Column(name = "CORE_ID")
    @Temporal(TemporalType.TIME)
    public Date getCoreId() {
        return coreId;
    }

    public void setCoreId(Date coreId) {
        this.coreId = coreId;
    }


    @Column(name = "EXECUTION_TIME")
    public Integer getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    @Column(name = "SERVICE_EXECUTION_TIME")
    public Integer getServiceExecutionTime() {
        return serviceExecutionTime;
    }

    public void setServiceExecutionTime(Integer serviceExecutionTime) {
        this.serviceExecutionTime = serviceExecutionTime;
    }

    @Column(name = "SERVICE_ID")
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Column(name = "ACTIVITY_ID")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Column(name = "BRANCH_ID")
    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    @Column(name = "CHANNEL_ID")
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Column(name = "CURRENCY_ID")
    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    @Column(name = "FAULT_CODE_ID")
    public Integer getFaultCodeId() {
        return faultCodeId;
    }

    public void setFaultCodeId(Integer faultCodeId) {
        this.faultCodeId = faultCodeId;
    }

    @Column(name = "MACHINE_CODE_ID")
    public Integer getMachineCodeId() {
        return machineCodeId;
    }

    public void setMachineCodeId(Integer machineCodeId) {
        this.machineCodeId = machineCodeId;
    }

    @Column(name = "PAYLOAD_SCHEMA_ID")
    public Integer getPayloadSchemaId() {
        return payloadSchemaId;
    }

    public void setPayloadSchemaId(Integer payloadSchemaId) {
        this.payloadSchemaId = payloadSchemaId;
    }

    @Column(name = "PROCESS_STATUS")
    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    @Column(name = "REFERRAL_FAULT_CODE_ID")
    public Integer getReferralFaultCodeId() {
        return referralFaultCodeId;
    }

    public void setReferralFaultCodeId(Integer referralFaultCodeId) {
        this.referralFaultCodeId = referralFaultCodeId;
    }

    @Column(name = "REQUEST_TYPE")
    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    @Column(name = "TRANSACTION_TYPE")
    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    @Column(name = "VERSION_ID")
    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    @Column(name = "GW_IP_ID")
    public Integer getGatewayIpId() {
        return gatewayIpId;
    }

    public void setGatewayIpId(Integer gatewayIpId) {
        this.gatewayIpId = gatewayIpId;
    }

    @Column(name = "CLIENT_VERSION_ID")
    public Integer getClientVersionId() {
        return clientVersionId;
    }

    public void setClientVersionId(Integer clientVersionId) {
        this.clientVersionId = clientVersionId;
    }

    @Column(name = "GW_VERSION_ID")
    public Integer getGatewayVersionId() {
        return gatewayVersionId;
    }

    public void setGatewayVersionId(Integer gatewayVersionId) {
        this.gatewayVersionId = gatewayVersionId;
    }

    @Column(name = "CORE_VERSION_ID")
    public Integer getCoreVersionId() {
        return coreVersionId;
    }

    public void setCoreVersionId(Integer coreVersionId) {
        this.coreVersionId = coreVersionId;
    }

    @Column(name = "JMS_URL_ID")
    public Integer getJmsUrlId() {
        return jmsUrlId;
    }

    public void setJmsUrlId(Integer jmsUrlId) {
        this.jmsUrlId = jmsUrlId;
    }

    @Column(name = "THREAD_NAME_ID")
    public Integer getThreadNameId() {
        return threadNameId;
    }

    public void setThreadNameId(Integer threadNameId) {
        this.threadNameId = threadNameId;
    }

    @Column(name = "CORE_IP_ID")
    public Integer getCoreIpId() {
        return coreIpId;
    }

    public void setCoreIpId(Integer coreIpId) {
        this.coreIpId = coreIpId;
    }

    @Column(name = "UI_VERSION_ID")
    public Integer getUiVersionId() {
        return uiVersionId;
    }

    public void setUiVersionId(Integer uiVersionId) {
        this.uiVersionId = uiVersionId;
    }

    @Column(name = "MESSAGE_VERSION_ID")
    public Integer getMessageVersionId() {
        return messageVersionId;
    }

    public void setMessageVersionId(Integer messageVersionId) {
        this.messageVersionId = messageVersionId;
    }

    @Column(name = "CLIENT_IP")
    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    @Column(name = "SENDER_FROM_ID")
    public String getSenderFormId() {
        return senderFormId;
    }

    public void setSenderFormId(String senderFormId) {
        this.senderFormId = senderFormId;
    }

    @Column(name = "REFERRAL_ACCEPTORS")
    public String getReferralAcceptors() {
        return referralAcceptors;
    }

    public void setReferralAcceptors(String referralAcceptors) {
        this.referralAcceptors = referralAcceptors;
    }


    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "END_USERNAME")
    public String getEndUsername() {
        return endUsername;
    }

    public void setEndUsername(String endUsername) {
        this.endUsername = endUsername;
    }

}


