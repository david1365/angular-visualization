package ir.caspco.visualization.body.context.domain;

import javax.persistence.*;
import java.io.Serializable;

import static ir.caspco.visualization.body.context.enums.Schema.SYSTEM_MANAGEMENT;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */


@Entity
@Table(name = BusinessTransactionLob.TABLE, schema = SYSTEM_MANAGEMENT)
public class BusinessTransactionLob implements Serializable {
    public static final String TABLE = "BIZ_TRANSACTION_LOG_LOB";

    private Long id;

    private byte[] inbound;
    private byte[] outbound;
    private byte[] faultDetails;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Lob
    public byte[] getInbound() {
        return inbound;
    }

    public void setInbound(byte[] inbound) {
        this.inbound = inbound;
    }

    @Lob
    public byte[] getOutbound() {
        return outbound;
    }

    public void setOutbound(byte[] outbound) {
        this.outbound = outbound;
    }

    @Lob
    public byte[] getFaultDetails() {
        return faultDetails;
    }

    public void setFaultDetails(byte[] faultDetails) {
        this.faultDetails = faultDetails;
    }
}

