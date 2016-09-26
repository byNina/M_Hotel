/**
 * 
 */
package by.academy.it.constants;

/**
 * @author shevchenko
 *
 */
public enum AccessLevel {
  USER (0), ADMIN (1), GUEST(2);
  
  private final int accessLevel;
  AccessLevel (int accessLevel){
	this.accessLevel=accessLevel;
  }

  public int accessLevel(){return accessLevel;}
  
}
