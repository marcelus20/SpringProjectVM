package persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item {
    @Column(name = "itemid")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String itemId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "transactiontypeid")
    private TransactionType transactionType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "acctypeid")
    private AccountType accountType;

    @Column(name = "description")
    private String description;

    @Column(name = "itemvalue")
    private Float itemValue;

    @Column(name = "purchaseDate")
    private Date purchaseDate;


    public Item() {
    }

    public Item(String itemId, TransactionType transactionType, AccountType accountType, String description, Float itemValue, Date purchaseDate) {
        this.itemId = itemId;
        this.transactionType = transactionType;
        this.accountType = accountType;
        this.description = description;
        this.itemValue = itemValue;
        this.purchaseDate = purchaseDate;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getItemValue() {
        return itemValue;
    }

    public void setItemValue(Float itemValue) {
        this.itemValue = itemValue;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) &&
                Objects.equals(transactionType, item.transactionType) &&
                Objects.equals(accountType, item.accountType) &&
                Objects.equals(description, item.description) &&
                Objects.equals(itemValue, item.itemValue) &&
                Objects.equals(purchaseDate, item.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, transactionType, accountType, description, itemValue, purchaseDate);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", transactionType=" + transactionType +
                ", accountType=" + accountType +
                ", description='" + description + '\'' +
                ", itemValue=" + itemValue +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
