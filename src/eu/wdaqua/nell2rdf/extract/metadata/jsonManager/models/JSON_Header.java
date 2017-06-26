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

    protected final JSONObject jsonObjectMain;

    public static String TYPE_METADATA = "metadata";

    private final Header header;

    // private final String SOURCE = "source";
    public JSON_Header(Object o) {
        header = (Header) o;
        jsonObjectMain = new JSONObject();
    }

    public JSONObject getJsonObjectMain() {
        return jsonObjectMain;
    }

    public void setJsonObject() {
        this.jsonObjectMain.put(ConstantList.COMPONENT_NAME, this.header.getComponentName());
        this.jsonObjectMain.put(ConstantList.ITERATION, this.header.getIteration());
        this.jsonObjectMain.put(ConstantList.DATETIME, this.header.getDateTime());

        JSONObject jsonObjectTemp = new JSONObject();
        if (this.header.getFormatHeader().getTypeKB().equalsIgnoreCase(ConstantList.CATEGORY)) {
            jsonObjectTemp.put(ConstantList.CATEGORY, this.header.getFormatHeader().getTokenElement1());
            jsonObjectTemp.put(ConstantList.NAMED_ENTITY_ACRONYM, this.header.getFormatHeader().getTokenElement2());
        } else {
            jsonObjectTemp.put(ConstantList.NAMED_ENTITY_ACRONYM1, this.header.getFormatHeader().getTokenElement1());
            jsonObjectTemp.put(ConstantList.NAMED_ENTITY_ACRONYM2, this.header.getFormatHeader().getTokenElement2());
        }
        this.jsonObjectMain.put(ConstantList.TOKEN, jsonObjectTemp);
    }
}
