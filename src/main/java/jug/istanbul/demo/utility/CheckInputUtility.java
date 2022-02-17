package jug.istanbul.demo.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class CheckInputUtility {

    static List<Pattern> blklistPttrns = new ArrayList<Pattern>();
    static List<Pattern> whtlistPttrns = new ArrayList<Pattern>();

    static {
        Pattern p = Pattern.compile("<script>");
        blklistPttrns.add(p);
        p = Pattern.compile("/../../etc/password");
        blklistPttrns.add(p);
        p = Pattern.compile("password");
        blklistPttrns.add(p);

        Pattern pWhite = Pattern.compile("[A-Za-z]");
        whtlistPttrns.add(pWhite);
    }

    public static String checkBlackList(String input) {
        for (Pattern aPattern : blklistPttrns) {
            //tam matching yapmıyoruz
            if (aPattern.matcher(input).find()) {
                Logger.getGlobal().info("Illegal Chars found");
                throw new IllegalStateException("Illegal Chars found");
            }

        }

        for (Pattern aPattern : whtlistPttrns) {

            if (aPattern.matcher(input).matches()) {
                Logger.getGlobal().info("Not fit to white list");
                throw new IllegalStateException(" Not fit to white list");
            }

        }


        return input;
    }
}

