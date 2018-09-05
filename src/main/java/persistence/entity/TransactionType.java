package persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="transactiontype")
public class TransactionType {
    @Column(name="transactiontypeid")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String transactionTypeId;
    @Column(name="transactiontypename")
    private String transactionTypeName;

    public TransactionType(String transactionTypeId, String transactionTypeName) {
        this.transactionTypeId = transactionTypeId;
        this.transactionTypeName = transactionTypeName;
    }

    public TransactionType() {
    }

    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionType that = (TransactionType) o;
        return Objects.equals(transactionTypeId, that.transactionTypeId) &&
                Objects.equals(transactionTypeName, that.transactionTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionTypeId, transactionTypeName);
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "transactionTypeId='" + transactionTypeId + '\'' +
                ", transactionTypeName='" + transactionTypeName + '\'' +
                '}';
    }
}
