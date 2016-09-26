/**
 * 
 */
package by.academy.it.beans;

import javax.persistence.*;

/**
 * @author shevchenko
 *
 */
@javax.persistence.Entity
@Table(name="invoices")
public class Invoice extends Entity {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name="total_price")
    private int totalPrice;

	@Column(name="paid")
    private boolean paid;
    
    
    
	@Override
	public String toString() {
	  return "Invoice [id=" + id + ", totalPrice=" + totalPrice + ", paid=" + paid + "]";
	}
	@Override
	public int hashCode() {
	  final int prime = 31;
	  int result = super.hashCode();
	  result = prime * result + id;
	  result = prime * result + (paid ? 1231 : 1237);
	  result = prime * result + totalPrice;
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
	  Invoice other = (Invoice) obj;
	  if (id != other.id)
		return false;
	  if (paid != other.paid)
		return false;
	  if (totalPrice != other.totalPrice)
		return false;
	  return true;
	}
	public int getId() {
	  return id;
	}
	public void setId(int id) {
	  this.id = id;
	}
	public int getTotalPrice() {
	  return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
	  this.totalPrice = totalPrice;
	}
	public boolean isPaid() {
	  return paid;
	}
	public void setPaid(boolean paid) {
	  this.paid = paid;
	}
  
}
