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
@Table(name = BusinessTransactionDic.TABLE, schema = SYSTEM_MANAGEMENT)
public class BusinessTransactionDic implements Serializable {
    public static final String TABLE = "BIZ_TRANSACTION_LOG_DIC";

    private Integer id;
    private String dictype;
    private String name;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "biz_transaction_dic_sequence")
    @SequenceGenerator(name = "biz_transaction_dic_sequence", sequenceName = SYSTEM_MANAGEMENT + ".SQ_BIZ_TRANSACTION_LOG_DIC")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "DICTYPE")
    public String getDictype() {
        return dictype;
    }

    public void setDictype(String dictype) {
        this.dictype = dictype;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
