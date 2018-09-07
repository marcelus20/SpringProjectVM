package persistence.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

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

    @Column(name = "userpass")
    private String userPass;

    @OneToMany(mappedBy = "accUser", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<AccountType> accountsType;

    public AccUser() {
        accUserId = null;
        userMail = "";
        userPass = "";
        accountsType = new HashSet<>();
    }

    public AccUser(String accUserId, String userMail, String userPass, Set<AccountType> accountsType) {
        this.accUserId = accUserId;
        this.userMail = userMail;
        this.userPass = userPass;
        this.accountsType = accountsType;
    }

    public String getAccUserId() {
        return accUserId;
    }

    public void setAccUserId(String accUserId) {
        this.accUserId = accUserId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Set<AccountType> getAccountsType() {
        return accountsType;
    }

    public void setAccountsType(Set<AccountType> accountsType) {
        this.accountsType = accountsType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccUser accUser = (AccUser) o;

        return new EqualsBuilder().append(accUserId, accUser.accUserId)
                .append(userMail, accUser.userMail)
                .append(userPass, accUser.userPass)
                .append(accountsType, accUser.accountsType).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31)
                .append(accUserId)
                .append(userMail)
                .append(userPass)
                .append(accountsType).build();
    }

    @Override
    public String toString() {
        return "AccUser{" +
                "accUserId='" + accUserId + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
