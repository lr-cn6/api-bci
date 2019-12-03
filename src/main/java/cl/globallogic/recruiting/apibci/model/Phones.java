package cl.globallogic.recruiting.apibci.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

/**
 * @author Luis Riveros - luis.riveros_ex@scotiabank.cl
 * @version 1.0.0 - 02-12-2019
 * @since 1.0.0 - 02-12-2019
 */
public class Phones {
    @NotEmpty
    private String number;

    @NotEmpty
    @JsonProperty("citycode")
    private String cityCode;

    @NotEmpty
    @JsonProperty("countrycode")
    private String countryCode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
