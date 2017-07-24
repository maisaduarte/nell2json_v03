/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import static eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models.JSON_Header.TYPE_METADATA;
import eu.wdaqua.nell2rdf.extract.metadata.models.OE;
import eu.wdaqua.nell2rdf.extract.metadata.util.ConstantList;
import java.net.URL;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Maisa
 */
public class JSON_OE extends JSON_Header {

    private final OE oe;

    public JSON_OE(Object o) {
        super(o);
        oe = (OE) o;
    }

    @Override
    public void setJsonObject() {
        super.setJsonObject();
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<String, URL> pair : this.oe.getMetadata_mapTextURL().entrySet()) {
            JSONObject jsonObjectTemp = new JSONObject();
            jsonObjectTemp.put(ConstantList.TEXT, pair.getKey());
            jsonObjectTemp.put(ConstantList.URL, pair.getValue());
            jsonArray.add(jsonObjectTemp);
        }
        this.jsonObjectMain.put(TYPE_METADATA, jsonArray);
    }

}
