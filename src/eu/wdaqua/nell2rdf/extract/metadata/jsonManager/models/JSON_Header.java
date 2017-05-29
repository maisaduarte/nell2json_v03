/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import eu.wdaqua.nell2rdf.extract.metadata.models.Header;
import eu.wdaqua.nell2rdf.extract.metadata.util.ConstantList;
import org.json.simple.JSONObject;

/**
 *
 * @author Maisa
 */
public class JSON_Header {

    protected final JSONObject jsonObject;

    private final Header header;

    // private final String SOURCE = "source";
    public JSON_Header(Object o) {
        header = (Header) o;
        jsonObject = new JSONObject();
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject() {
        this.jsonObject.put(ConstantList.COMPONENT_NAME, this.header.getComponentName());
        this.jsonObject.put(ConstantList.ITERATION, this.header.getIteration());
        this.jsonObject.put(ConstantList.DATETIME, this.header.getDateTime());

        JSONObject jsonObjectTemp = new JSONObject();
        if (this.header.getFormatHeader().getTypeKB().equalsIgnoreCase(ConstantList.CATEGORY)) {
            jsonObjectTemp.put(ConstantList.CATEGORY, this.header.getFormatHeader().getTokenElement1());
            jsonObjectTemp.put(ConstantList.NAMED_ENTITY_ACRONYM, this.header.getFormatHeader().getTokenElement2());
        } else {
            jsonObjectTemp.put(ConstantList.NAMED_ENTITY_ACRONYM1, this.header.getFormatHeader().getTokenElement1());
            jsonObjectTemp.put(ConstantList.NAMED_ENTITY_ACRONYM2, this.header.getFormatHeader().getTokenElement2());
        }
        this.jsonObject.put(ConstantList.TOKEN, jsonObjectTemp);
    }
}
