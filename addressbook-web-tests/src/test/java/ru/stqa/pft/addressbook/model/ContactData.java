package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String mobilePhoneNumber;
  private final String email;
  private String group;

  public ContactData(String FirstName, String LastName, String Address, String mobilePhoneNumber, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = FirstName;
    this.lastName = LastName;
    this.address = Address;
    this.mobilePhoneNumber = mobilePhoneNumber;
    this.email = email;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public ContactData(int id, String FirstName, String LastName, String Address, String mobilePhoneNumber, String email, String group) {
    this.id = id;
    this.firstName = FirstName;
    this.lastName = LastName;
    this.address = Address;
    this.mobilePhoneNumber = mobilePhoneNumber;
    this.email = email;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhoneNumber() {
    return mobilePhoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName, address);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

}

