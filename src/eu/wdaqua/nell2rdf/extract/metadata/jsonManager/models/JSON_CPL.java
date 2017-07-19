/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import eu.wdaqua.nell2rdf.extract.metadata.models.CPL;
import eu.wdaqua.nell2rdf.extract.metadata.util.ConstantList;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Maisa
 */
public class JSON_CPL extends JSON_Header {

    private final CPL cpl;

    public JSON_CPL(Object o) {
        super(o);
        this.cpl = (CPL) o;
    }

    @Override
    public void setJsonObject() {
        super.setJsonObject();

        JSONArray jsonArray = new JSONArray();

        this.jsonObjectMain.put(ConstantList.FROM, this.cpl.getFrom());
        for (Map.Entry<String, Integer> pair : this.cpl.getMetadata().entrySet()) {
            JSONObject jsonObjectTemp = new JSONObject();
            jsonObjectTemp.put(ConstantList.TEXTUAL_PATTERN_ACRONYM, pair.getKey());
            jsonObjectTemp.put(ConstantList.OCCURRENCE, pair.getValue());
            jsonArray.add(jsonObjectTemp);
        }
        this.jsonObjectMain.put(TYPE_METADATA, jsonArray);

    }

}
