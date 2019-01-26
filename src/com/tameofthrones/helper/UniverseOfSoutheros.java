package com.tameofthrones.helper;

import com.tameofthrones.model.Kingdom;
import com.tameofthrones.model.Kingdoms;
import com.tameofthrones.model.Ruler;

import java.util.Optional;

public class UniverseOfSoutheros {

    private Kingdoms kingdoms = new Kingdoms();
    private EmblemFinder emblemFinder = new EmblemFinder();

    public void updateRulerWithAlly(Ruler ruler, String kingdomName, String message) {
        Optional<Kingdom> kingdomOptional = kingdoms.getKingdomEmblem(kingdomName);
        if(!kingdomOptional.isPresent()){
            return;
        }
        String emblem = kingdomOptional.get().getEmblem();
        if(emblemFinder.find(emblem, message)){
            ruler.addAlly(kingdomName);
        }
    }
}
