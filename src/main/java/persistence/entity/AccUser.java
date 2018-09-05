package persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "accuser")
public class AccUser {
    @Column(name = "accuserid")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String accUserId;

    @Column(name = "usermail")
    private String userMail;

    @OneToMany(mappedBy = "accUser", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<AccountType> accountsType;

    public AccUser() {
    }

    public AccUser(String accUserId, String userMail, List<AccountType> accountsType) {
        this.accUserId = accUserId;
        this.userMail = userMail;
        this.accountsType = accountsType;
    }

    public String getAccUserId() {
        return accUserId;
    }

    public void setAccUserId(String accUserId) {
        this.accUserId = accUserId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public List<AccountType> getAccountsType() {
        return accountsType;
    }

    public void setAccountsType(List<AccountType> accountsType) {
        this.accountsType = accountsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccUser accUser = (AccUser) o;
        return Objects.equals(accUserId, accUser.accUserId) &&
                Objects.equals(userMail, accUser.userMail) &&
                Objects.equals(accountsType, accUser.accountsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accUserId, userMail, accountsType);
    }

    @Override
    public String toString() {
        return "AccUser{" +
                "accUserId='" + accUserId + '\'' +
                ", userMail='" + userMail + '\'' +
                ", accountsType=" + accountsType +
                '}';
    }
}
