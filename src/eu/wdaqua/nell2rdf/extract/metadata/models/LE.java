/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.models;

import static eu.wdaqua.nell2rdf.extract.metadata.util.ConstantList.LE;

/**
 *
 * @author Maisa
 */
public class LE extends Header {

    public LE(String str, Double Probability) {
        super(str, LE, Probability);
    }

    @Override
    public void processStringText(String str) {

    }

    @Override
    public String getStringSource() {
        return null;
    }

    public String getMetadata_StringSource() {
        return getStringSource();
    }

}
