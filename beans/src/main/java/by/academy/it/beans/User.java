package by.academy.it.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



/**
 * @author shevchenko
 * @version 1.0
 */
@javax.persistence.Entity
@Table(name = "users")
@Proxy(lazy = false)
public class User extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    @Size(min = 4, max=10, message = "Name must be longer then 4 letters, but shorter then 10")
    private String login;

    @Column(name = "password")
    @Size(min = 4, message = "Password must be longer then 4 symbols")
    private String password;

    @Column(name = "contact_data")
    private String userInfo;

    @Column(name = "account_type")
    private Integer accountType;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
        private List<Request> requests;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [login=" + login + ", userData=" + userInfo +"]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

}
