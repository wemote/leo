package com.wemote.leo.quickstart.shared.kernal;

import com.wemote.leo.ddd.annotation.domain.ValueObject;
import org.fest.util.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: jayon.xu@gmail.com
 */
@SuppressWarnings({"serial", "JpaAttributeMemberSignatureInspection"})
@Embeddable
@ValueObject
public class Coordinate implements Serializable {

    private BigDecimal lat;
    private BigDecimal lng;

    protected Coordinate() {
    }

    public Coordinate(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", lat, lng);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lat == null) ? 0 : lat.hashCode());
        result = prime * result + ((lng == null) ? 0 : lng.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return Objects.areEqual(lat, other.lat) && Objects.areEqual(lng, other.lng);
    }

}
