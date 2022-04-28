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
public class ActivityLogData {
    public static final String TABLE = "ACTIVITY_LOG_DATA";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = MG + ".SQ_" + TABLE + "_ID")
    @Column(name = "ID")
    public BigDecimal Id;

    public String trackingId;
    public String inputData;
    public String outputData;
    public String insertUser;
    public String updateUser;
    public java.sql.Date insertSysdate;
    public java.sql.Date updateSysdate;
    public java.sql.Timestamp timeStamp;
    public BigDecimal version;
    public String userName;
    public String customerId;
    public String channelCode;
    public String messageName;
    public BigDecimal executionTime;
}