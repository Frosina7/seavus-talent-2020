public class Address {

    private String street;
    private Integer streetNumber;
    private String city;
    private Integer zipCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public Integer getZipCode() {
        return zipCode;
    }


    @Override
    public String toString() {
        return ("Street:" + street + " " + "Street number:" + streetNumber + " " + "City:" + city + " " + "Zip code:" + zipCode);
    }

    public Address() {
    }

    ;

    public Address(String street, Integer streetNumber, String city, Integer zipCode) throws ZipCodeLengthNotAccepted {
        int count = String.valueOf(zipCode).length();
        if (count == 5 || count == 9) {
            this.street = street;
            this.streetNumber = streetNumber;
            this.city = city;
            this.zipCode = zipCode;
        } else {
            throw new ZipCodeLengthNotAccepted("Invalid zip code . It should contain 5 or 9 digits");
        }
    }

    ;

}
