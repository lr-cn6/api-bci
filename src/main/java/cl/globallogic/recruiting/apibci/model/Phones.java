package cl.globallogic.recruiting.apibci.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.0.0 - 02-12-2019
 * @since 1.0.0 - 02-12-2019
 */
@Entity(name = "Phones")
public class Phones {
    @NotEmpty
    @Id
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
