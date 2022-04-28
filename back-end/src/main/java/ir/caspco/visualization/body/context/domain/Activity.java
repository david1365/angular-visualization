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
@Table(name = Activity.TABLE, schema = MG)
@Data
@EqualsAndHashCode
public class Activity {
    public static final String TABLE = "ACTIVITY";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = MG + ".SQ_" + TABLE + "_ID")
    @Column(name = "ID")
    public BigDecimal activityId;

    public java.sql.Date activationDate;
    public String channel;
    public String code;
    public String description;
    public java.sql.Date expirationDate;
    public String isActive;
    public String passwordProtected;
    public String title;
    public BigDecimal version;
    public java.sql.Date insertSysdate;
    public java.sql.Date updateSysdate;
    public String updateUser;
    public String insertUser;
    public java.sql.Timestamp timeStamp;
    public String limitationPatternCode;
    public String isFinancial;
    public String formName;
    public String password;
    public String otpLimitationPatternCode;
}

