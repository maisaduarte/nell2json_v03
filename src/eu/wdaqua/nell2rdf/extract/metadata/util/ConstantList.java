/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.util;

/**
 *
 * @author Maisa
 */
public abstract class ConstantList {

    public final static String RELATION = "relation";
    public final static String CATEGORY = "category";
    public final static String LOOK_GENERALIZATIONS = "generalizations";

    public final static String ONTOLOGYMODIFIER = "OntologyModifier";
    public final static String CPL = "CPL";
    public final static String SEAL = "SEAL";
    public final static String OE = "OE";
    public final static String CMC = "CMC";
    public final static String ALIASMATCHER = "AliasMatcher";
    public final static String MBL = "MBL";
    public final static String PRA = "PRA";
    public final static String RULEINFERENCE = "RuleInference";
    public final static String KBMANIPULATION = "KbManipulation";
    public final static String SEMPARSE = "Semparse";
    public final static String LE = "LE";
    public final static String SPREADSHEETEDITS = "SpreadsheetEdits";
    public final static String LATLONG = "LatLong";
    public final static String LATLONGTT = "LatLongTT";

    public final static String TEXT_ONTOLOGYMODIFIER = "OntologyModifier-Iter:";
    public final static String TEXT_CPL = "CPL-Iter:";
    public final static String TEXT_SEAL = "SEAL-Iter:";
    public final static String TEXT_OE = "OE-Iter:";
    public final static String TEXT_CMC = "CMC-Iter:";
    public final static String TEXT_ALIASMATCHER = "AliasMatcher-Iter:";
    public final static String TEXT_MBL = "MBL-Iter:";
    public final static String TEXT_PRA = "PRA-Iter:";
    public final static String TEXT_RULEINFERENCE = "RuleInference-Iter:";
    public final static String TEXT_KBMANIPULATION = "KbManipulation-Iter:";
    public final static String TEXT_SEMPARSE = "Semparse-Iter:";
    public final static String TEXT_LE = "LE-Iter:";
    public final static String TEXT_SPREADSHEETEDITS = "SpreadsheetEdits-Iter:";
    public final static String TEXT_LATLONG = "LatLong-Iter:";
    public final static String TEXT_LATLONGTT = "LatLongTT-Iter:";

    //JSON Constants
    public final static String NAMED_ENTITY_ACRONYM = "NE";
    public final static String NAMED_ENTITY_ACRONYM1 = "NE1";
    public final static String NAMED_ENTITY_ACRONYM2 = "NE2";
    public final static String TEXTUAL_PATTERN_ACRONYM = "TP";
    public final static String ITERATION = "iteration";
    public final static String DATETIME = "datetime";
    public final static String TOKEN = "token";

    public final static String FROM = "from";
    public final static String OCCURRENCE = "occurrence";
    public final static String EXTRACTION = "extraction";
    public final static String COMPONENT_NAME = "componentName";

    //For the first Columns - less the last one
    public final static String ENTITY_CSV = "Entity";
    public final static String RELATION_CSV = "Relation";
    public final static String VALUE_CSV = "Value";
    public final static String ITERATION_CSV = "Iteration of Promotion";
    public final static String PROBABILITY_CSV = "Probability";
    public final static String SOURCE_CSV = "Source";
    public final static String ENTITY_LS_CSV = "Entity literalStrings";
    public final static String VALUE_LS_CSV = "Value literalStrings";
    public final static String BEST_ENTITY_CSV = "Best Entity literalString";
    public final static String BEST_VALUE_CVS = "Best Value literalString";
    public final static String CATEGORIES_ENTITY_CSV = "Categories for Entity";
    public final static String CATEGORIES_VALUE_CSV = "Categories for Value";
    public final static String CANDIDATE_SOURCE_CSV = "Candidate Source";
    
    //For KBMANIPULATION
    public final static String KBMANIPULATION_BUG = "bug";
    
    //For OE
    public final static String TEXT = "text";
    public final static String URL = "URL";

}
