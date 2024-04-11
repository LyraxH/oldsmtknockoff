
/**
 * Holds the window settings and stuff
 *
 * @ ts
 * @ 08/04/24 ->
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Window extends JFrame implements ActionListener, KeyListener, MouseListener
{
    Scanner input = new Scanner(System.in);
    Images img = new Images(); // imports images from other class
    Game game = new Game(); // imports data from game region
    // game variables
    int page = 0; // what page you are on, e.g: 0 = home, 1 = attack, 2 = magic, 3 = items (guard doesnt have a page)
    int selected = 0; // what option is currently being hovered, 0-3 left to right
    // panel for different regions of the game
    JPanel gameWindow = new JPanel(); // where the characters are displayed
    JPanel enemyWindow = new JPanel(); // where enemy health is displayed
    JPanel allyWindow = new JPanel(); // where ally health is displayed
    JPanel moveWindow = new JPanel(); // where actions can be taken
    JPanel chatWindow = new JPanel(); // where text of the actions taken is displayed
    
    // chat window variables
    ArrayList<String> textHistory = new ArrayList<String>(); // so we cna keep a history of what has been added
    JLabel textUpdateOne = new JLabel("FILLER TEXT NUMBER ONE NO ONE WILL EVER SEE THIS XDD");
    JLabel textUpdateTwo = new JLabel("https://youtube.com/@lyraxh");
    JLabel textUpdateThree = new JLabel("ASDASDASD");
    
    // enemy window variables
    JButton enemyOneButton = new JButton("EnemyOne");
    JButton enemyTwoButton = new JButton("EnemyTwo");
    JButton enemyThreeButton = new JButton("EnemyThree");
    JButton enemyFourButton = new JButton("EnemyFour");
    JLabel enemyOneHPText = new JLabel("HP: 300 / 300");
    JLabel enemyTwoHPText = new JLabel("HP: 300 / 300");
    JLabel enemyThreeHPText = new JLabel("HP: 300 / 300");
    JLabel enemyFourHPText = new JLabel("HP: 300 / 300");
    
    // ally window variables
    JButton allyOneButton = new JButton("AllyOne");
    JButton allyTwoButton = new JButton("AllyTwo");
    JButton allyThreeButton = new JButton("AllyThree");
    JButton allyFourButton =  new JButton("AllyFour");
    JLabel allyOneHPText = new JLabel("HP: 200 / 200");
    JLabel allyTwoHPText = new JLabel("HP: 200 / 200");
    JLabel allyThreeHPText = new JLabel("HP: 200 / 200");
    JLabel allyFourHPText = new JLabel("HP: 200 / 200");
    JLabel allyOneSPText = new JLabel("SP: 150 / 150");
    JLabel allyTwoSPText = new JLabel("SP: 150 / 150");
    JLabel allyThreeSPText = new JLabel("SP: 150 / 150");
    JLabel allyFourSPText = new JLabel("SP: 150 / 150");
    
    //move window variables
    JLabel currentMoveText = new JLabel("Ally One");
    JButton moveButtonOne = new JButton(img.attackIcon);
    JButton moveButtonTwo = new JButton(img.unGuardIcon);
    JButton moveButtonThree = new JButton(img.unMagicIcon);
    JButton moveButtonFour = new JButton(img.unItemIcon);
    
    // game window variables
    JLabel allyOneSprite = new JLabel("ally one sprite");
    JLabel allyTwoSprite = new JLabel("ally two sprite");
    JLabel allyThreeSprite = new JLabel("ally three sprite");
    JLabel allyFourSprite = new JLabel("ally four sprite");
    JLabel enemyOneSprite = new JLabel("enemy one sprite");
    JLabel enemyTwoSprite = new JLabel("enemy two sprite");
    JLabel enemyThreeSprite = new JLabel("enemy three sprite");
    JLabel enemyFourSprite = new JLabel("enemy four sprite");
    
    // j menu variables
    JMenuBar menuBar = new JMenuBar();
    JMenu system = new JMenu("System");
    JMenu music = new JMenu("Music");
    JMenu battleLog = new JMenu("Battle Log");
    JMenuItem quitGame = new JMenuItem("Quit Game");
    JMenuItem nextSong = new JMenuItem("Next Track");
    JMenuItem previousSong = new JMenuItem("Previous Track");
    JMenuItem pauseMusic = new JMenuItem("Pause Music");
    JMenuItem displayBattleLog = new JMenuItem("Display Battle Log");

    public Window(){
        game.Start();
        setImages();
        setMenu();
        // adding panel regions to the jframe
        this.add(gameWindow, BorderLayout.CENTER);
        this.add(enemyWindow, BorderLayout.LINE_START);
        this.add(allyWindow, BorderLayout.LINE_END);
        this.add(chatWindow, BorderLayout.PAGE_START);
        this.add(moveWindow, BorderLayout.PAGE_END);
        
        // adding variables to the chat window region
        chatWindow.setLayout(new BoxLayout(chatWindow, BoxLayout.PAGE_AXIS));
        textUpdateOne.setAlignmentX(CENTER_ALIGNMENT);
        textUpdateTwo.setAlignmentX(CENTER_ALIGNMENT);
        textUpdateThree.setAlignmentX(CENTER_ALIGNMENT);
        chatWindow.add(textUpdateOne);
        chatWindow.add(textUpdateTwo);
        chatWindow.add(textUpdateThree);
        textHistory.add("Welcome to my shitty SMT knockoff for school");
        textHistory.add("made by taison");
        textHistory.add("xdd");
        updateText();
        
        
        // adding variables to the move window region
        moveWindow.setLayout(new GridLayout(1,0));
        moveWindow.add(currentMoveText);
        moveWindow.add(moveButtonOne);
        moveWindow.add(moveButtonTwo);
        moveWindow.add(moveButtonThree);
        moveWindow.add(moveButtonFour);
        
        // adding variables to the ally window region
        allyWindow.setLayout(new GridLayout(4,3, 0, 25));
        allyWindow.add(allyOneButton);
        allyWindow.add(allyOneHPText);
        allyWindow.add(allyOneSPText);
        
        allyWindow.add(allyTwoButton);
        allyWindow.add(allyTwoHPText);
        allyWindow.add(allyTwoSPText);
        
        allyWindow.add(allyThreeButton);
        allyWindow.add(allyThreeHPText);
        allyWindow.add(allyThreeSPText);
        
        allyWindow.add(allyFourButton);
        allyWindow.add(allyFourHPText);
        allyWindow.add(allyFourSPText);
        
        
        // adding variables to the enemy window region
        enemyWindow.setLayout(new GridLayout(4,2, 50, 25));
        enemyWindow.add(enemyOneButton);
        enemyWindow.add(enemyOneHPText);
        enemyWindow.add(enemyTwoButton);
        enemyWindow.add(enemyTwoHPText);
        enemyWindow.add(enemyThreeButton);
        enemyWindow.add(enemyThreeHPText);
        enemyWindow.add(enemyFourButton);
        enemyWindow.add(enemyFourHPText);

        gameWindow.setBackground(Color.blue);
        allyWindow.setBackground(Color.green);
        allyWindow.setPreferredSize(new Dimension(300, 0));
        enemyWindow.setBackground(Color.red);
        enemyWindow.setPreferredSize(new Dimension(250, 0));
        chatWindow.setBackground(Color.gray);
        chatWindow.setPreferredSize(new Dimension(0, 50));
        moveWindow.setBackground(Color.pink);
        moveWindow.setPreferredSize(new Dimension(0, 200));
        
        // adding variables to game window
        gameWindow.setLayout(new GridLayout(2, 4, 50, 100));
        gameWindow.add(enemyOneSprite);
        enemyOneSprite.setIcon(img.archangelIMG);
        gameWindow.add(enemyTwoSprite);
        enemyTwoSprite.setIcon(img.jackFrostIMG);
        gameWindow.add(enemyThreeSprite);
        enemyThreeSprite.setIcon(img.legionIMG);
        gameWindow.add(enemyFourSprite);
        enemyFourSprite.setIcon(img.principalityIMG);
        gameWindow.add(allyOneSprite);
        allyOneSprite.setIcon(img.ameNoUzumeIMG);
        gameWindow.add(allyTwoSprite);
        allyTwoSprite.setIcon(img.cendrillonIMG);
        gameWindow.add(allyThreeSprite);
        allyThreeSprite.setIcon(img.orpheusIMG);
        gameWindow.add(allyFourSprite);
        allyFourSprite.setIcon(img.robinHoodIMG);
        
        initialize();
    }
    
    public void updateScreen(){
        switch (page){
            case 0: // if on home page
                switch (selected){
                    case 1: // if attack selected
                        moveButtonOne.setIcon(img.attackIcon);
                        moveButtonTwo.setIcon(img.unAttackIcon);
                        moveButtonThree.setIcon(img.unMagicIcon);
                        moveButtonFour.setIcon(img.unItemIcon);
                        break;
                    case 2: // if guard selected
                        moveButtonOne.setIcon(img.unAttackIcon);
                        moveButtonTwo.setIcon(img.guardIcon);
                        moveButtonThree.setIcon(img.unMagicIcon);
                        moveButtonFour.setIcon(img.unItemIcon);
                        break;
                    case 3: // if magic selected
                        moveButtonOne.setIcon(img.attackIcon);
                        moveButtonTwo.setIcon(img.unGuardIcon);
                        moveButtonThree.setIcon(img.magicIcon);
                        moveButtonFour.setIcon(img.unItemIcon);
                        break;
                    case 4: // if item selected
                        moveButtonOne.setIcon(img.unAttackIcon);
                        moveButtonTwo.setIcon(img.unGuardIcon);
                        moveButtonThree.setIcon(img.unMagicIcon);
                        moveButtonFour.setIcon(img.itemIcon);
                        break;
                }
                break;
        }
    }
    public void updateText(){
        int size = textHistory.size();
        textUpdateOne.setText(textHistory.get(size - 3));
        textUpdateTwo.setText(textHistory.get(size - 2));
        textUpdateThree.setText(textHistory.get(size - 1));
    }
    
    void jRequestFocus(){
        this.requestFocus();
    }
    void initialize(){
        this.setTitle("SMT knock off in java swing for school");
        this.getContentPane().setPreferredSize(new Dimension (1280, 720));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setFocusable(true);
        jRequestFocus();
        this.toFront();
        
        this.addKeyListener(this);
        allyOneButton.addActionListener(this);
        allyTwoButton.addActionListener(this);
        allyThreeButton.addActionListener(this);
        allyFourButton.addActionListener(this);
        enemyOneButton.addActionListener(this);
        enemyTwoButton.addActionListener(this);
        enemyThreeButton.addActionListener(this);
        enemyFourButton.addActionListener(this);
        moveButtonOne.addActionListener(this);
        moveButtonOne.addMouseListener(this);
        moveButtonTwo.addActionListener(this);
        moveButtonTwo.addMouseListener(this);
        moveButtonThree.addActionListener(this);
        moveButtonThree.addMouseListener(this);
        moveButtonFour.addActionListener(this);
        moveButtonFour.addMouseListener(this);
        quitGame.addActionListener(this);
        nextSong.addActionListener(this);
        previousSong.addActionListener(this);
        pauseMusic.addActionListener(this);
        displayBattleLog.addActionListener(this);
        updateActionCommands();
        
        gameWindow.setVisible(true);
        this.pack();
        this.setVisible(true);
    }
    
    void updateActionCommands(){
        allyOneButton.setActionCommand("ameNoUzume");
        allyTwoButton.setActionCommand("cendrillon");
        allyThreeButton.setActionCommand("orpheus");
        allyFourButton.setActionCommand("robinHood");
        enemyOneButton.setActionCommand("archangel");
        enemyTwoButton.setActionCommand("jackFrost");
        enemyThreeButton.setActionCommand("legion");
        enemyFourButton.setActionCommand("principality");
        
        switch (page){
            case 0: // if main page
                moveButtonOne.setActionCommand("attack");
                moveButtonTwo.setActionCommand("guard");
                moveButtonThree.setActionCommand("magic");
                moveButtonFour.setActionCommand("item");
                break;
            case 1: // if attack
                moveButtonOne.setActionCommand("moveOne");
                moveButtonTwo.setActionCommand("moveTwo");
                moveButtonThree.setActionCommand("moveThree");
                moveButtonFour.setActionCommand("moveFour");
                break;
        }
    }
    
    void updateFrame(){
        switch (page){ // what menu
            case 0: // if main menu
                switch (selected){
                    case 0: // if attack selected
                        moveButtonOne.setIcon(img.attackIcon);
                        moveButtonTwo.setIcon(img.unGuardIcon);
                        moveButtonThree.setIcon(img.unMagicIcon);
                        moveButtonFour.setIcon(img.unItemIcon);
                        break;
                    case 1: // if guard selected
                        moveButtonOne.setIcon(img.unAttackIcon);
                        moveButtonTwo.setIcon(img.guardIcon);
                        moveButtonThree.setIcon(img.unMagicIcon);
                        moveButtonFour.setIcon(img.unItemIcon);
                        break;
                    case 2: // if magic selected
                        moveButtonOne.setIcon(img.unAttackIcon);
                        moveButtonTwo.setIcon(img.unGuardIcon);
                        moveButtonThree.setIcon(img.magicIcon);
                        moveButtonFour.setIcon(img.unItemIcon);
                        break;
                    case 3: // if item selected
                        moveButtonOne.setIcon(img.unAttackIcon);
                        moveButtonTwo.setIcon(img.unGuardIcon);
                        moveButtonThree.setIcon(img.unMagicIcon);
                        moveButtonFour.setIcon(img.itemIcon);
                        break;
                }
                break;
        }
    }
    
    
    public void actionPerformed(ActionEvent e){
        updateActionCommands();
        String cmd = e.getActionCommand();
        switch (cmd){
            // stat view clicks // 0 = fire, 1 = water, 2 = air, 3 = earth, 4 = sun, 5 = moon, 6 = phys
            case "ameNoUzume": // 0 = normal, 1 = weak, 2 = null, 3 = resist
                createStatsMenu("Ame-No-Uzume", 0, 1, 0, 3, 0, 0, 2, 0);
                break;            
            case "cendrillon":
                createStatsMenu("Cendrillon", 1, 1, 0, 3, 0, 0, 2, 0);
                break;
            case "orpheus":
                createStatsMenu("Orpheus", 2, 1, 0, 3, 0, 0, 2, 0);
                break;
            case "robinHood":
                createStatsMenu("Robin Hood", 3, 1, 0, 3, 0, 0, 2, 0);
                break;
            case "archangel":
                createStatsMenu("Archangel", 4, 1, 0, 3, 0, 0, 2, 0);
                break;
            case "jackFrost":
                createStatsMenu("Jack Frost", 5, 1, 0, 3, 0, 0, 2, 0);
                break;
            case "legion":
                createStatsMenu("Legion", 6, 1, 0, 3, 0, 0, 2, 0);
                break;
            case "principality":
                createStatsMenu("Principality", 7, 1, 0, 3, 0, 0, 2, 0);
                break;
                
            // move button clicks
            case "attack":
                System.out.println("attack");
                break;
            case "guard":
                System.out.println("guard");
                break;
            case "magic":
                System.out.println("magic");
                break;
            case "item":
                System.out.println("item");
                break;
                
            // menu bar clicks
            case "Quit Game":
                System.exit(0);
                break;
            case "Next Track":
                break;
            case "Previous Track":
                break;
            case "Pause Music":
                break;
            case "Display Battle Log":
                createBattleLog();
                break;
        }
        jRequestFocus();
    }
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        switch (page){ // what menu are we in
            case 0: // if main page
                switch (keyCode){
                case 37: // left arrow in main page
                    if (selected == 0){
                        selected = 0;
                    } else {
                        selected--;
                    }
                    updateFrame();
                    break;
                case 39: // right arrow in main page
                    if (selected == 3){
                        selected = 3;
                    } else {
                        selected++;
                    }
                    updateFrame();
                    break;
                case 90: // if z key pressed
                    switch (selected){
                        case 0:
                            moveButtonOne.doClick();
                            break;
                        case 1:
                            moveButtonTwo.doClick();
                            break;
                        case 2:
                            moveButtonThree.doClick();
                            break;
                        case 3:
                            moveButtonFour.doClick();
                            break;
                    }
                    break;
                }
                break;
            case 2:
                break;
        }
    }
    void createStatsMenu(String name, int character, int one, int two, int three, int four, int five, int six, int seven){
        JDialog box = new JDialog(this);
        box.setTitle(name + " stats");
        box.setBounds(200,400, 800, 200);
        box.setLayout(new GridLayout(2, 8, 20, 20));
        
        JLabel nameLabel = new JLabel(name);
        switch (character){
            case 0:
                box.add(img.ameNoUzume);
                break;
            case 1:
                box.add(img.cendrillon);
                break;
            case 2:
                box.add(img.orpheus);
                break;
            case 3:
                box.add(img.robinHood);
                break;
            case 4:
                box.add(img.archangel);
                break;
            case 5:
                box.add(img.jackFrost);
                break;
            case 6:
                box.add(img.legion);
                break;
            case 7:
                box.add(img.principality);
                break;
        }
        box.add(img.fire); // 1
        box.add(img.water); // 2
        box.add(img.earth); // 3
        box.add(img.air); // 4
        box.add(img.sun); // 5
        box.add(img.moon); // 6
        box.add(img.phys); // 7
        
        box.add(nameLabel); // adding name to the bottom row
        switch (one){
            case 0: // normal
                JLabel normal = new JLabel(img.normalIMG);
                box.add(normal);
                break;
            case 1: // weak
                box.add(img.weak);
                break;
            case 2: // null
                box.add(img.nullify);
                break;
            case 3: // resist
                box.add(img.resist);
                break;
        }
        switch (two){
            case 0: // normal
                JLabel normalTwo = new JLabel(img.normalIMG);
                box.add(normalTwo);
                break;
            case 1: // weak
                box.add(img.weak);
                break;
            case 2: // null
                box.add(img.nullify);
                break;
            case 3: // resist
                box.add(img.resist);
                break;
        }
        switch (three){
            case 0: // normal
                JLabel normalThree = new JLabel(img.normalIMG);
                box.add(normalThree);
                break;
            case 1: // weak
                box.add(img.weak);
                break;
            case 2: // null
                box.add(img.nullify);
                break;
            case 3: // resist
                box.add(img.resist);
                break;
        }
        switch (four){
            case 0: // normal
                JLabel normalFour = new JLabel(img.normalIMG);
                box.add(normalFour);
                break;
            case 1: // weak
                box.add(img.weak);
                break;
            case 2: // null
                box.add(img.nullify);
                break;
            case 3: // resist
                box.add(img.resist);
                break;
        }
        switch (five){
            case 0: // normal
                JLabel normalFive = new JLabel(img.normalIMG);
                box.add(normalFive);
                break;
            case 1: // weak
                box.add(img.weak);
                break;
            case 2: // null
                box.add(img.nullify);
                break;
            case 3: // resist
                box.add(img.resist);
                break;
        }
        switch (six){
            case 0: // normal
                JLabel normalSix = new JLabel(img.normalIMG);
                box.add(normalSix);
                break;
            case 1: // weak
                box.add(img.weak);
                break;
            case 2: // null
                box.add(img.nullify);
                break;
            case 3: // resist
                box.add(img.resist);
                break;
        }
        switch (seven){
            case 0: // normal
                JLabel normalSeven = new JLabel(img.normalIMG);
                box.add(normalSeven);
                break;
            case 1: // weak
                box.add(img.weak);
                break;
            case 2: // null
                box.add(img.nullify);
                break;
            case 3: // resist
                box.add(img.resist);
                break;
        }
        
        box.toFront();
        box.setVisible(true);
    }
    public void createBattleLog(){
        JDialog box = new JDialog(this);
        box.setTitle("Battle Log");
        String a;
        String b;
        a = "0: " + textHistory.get(0) + " \n";
        for (int i = 1; i < textHistory.size(); i++){
            b = textHistory.get(i);
            b = i + ": " + b + " \n";
            a = a + b;
        }
        TextArea area = new TextArea(a);
        box.add(area);
        box.setBounds(400,200, 400,400);
        box.toFront();
        box.setVisible(true);
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    public void mouseEntered(MouseEvent e){
        int hover = e.getXOnScreen();
        if (hover > 263 && hover < 518){ //button one
            selected = 0;
        } else if (hover > 519 && hover < 774) {// button two
            selected = 1;
        } else if (hover > 775 && hover < 1030){ // button 3
            selected = 2;
        } else if (hover > 1031 && hover < 1285){ // button 4
            selected = 3;
        }
        updateFrame();
    }
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    void setMenu(){
        this.setJMenuBar(menuBar);
        menuBar.add(system);
        menuBar.add(music);
        menuBar.add(battleLog);
        
        system.add(quitGame);
        
        music.add(nextSong);
        music.add(previousSong);
        music.add(pauseMusic);
        
        battleLog.add(displayBattleLog);
    }
    
    void setImages(){
        switch (game.allyOne){
            case 1:
                allyOneButton.setIcon(img.ameNoUzumeIMG);
                break;
            case 2:
                allyOneButton.setIcon(img.cendrillonIMG);
                break;
            case 3:
                allyOneButton.setIcon(img.orpheusIMG);
                break;
            case 4:
                allyOneButton.setIcon(img.robinHoodIMG);
                break;
        }
        switch (game.allyTwo){
            case 1:
                allyTwoButton.setIcon(img.ameNoUzumeIMG);
                break;
            case 2:
                allyTwoButton.setIcon(img.cendrillonIMG);
                break;
            case 3:
                allyTwoButton.setIcon(img.orpheusIMG);
                break;
            case 4:
                allyTwoButton.setIcon(img.robinHoodIMG);
                break;
        }
        switch (game.allyThree){
            case 1:
                allyThreeButton.setIcon(img.ameNoUzumeIMG);
                break;
            case 2:
                allyThreeButton.setIcon(img.cendrillonIMG);
                break;
            case 3:
                allyThreeButton.setIcon(img.orpheusIMG);
                break;
            case 4:
                allyThreeButton.setIcon(img.robinHoodIMG);
                break;
        }
        switch (game.allyFour){
            case 1:
                allyFourButton.setIcon(img.ameNoUzumeIMG);
                break;
            case 2:
                allyFourButton.setIcon(img.cendrillonIMG);
                break;
            case 3:
                allyFourButton.setIcon(img.orpheusIMG);
                break;
            case 4:
                allyFourButton.setIcon(img.robinHoodIMG);
                break;
        }
        
        switch (game.enemyOne){
            case 1:
                enemyOneButton.setIcon(img.archangelIMG);
                break;
            case 2:
                enemyOneButton.setIcon(img.jackFrostIMG);
                break;
            case 3:
                enemyOneButton.setIcon(img.legionIMG);
                break;
            case 4:
                enemyOneButton.setIcon(img.principalityIMG);
                break;
        }
        switch (game.enemyTwo){
            case 1:
                enemyTwoButton.setIcon(img.archangelIMG);
                break;
            case 2:
                enemyTwoButton.setIcon(img.jackFrostIMG);
                break;
            case 3:
                enemyTwoButton.setIcon(img.legionIMG);
                break;
            case 4:
                enemyTwoButton.setIcon(img.principalityIMG);
                break;
        }
        switch (game.enemyThree){
            case 1:
                enemyThreeButton.setIcon(img.archangelIMG);
                break;
            case 2:
                enemyThreeButton.setIcon(img.jackFrostIMG);
                break;
            case 3:
                enemyThreeButton.setIcon(img.legionIMG);
                break;
            case 4:
                enemyThreeButton.setIcon(img.principalityIMG);
                break;
        }
        switch (game.enemyFour){
            case 1:
                enemyFourButton.setIcon(img.archangelIMG);
                break;
            case 2:
                enemyFourButton.setIcon(img.jackFrostIMG);
                break;
            case 3:
                enemyFourButton.setIcon(img.legionIMG);
                break;
            case 4:
                enemyFourButton.setIcon(img.principalityIMG);
                break;
        }
    }
}