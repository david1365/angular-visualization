package ir.caspco.visualization.body.context.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

import static ir.caspco.visualization.body.context.enums.Schema.MG;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Entity
@Table(name = ActivityLog.TABLE, schema = MG)
@Data
@EqualsAndHashCode
public class ActivityLog {
    public static final String TABLE = "ACTIVITY_LOG";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = MG + ".SQ_" + TABLE + "_ID")
    @Column(name = "ID")
    public BigDecimal id;

    public String activityCode;
    public BigDecimal amount;
    public java.sql.Date businessDate;
    public String channelCode;
//    public String username;
    public BigDecimal version;
//    public java.sql.Date insertSysDate;
//    public java.sql.Date updateSysDate;
    public String updateUser;
    public String insertUser;
    public java.sql.Timestamp timeStamp;
    public String signedCertificate;
    public String trackingId;
    public BigDecimal executionTime;
    public String failureReason;
    public String status;
    public String methodName;
    public String remoteIpAddress;
    public String customerNo;
    public String failureReasonBlob;
    public String failureMessage;
}