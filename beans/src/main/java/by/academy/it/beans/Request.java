/**
 *
 */
package by.academy.it.beans;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

/**
 * @author shevchenko
 */
@javax.persistence.Entity
@Table(name = "requests")
@Proxy(lazy = false)
public class Request extends Entity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "check_in")
    private Date checkIn;

    @Column(name = "check_out")
    private Date checkOut;

    @Column(name = "adults")
    private int adults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + adults;
        result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
        result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
        result = prime * result + id;
        result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Request other = (Request) obj;
        if (adults != other.adults)
            return false;
        if (checkIn == null) {
            if (other.checkIn != null)
                return false;
        } else if (!checkIn.equals(other.checkIn))
            return false;
        if (checkOut == null) {
            if (other.checkOut != null)
                return false;
        } else if (!checkOut.equals(other.checkOut))
            return false;
        if (id != other.id)
            return false;
        if (invoice == null) {
            if (other.invoice != null)
                return false;
        } else if (!invoice.equals(other.invoice))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Request [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", adults=" + adults + ", user="
                + user + ", invoice=" + invoice + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
