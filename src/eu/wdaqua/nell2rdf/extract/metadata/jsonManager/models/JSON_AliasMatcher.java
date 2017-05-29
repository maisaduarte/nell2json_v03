/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.jsonManager.models;

import eu.wdaqua.nell2rdf.extract.metadata.models.AliasMatcher;

/**
 *
 * @author Maisa
 */
public class JSON_AliasMatcher extends JSON_Header {

    private final AliasMatcher aliasmatcher;
    private final String FREEBASE = "freebase";

    public JSON_AliasMatcher(Object o) {
        super(o);
        this.aliasmatcher = (AliasMatcher) o;
        jsonObject.put(FREEBASE, this.aliasmatcher.getFreebaseDate());
        super.setJsonObject();
    }
}
