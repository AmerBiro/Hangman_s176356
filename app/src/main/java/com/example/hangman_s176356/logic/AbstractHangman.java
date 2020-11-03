package com.example.hangman_s176356.logic;

import java.io.IOException;
import java.util.ArrayList;

abstract public class AbstractHangman {

    public abstract ArrayList<String> getMuligeOrd();

    public abstract ArrayList<String> getBrugteBogstaver();

    public abstract String getSynligtOrd();

    public abstract String getOrdet();

    public abstract int getAntalForkerteBogstaver();

    public abstract boolean erSidsteBogstavKorrekt();

    public abstract boolean erSpilletVundet();

    public abstract boolean erSpilletTabt();

    public abstract boolean erSpilletSlut();

    public abstract void startNytSpil();

    public abstract void opdaterSynligtOrd();

    public abstract void gætBogstav(String bogstav);

    public abstract void logStatus();

    public abstract String hentUrl(String url) throws IOException;

    public abstract void hentOrdFraDr() throws IOException;

    public abstract void hentOrdFraRegneark(String sværhedsgrader) throws Exception;

}
