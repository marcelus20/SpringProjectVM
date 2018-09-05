package persistence.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name="balance")
public class Balance {
    @Column(name="balanceid")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String balanceId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "acctypeid")
    private AccountType accountType;

    @Column(name = "calcbalance")
    private Float calcBalance;

    @Column(name = "realbalance")
    private Float realBalance;

    @Column(name = "balancedate")
    private Date balanceDate;

    public Balance() {
    }

    public Balance(String balanceId, AccountType accountType, Float calcBalance, Float realBalance, Date balanceDate) {
        this.balanceId = balanceId;
        this.accountType = accountType;
        this.calcBalance = calcBalance;
        this.realBalance = realBalance;
        this.balanceDate = balanceDate;
    }

    public String getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Float getCalcBalance() {
        return calcBalance;
    }

    public void setCalcBalance(Float calcBalance) {
        this.calcBalance = calcBalance;
    }

    public Float getRealBalance() {
        return realBalance;
    }

    public void setRealBalance(Float realBalance) {
        this.realBalance = realBalance;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return Objects.equals(balanceId, balance.balanceId) &&
                Objects.equals(accountType, balance.accountType) &&
                Objects.equals(calcBalance, balance.calcBalance) &&
                Objects.equals(realBalance, balance.realBalance) &&
                Objects.equals(balanceDate, balance.balanceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceId, accountType, calcBalance, realBalance, balanceDate);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balanceId='" + balanceId + '\'' +
                ", accountType=" + accountType +
                ", calcBalance=" + calcBalance +
                ", realBalance=" + realBalance +
                ", balanceDate=" + balanceDate +
                '}';
    }
}
