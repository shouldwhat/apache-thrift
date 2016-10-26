package thrift;

public enum ColorType implements org.apache.thrift.TEnum {
  RED(0),
  BLUE(2),
  GREEN(255);

  private final int value;

  private ColorType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static ColorType findByValue(int value) { 
    switch (value) {
      case 0:
        return RED;
      case 2:
        return BLUE;
      case 255:
        return GREEN;
      default:
        return null;
    }
  }
}
