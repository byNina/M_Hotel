package by.academy.it.beans;

import java.io.Serializable;

/**
 * @author shevchenko
 * @version 1.0
 *
 */
public abstract class Entity implements Serializable {
  private static final long serialVersionUID = 1L;
  protected int id;


  public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
  }


  public boolean equals(Object obj) {
	if (this == obj)
	  return true;
	if (obj == null)
	  return false;
	if (getClass() != obj.getClass())
	  return false;
	Entity other = (Entity) obj;
	if (id != other.id)
	  return false;
	return true;
  }


  public String toString() {
	return "Entity [id=" + id + "]";
  }

  public Entity(int id) {
	super();
	this.id = id;
  }

  public Entity() {
	super();
	System.out.print("444");
  }

  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

}
