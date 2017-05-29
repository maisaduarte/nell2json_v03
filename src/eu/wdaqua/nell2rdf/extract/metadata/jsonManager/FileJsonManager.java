package eu.wdaqua.nell2rdf.extract.metadata.jsonManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.json.simple.JSONObject;



/**
 *
 * @author Maisa
 */
public class FileJsonManager {

    private static final String TITLE = "title";
    private static final String PAGE_RANK = "pageRank";

    private final String title;
    private final double pageRank;

    public FileJsonManager(JSONObject jAnnotation) {
        title = (String) jAnnotation.get(TITLE);
        pageRank = (double) jAnnotation.get(PAGE_RANK);
    }

    public JSONObject toJSON() {
        JSONObject jAnnotation = new JSONObject();

        jAnnotation.put(TITLE, title);
        jAnnotation.put(PAGE_RANK, pageRank);

        return jAnnotation;

    }

}
