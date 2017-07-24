/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.models;

import static eu.wdaqua.nell2rdf.extract.metadata.util.ConstantList.PRA;
import eu.wdaqua.nell2rdf.extract.metadata.util.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PRA extends Header {

    private List<Rule> LRules;

    public PRA(String str, double Probability) {
        super(str, PRA, Probability);
    }

    public List<Rule> getLRules() {
        return LRules;
    }

    @Override
    public void processStringText(String str) {

        LRules = new ArrayList<>();

        this.componentName = "PRA";
        String sEntireRules = Utility.getPRA(str);

        Pattern pattern = Pattern.compile(Utility.REGEX_PRA_RULE);
        Matcher matcher = pattern.matcher(sEntireRules);

        while (matcher.find()) {
            String sTemp = matcher.group();
            String sPathDirection = sTemp.substring(0, 6);
            String sPath = sTemp.substring(6).split("\t")[0];
            double dScore = Double.valueOf(sTemp.substring(6).split("\t")[1]);

            List<String> lTemp = new ArrayList<>();
            String spTemp[] = sPath.split(",");
            for (String sRule : lTemp) {
                lTemp.add(sRule);
            }
            LRules.add(new Rule(sPathDirection, lTemp, dScore));
        }
    }

    @Override
    public String toString() {
        StringBuffer temp = new StringBuffer();
        temp.append(" {");
        for (Rule LRule : this.LRules) {
            temp.append(LRule.sPathDirection).append(" ").
                    append(LRule.lPath.toArray()).append(" ").
                    append(LRule.dScore).append("\t");
        }
        temp.append("}");

        return super.toString() + temp.toString() + "]";
    }

    @Override
    public String getStringSource() {
        StringBuffer temp = new StringBuffer();
        temp.append(" {");

        for (Rule LRule : this.LRules) {
            temp.append(LRule.sPathDirection).append(" ").
                    append(LRule.lPath.toArray()).append(" ").
                    append(LRule.dScore).append("\t");
        }

        temp.append("}");
        return temp.toString();
    }

    private class Rule {

        String sPathDirection;
        List<String> lPath;
        double dScore;

        public Rule(String sPathDirection, List<String> lPath, double dScore) {
            this.sPathDirection = sPathDirection;
            this.lPath = lPath;
            this.dScore = dScore;
        }
    }

}
