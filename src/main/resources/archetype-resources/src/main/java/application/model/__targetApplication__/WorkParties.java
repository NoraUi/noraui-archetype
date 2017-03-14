#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.model.${targetApplication};

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import noraui.model.Model;
import noraui.model.ModelList;

public class WorkParties extends ArrayList<WorkParty> implements ModelList {

    /**
     *
     */
    private static final long serialVersionUID = 9002528163560746878L;

    public WorkParties() {
        super();
    }

    public WorkParties(WorkParties inputList) {
        super(inputList);
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
        Type listType = new TypeToken<ArrayList<WorkParty>>() {
        }.getType();

        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        List<WorkParty> list = gson.fromJson(jsonString, listType);
        this.addAll(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelList addModel(Model m) {
        super.add((WorkParty) m);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void subtract(ModelList list) {
        Iterator<?> iterator = ((WorkParties) list).iterator();
        while (iterator.hasNext()) {
            this.remove(iterator.next());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getIds() {
        List<Integer> result = new ArrayList<>();
        for (WorkParty workParty : this) {
            result.add(workParty.getWid());
        }
        return result;
    }

}
