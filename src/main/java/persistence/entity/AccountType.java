package persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "accounttype")
public class AccountType {

    @Column(name = "acctypeid")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String accTypeId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "accuserid")
    private AccUser accUser;

    @Column(name = "description")
    private String description;

    @Column(name = "closingday")
    private String closingDay;

    @Column(name = "accname")
    private String accName;

    @OneToMany(mappedBy = "accountType", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Balance> balances;

    @OneToMany(mappedBy = "accountType", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Item> items;



    public AccountType() {
    }

    public AccountType(
            String accTypeId, AccUser accUser, String description,
            String closingDay, String accName, List<Balance> balances,
            List<Item> items
    ) {
        this.accTypeId = accTypeId;
        this.accUser = accUser;
        this.description = description;
        this.closingDay = closingDay;
        this.accName = accName;
        this.balances = balances;
        this.items = items;
    }

    public String getAccTypeId() {
        return accTypeId;
    }

    public void setAccTypeId(String accTypeId) {
        this.accTypeId = accTypeId;
    }

    public AccUser getAccUser() {
        return accUser;
    }

    public void setAccUser(AccUser accUser) {
        this.accUser = accUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClosingDay() {
        return closingDay;
    }

    public void setClosingDay(String closingDay) {
        this.closingDay = closingDay;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accTypeId, that.accTypeId) &&
                Objects.equals(accUser, that.accUser) &&
                Objects.equals(description, that.description) &&
                Objects.equals(closingDay, that.closingDay) &&
                Objects.equals(accName, that.accName) &&
                Objects.equals(balances, that.balances) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accTypeId, accUser, description, closingDay, accName, balances, items);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accTypeId='" + accTypeId + '\'' +
                ", accUser=" + accUser +
                ", description='" + description + '\'' +
                ", closingDay='" + closingDay + '\'' +
                ", accName='" + accName + '\'' +
                ", balances=" + balances +
                ", items=" + items +
                '}';
    }
}
