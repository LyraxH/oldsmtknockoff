
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
    ImageIcon ameNoUzume = new ImageIcon("allies/100ameNoUzume.png");
    ImageIcon cendrillon = new ImageIcon("allies/100cendrillon.png");
    ImageIcon orpheus = new ImageIcon("allies/100orpheus.png");
    ImageIcon robinHood = new ImageIcon("allies/100robinHood.png");
    
    // enemies
    ImageIcon archangel = new ImageIcon("enemies/100archangel.png");
    ImageIcon jackFrost = new ImageIcon("enemies/100jackFrost.png");
    ImageIcon legion = new ImageIcon("enemies/100legion.png");
    ImageIcon principality = new ImageIcon("enemies/100principality.png");
}
