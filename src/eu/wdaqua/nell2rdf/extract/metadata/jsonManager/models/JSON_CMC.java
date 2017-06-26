/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import eu.wdaqua.nell2rdf.extract.metadata.models.CMC;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Maisa
 */
public class JSON_CMC extends JSON_Header {

    private final CMC cmc;

    public JSON_CMC(Object o) {
        super(o);
        this.cmc = (CMC) o;
    }

    @Override
    public void setJsonObject() {
        super.setJsonObject();

        JSONObject jObjTemp1;
        JSONObject jObjTemp2;
        JSONArray jArrayTemp1 = new JSONArray();

        for (int i = 0; i < cmc.getCmcList().size(); i++) {
            jObjTemp1 = new JSONObject();
            jObjTemp2 = new JSONObject();
            jObjTemp1.put(cmc.getCMCObjetcField1(i), cmc.getCMCObjetcField2(i));
            jObjTemp2.put(jObjTemp1, cmc.getCMCObjetcScore(i));
            jArrayTemp1.add(jObjTemp2);
        }
        this.jsonObjectMain.put(TYPE_METADATA, jArrayTemp1);
    }
}
