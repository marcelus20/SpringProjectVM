package persistence.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    private Set<Balance> balances;

    @OneToMany(mappedBy = "accountType", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Item> items;



    public AccountType() {
    }

    public AccountType(
            String accTypeId, AccUser accUser, String description,
            String closingDay, String accName, Set<Balance> balances,
            Set<Item> items
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

    public Set<Balance> getBalances() {
        return balances;
    }

    public void setBalances(Set<Balance> balances) {
        this.balances = balances;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return new EqualsBuilder().append(accTypeId, that.accTypeId)
                .append(accUser, that.accUser)
                .append(description, that.description)
                .append(closingDay, that.closingDay)
                .append(accName, that.accName)
                .append(balances, that.balances)
                .append(items, that.items).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17,31)
                .append(accTypeId)
                .append(accUser)
                .append(description)
                .append(closingDay)
                .append(accName)
                .append(balances)
                .append(items).build();
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accTypeId='" + accTypeId + '\'' +
                ", description='" + description + '\'' +
                ", closingDay='" + closingDay + '\'' +
                ", accName='" + accName + '\'' +
                ", balances=" + balances +
                ", items=" + items +
                '}';
    }
}
