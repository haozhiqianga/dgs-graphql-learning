package com.wuwei.dgs.types;

public class Director {
  private String id;

  private String name;

  public Director() {
  }

  public Director(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Director{" + "id='" + id + "'," +"name='" + name + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director that = (Director) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    public Director build() {
                  Director result = new Director();
                      result.id = this.id;
          result.name = this.name;
                      return result;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }
}
