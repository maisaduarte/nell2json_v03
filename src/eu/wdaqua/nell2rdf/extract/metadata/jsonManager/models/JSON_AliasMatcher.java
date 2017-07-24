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

    public JSON_AliasMatcher(Object o) {
        super(o);
        super.setJsonObject();
        this.aliasmatcher = (AliasMatcher) o;
        jsonObjectMain.put(TYPE_METADATA, this.aliasmatcher.getMetadata_FreebaseDate());
    }
}
