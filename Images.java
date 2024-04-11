
/**
 * holds / imports all the images for the game
 *
 * @ ts
 * @ 08/04/24 -> 
 */
import javax.swing.*;
import java.awt.*;
public class Images
{
    // hud moves
    ImageIcon unAttackIcon = new ImageIcon("buttons/unselectedAttack.png");
    ImageIcon unGuardIcon = new ImageIcon("buttons/unselectedGuard.png");
    ImageIcon unMagicIcon = new ImageIcon("buttons/unselectedMagic.png");
    ImageIcon unItemIcon = new ImageIcon("buttons/unselectedItem.png");
    
    ImageIcon attackIcon = new ImageIcon("buttons/selectedAttack.png");
    ImageIcon guardIcon = new ImageIcon("buttons/selectedGuard.png");
    ImageIcon magicIcon = new ImageIcon("buttons/selectedMagic.png");
    ImageIcon itemIcon = new ImageIcon("buttons/selectedItem.png");
    
    // allies
    ImageIcon ameNoUzumeIMG = new ImageIcon("allies/100ameNoUzume.png");
    ImageIcon cendrillonIMG = new ImageIcon("allies/100cendrillon.png");
    ImageIcon orpheusIMG = new ImageIcon("allies/100orpheus.png");
    ImageIcon robinHoodIMG = new ImageIcon("allies/100robinHood.png");
    //turning allies into jlabels
    JLabel ameNoUzume = new JLabel(ameNoUzumeIMG);
    JLabel cendrillon = new JLabel(cendrillonIMG);
    JLabel orpheus = new JLabel(orpheusIMG);
    JLabel robinHood = new JLabel(robinHoodIMG);
    
    // enemies
    ImageIcon archangelIMG = new ImageIcon("enemies/100archangel.png");
    ImageIcon jackFrostIMG = new ImageIcon("enemies/100jackFrost.png");
    ImageIcon legionIMG = new ImageIcon("enemies/100legion.png");
    ImageIcon principalityIMG = new ImageIcon("enemies/100principality.png");
    // turning enemies into jlabels
    JLabel archangel = new JLabel(archangelIMG);
    JLabel jackFrost = new JLabel(jackFrostIMG);
    JLabel legion = new JLabel(legionIMG);
    JLabel principality = new JLabel(principalityIMG);
    
    // elements and affinities
    ImageIcon fireIMG = new ImageIcon("elements/fire2.png");
    ImageIcon waterIMG = new ImageIcon("elements/water2.png");
    ImageIcon earthIMG = new ImageIcon("elements/earth2.png");
    ImageIcon airIMG = new ImageIcon("elements/air2.png");
    ImageIcon sunIMG = new ImageIcon("elements/sun2.png");
    ImageIcon moonIMG = new ImageIcon("elements/moon2.png");
    ImageIcon physIMG = new ImageIcon("elements/phys2.png");
    ImageIcon weakIMG = new ImageIcon("elements/weak2.png");
    ImageIcon resistIMG = new ImageIcon("elements/resist2.png");
    ImageIcon nullifyIMG = new ImageIcon("elements/nullify2.png");
    ImageIcon normalIMG = new ImageIcon("elements/normal2.png");
    //turning elements and affinites into jlabels
    JLabel fire = new JLabel(fireIMG);
    JLabel water = new JLabel(waterIMG);
    JLabel earth = new JLabel(earthIMG);
    JLabel air = new JLabel(airIMG);
    JLabel sun = new JLabel(sunIMG);
    JLabel moon = new JLabel(moonIMG);
    JLabel phys = new JLabel(physIMG);
    JLabel weak = new JLabel(weakIMG);
    JLabel resist = new JLabel(resistIMG);
    JLabel nullify = new JLabel(nullifyIMG);
    JLabel normal = new JLabel(normalIMG);
}
