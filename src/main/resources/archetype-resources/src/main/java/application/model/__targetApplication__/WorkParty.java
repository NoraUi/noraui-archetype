#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.model.${targetApplication};

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import noraui.annotation.Column;
import noraui.model.Model;

public class WorkParty implements Model, Comparable<WorkParty> {

    @Expose(serialize = false, deserialize = false)
    private Integer wid;

    @Expose
    @Column(name = "Partie prenante")
    private String name;

    @Expose
    @Column(name = "Rôle")
    private String role;

    @Expose
    @Column(name = "Ordre")
    private int order;

    // constructor by default for serialize/deserialize
    public WorkParty() {
    }

    public WorkParty(String wid, String name, String role, String order) {
        this.wid = Integer.parseInt(wid);
        this.name = name;
        this.role = role;
        this.order = (int) Double.parseDouble(order);
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
        WorkParty w = gson.fromJson(jsonString, WorkParty.class);
        this.wid = w.wid;
        this.name = w.name;
        this.order = w.order;
        this.role = w.role;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<WorkParties> getModelList() {
        return WorkParties.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
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
        WorkParty other = (WorkParty) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(WorkParty other) {
        return ((Integer) this.order).compareTo(other.order);
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}