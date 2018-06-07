#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * ${robotName} generated free by NoraUi Organization https://github.com/NoraUi
 * ${robotName} is licensed under the license BSD.
 * 
 * CAUTION: ${robotName} use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package ${package}.application.model.logogame;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.collect.ComparisonChain;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import com.github.noraui.annotation.Column;
import com.github.noraui.model.Model;

public class Logo implements Model, Comparable<Logo> {

    @Expose(serialize = false, deserialize = false)
    private Integer nid;

    @Expose
    @Column(name = "brand")
    private String brand;

    @Column(name = "score")
    private String score;

    // constructor by default for serialize/deserialize
    public Logo() {
        this.nid = -1;
        this.brand = "";
        this.score = "";
    }

    public Logo(String nid, String brand, String score) {
        this.nid = Integer.parseInt(nid);
        this.brand = brand;
        this.score = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String serialize() {
        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        builder.disableHtmlEscaping();
        final Gson gson = builder.create();
        return gson.toJson(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deserialize(String jsonString) {
        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        Logo w = gson.fromJson(jsonString, Logo.class);
        this.nid = w.nid;
        this.brand = w.brand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Logos> getModelList() {
        return Logos.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(brand).toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Logo) {
            final Logo other = (Logo) obj;
            return new EqualsBuilder()
                    .append(brand, other.brand)
                    .isEquals();
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Logo other) {
        return ComparisonChain.start()
                .compare(brand, other.brand)
        .result();
    }

    @Override
    public String toString() {
        return "{nid:" + nid + ", brand:\"" + brand + "\", score:\"" + score + "\"}";
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
