package com.example.hangman_s176356.logic;

import java.io.IOException;
import java.util.ArrayList;

public class HangmanFactory extends AbstractHangman {

    private ArrayList<String> muligeOrd;

    private ArrayList<String> brugteBogstaver;

    private String synligtOrd;

    private String ordet;

    private int antalForkerteBogstaver;

    private boolean erSidsteBogstavKorrekt;

    private boolean erSpilletVundet;

    private boolean erSpilletTabt;

    private boolean erSpilletSlut;

    public HangmanFactory() {
    }

    @Override
    public ArrayList<String> getMuligeOrd() {
        return null;
    }

    @Override
    public ArrayList<String> getBrugteBogstaver() {
        return null;
    }

    @Override
    public String getSynligtOrd() {
        return null;
    }

    @Override
    public String getOrdet() {
        return null;
    }

    @Override
    public int getAntalForkerteBogstaver() {
        return 0;
    }

    @Override
    public boolean erSidsteBogstavKorrekt() {
        return false;
    }

    @Override
    public boolean erSpilletVundet() {
        return false;
    }

    @Override
    public boolean erSpilletTabt() {
        return false;
    }

    @Override
    public boolean erSpilletSlut() {
        return false;
    }

    @Override
    public void startNytSpil() {

    }

    @Override
    public void opdaterSynligtOrd() {

    }

    @Override
    public void gætBogstav(String bogstav) {

    }

    @Override
    public void logStatus() {

    }

    @Override
    public String hentUrl(String url) throws IOException {
        return null;
    }

    @Override
    public void hentOrdFraDr() throws IOException {

    }

    @Override
    public void hentOrdFraRegneark(String sværhedsgrader) throws Exception {

    }
}
