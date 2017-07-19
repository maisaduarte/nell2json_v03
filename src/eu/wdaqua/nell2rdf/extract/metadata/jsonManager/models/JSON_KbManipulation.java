/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import eu.wdaqua.nell2rdf.extract.metadata.models.KbManipulation;

/**
 *
 * @author Maisa
 */
public class JSON_KbManipulation extends JSON_Header {

    private final KbManipulation kbmanipulation;

    public JSON_KbManipulation(Object o) {
        super(o);
        this.kbmanipulation = (KbManipulation) o;
    }

    @Override
    public void setJsonObject() {
        super.setJsonObject();
        jsonObjectMain.put(TYPE_METADATA, kbmanipulation.getMetadata());
    }

}
