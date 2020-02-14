package Util;

import java.util.Date;

public interface Person{
  public String getFullName();
  public void setFirstName(String firstname);
  public void setSurname(String surname);
  public String getSurname();
  public String getFirstname();
  
  public void setID(long id);
  public long getID();
  
  public String getGender();
  public void setGender(String gender);
  
  public String getNationality();
  public void setNationality(String nationality);
  
  public void setDataOfBirth(Date dOB);
  public Date getDateOfBirth();
  
  public String getAddress();
  public void setAddress(String address);
  
  public String getEmail();
  public void setEmail(String email);
  
  public String getPhoneNumber();
  public void setPhoneNumber(String phoneNumber);
}
