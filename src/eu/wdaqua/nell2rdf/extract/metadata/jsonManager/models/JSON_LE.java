/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import eu.wdaqua.nell2rdf.extract.metadata.models.LE;

/**
 *
 * @author Maisa
 */
public class JSON_LE extends JSON_Header {

    private final LE le;

    public JSON_LE(Object o) {
        super(o);
        this.le = (LE) o;
    }

    @Override
    public void setJsonObject() {
        super.setJsonObject(); 
        this.jsonObjectMain.put(TYPE_METADATA, null);
    }
    
    

}
