/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import eu.wdaqua.nell2rdf.extract.metadata.models.LatLong;

/**
 *
 * @author Maisa
 */
public class JSON_LatLong extends JSON_Header {

    private final LatLong latlong;

    public JSON_LatLong(Object o) {
        super(o);
        this.latlong = (LatLong) o;
    }

    @Override
    public void setJsonObject() {
        super.setJsonObject();
        this.jsonObjectMain.put(TYPE_METADATA, latlong.getRules());
    }

}
