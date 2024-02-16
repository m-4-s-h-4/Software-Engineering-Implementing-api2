package com.harbour.eats.model;


import java.util.Objects;
import javax.annotation.Generated;

/**
 * CourierId
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-16T01:49:40.262732+01:00[Europe/Madrid]")
public class CourierId {

  @lombok.Getter
  private String courierId;

  public CourierId courierId(String courierId) {
    this.courierId = courierId;
    return this;
  }

  public void setCourierId(String courierId) {
    this.courierId = courierId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourierId courierId = (CourierId) o;
    return Objects.equals(this.courierId, courierId.courierId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courierId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CourierId {\n");
    sb.append("    courierId: ").append(toIndentedString(courierId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

