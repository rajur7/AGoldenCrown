package com.tameofthrones.helper;

import com.tameofthrones.model.Ruler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UniverseOfSoutherosTest {

    @InjectMocks
    private UniverseOfSoutheros universeOfSoutheros;

    @Mock
    private EmblemFinder emblemFinder;

    @Test
    public void shouldAddKingdomToRulerAlliesIfGivenMessageContainsEmblemForGivenKingdomName() {
        Ruler ruler = new Ruler("King Shan");
        String kingdomName = "Air";
        String message = "Let's swing the sword together";
        when(emblemFinder.find("owl", message)).thenReturn(true);
        assertEquals(0, ruler.getAllies().size());

        universeOfSoutheros.updateRulerWithAlly(ruler, kingdomName, message);

        assertEquals(1, ruler.getAllies().size());
        assertTrue(ruler.getAllies().contains(kingdomName));
    }

    @Test
    public void shouldNotAddKingdomToRulerAlliesIfGivenMessageDoesNotContainsEmblem() {
        Ruler ruler = new Ruler("King Shan");
        String kingdomName = "Air";
        String message = "Drag on Martin!";
        when(emblemFinder.find("owl", message)).thenReturn(false);

        universeOfSoutheros.updateRulerWithAlly(ruler, kingdomName, message);

        assertEquals(0, ruler.getAllies().size());
    }


    @Test
    public void shouldNotAddKingdomToRulerAlliesIfGivenKingdomIsNotPresentInKingdoms() {
        Ruler ruler = new Ruler("King Shan");
        String kingdomName = "Sun";
        String message = "Summer is coming";

        universeOfSoutheros.updateRulerWithAlly(ruler, kingdomName, message);

        assertEquals(0, ruler.getAllies().size());
    }
}
