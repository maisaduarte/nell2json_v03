/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import eu.wdaqua.nell2rdf.extract.metadata.models.MBL;

/**
 *
 * @author Maisa
 */
public class JSON_MBL extends JSON_Header {

    private final MBL mbl;

    public JSON_MBL(Object o) {
        super(o);
        this.mbl = (MBL) o;
    }

    @Override
    public void setJsonObject() {
        super.setJsonObject();
        this.jsonObjectMain.put(TYPE_METADATA, mbl.getPromotionOfConcept());
    }

}
