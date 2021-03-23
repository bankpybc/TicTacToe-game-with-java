import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;

public class GameBoard extends JFrame implements MouseListener {
    double mouseX = 0;
    double mouseY = 0;
    JLabel [] box = new JLabel[9];
    boolean[] playerMark = new boolean[9];
    boolean[] botMark = new boolean[9];
    int botPoint = 0;
    int playerPoint = 0;
    int countMark = 0;
    boolean botTurn = false;
    GameBoard(){

        JPanel lineColLeft = new JPanel();
        lineColLeft.setBackground(Color.black);
        lineColLeft.setBounds(198,0,2,600);

        JPanel lineColRight = new JPanel();
        lineColRight.setBackground(Color.black);
        lineColRight.setBounds(398,0,2,600);

        JPanel lineMenu = new JPanel();
        lineMenu.setBackground(Color.black);
        lineMenu.setBounds(500,0,2,600);

        JPanel lineRowUpper = new JPanel();
        lineRowUpper.setBackground(Color.black);
        lineRowUpper.setBounds(0,198,600,2);

        JPanel lineRowLower = new JPanel();
        lineRowLower.setBackground(Color.black);
        lineRowLower.setBounds(0,398,600,2);

        ImageIcon image =  new ImageIcon("icon2.jpg");
        // right menu


        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(598,0,200,600);
        menuPanel.setBackground(Color.getHSBColor(37,68,97));
        menuPanel.setOpaque(true);

        JButton resetBoardButton = new JButton();
        resetBoardButton.setBounds(650,400,100,50);
        this.add(resetBoardButton);

        resetBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoardGame();
                JOptionPane.showMessageDialog(null,"Reset Game !!","Tic Tac Toe",JOptionPane.PLAIN_MESSAGE);
            }
        });

        box[0] = new JLabel();
        box[0].setBounds(0,0,198,198);
        box[0].setBackground(Color.lightGray);
        box[0].setOpaque(true);
        box[0].addMouseListener(this);

        box[1] = new JLabel();
        box[1].setBounds(200,0,198,198);
        box[1].setBackground(Color.lightGray);
        box[1].setOpaque(true);
        box[1].addMouseListener(this);

        box[2] = new JLabel();
        box[2].setBounds(400,0,198,198);
        box[2].setBackground(Color.lightGray);
        box[2].setOpaque(true);
        box[2].addMouseListener(this);

        box[3] = new JLabel();
        box[3].setBounds(0,200,198,198);
        box[3].setBackground(Color.lightGray);
        box[3].setOpaque(true);
        box[3].addMouseListener(this);

        box[4] = new JLabel();
        box[4].setBounds(200,200,198,198);
        box[4].setBackground(Color.lightGray);
        box[4].setOpaque(true);
        box[4].addMouseListener(this);

        box[5] = new JLabel();
        box[5].setBounds(400,200,198,198);
        box[5].setBackground(Color.lightGray);
        box[5].setOpaque(true);
        box[5].addMouseListener(this);

        box[6] = new JLabel();
        box[6].setBounds(0,400,198,198);
        box[6].setBackground(Color.lightGray);
        box[6].setOpaque(true);
        box[6].addMouseListener(this);

        box[7] = new JLabel();
        box[7].setBounds(200,400,198,198);
        box[7].setBackground(Color.lightGray);
        box[7].setOpaque(true);
        box[7].addMouseListener(this);

        box[8] = new JLabel();
        box[8].setBounds(400,400,200,200);
        box[8].setBackground(Color.lightGray);
        box[8].setOpaque(true);
        box[8].addMouseListener(this);



        this.setTitle("TicTacToe by Piyabute");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(800,638);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(255 ,204,204));

        this.add(lineRowUpper);
        this.add(lineRowLower);
        this.add(lineColLeft);
        this.add(lineColRight);
        this.add(menuPanel);
        this.add(box[0]);
        this.add(box[1]);
        this.add(box[2]);
        this.add(box[3]);
        this.add(box[4]);
        this.add(box[5]);
        this.add(box[6]);
        this.add(box[7]);
        this.add(box[8]);

        //run game



}

    @Override
    public void mouseClicked(MouseEvent e) {
       // System.out.println(getMousePosition());
        // catch last mark for player
        // player turn
        mouseX = getMousePosition().getX();
        mouseY = getMousePosition().getY();

        box[checkBoxArea(mouseX,mouseY)].setFont(new Font("Verdana",Font.PLAIN, 200));
        box[checkBoxArea(mouseX,mouseY)].setHorizontalTextPosition(JLabel.CENTER);
        box[checkBoxArea(mouseX,mouseY)].setVerticalTextPosition(JLabel.CENTER);
        box[checkBoxArea(mouseX,mouseY)].setBorder(BorderFactory.createEmptyBorder(10, 40, 50, 10));
        box[checkBoxArea(mouseX,mouseY)].setText("x");
        playerMark[checkBoxArea(mouseX,mouseY)] = true; // player mark
        box[checkBoxArea(mouseX,mouseY)].removeMouseListener(this);
        countMark++;
        botTurn = true;
        System.out.println("player normal turn");

       if(countMark>=9){
            JOptionPane.showMessageDialog(null,"Draw !!","End game",JOptionPane.PLAIN_MESSAGE);
            resetBoardGame();
        }

        // bot turn

        System.out.println("bot normal turn");
        Random randomSeed = new Random();
        int seed = randomSeed.nextInt(99);
        Random random = new Random(seed);
        int botSelect =  random.nextInt(9);
        while(playerMark[botSelect] == true|| botMark[botSelect] == true){ // ramdom to empty box
            botSelect =  random.nextInt(9);
            System.out.println("random "+botSelect);
        }
        System.out.println("final "+botSelect);
        box[botSelect].setFont(new Font("Verdana",Font.PLAIN, 200));
        box[botSelect].setHorizontalTextPosition(JLabel.CENTER);
        box[botSelect].setVerticalTextPosition(JLabel.CENTER);
        box[botSelect].setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
        box[botSelect].setText("O");
        box[botSelect].removeMouseListener(this);
        botMark[botSelect] = true;
        countMark++;
        System.out.println("countMark: "+countMark);


        if(checkPlayerWinCondition()){
            System.out.println("Player win");
            playerPoint++;
            JOptionPane.showMessageDialog(null," Congratulations you are a winner !!","End game",JOptionPane.PLAIN_MESSAGE);
            countMark = 0;
             resetBoardGame();
        }
        else if(checkBotWinCondition()){
            System.out.println("Bot win");
            botPoint++;
            JOptionPane.showMessageDialog(null," \n" +"Next time you might win, bot is a winner ;)","End game",JOptionPane.PLAIN_MESSAGE);
             countMark = 0;
             resetBoardGame();
        }
        else if(checkBotWinCondition()&&checkPlayerWinCondition() ){
            System.out.println("draw");
             JOptionPane.showMessageDialog(null,"Draw !!","End game",JOptionPane.PLAIN_MESSAGE);
             countMark = 0;
             resetBoardGame();

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public int checkBoxArea(double mouseX,double mouseY){
        if(mouseX <= 200 && mouseY <= 200){ //box0
            return 0;
        }
        else if(mouseX > 200 && mouseX <= 400 && mouseY <= 200 ){//box1
            return 1;
        }
        else if(mouseX > 400 && mouseX <= 600 && mouseY <= 200 ){//box2
            return 2;
        }
        else if(mouseX <= 200 && mouseY > 200 && mouseY <= 400 ){//box3
            return 3;
        }
        else if(mouseX > 200 && mouseX <= 400 && mouseY > 200 && mouseY <= 400 ){//box4
            return 4;
        }
        else if(mouseX > 400 && mouseX <= 600 && mouseY > 200 && mouseY <= 400 ){//box5
            return 5;
        }
        else if(mouseX <= 200 && mouseY > 400 ){//box6
            return 6;
        }
        else if(mouseX > 200 && mouseX <= 400 && mouseY > 400 ){//box7
            return 7;
        }
        else if(mouseX > 400 && mouseX <= 600 && mouseY > 400 ){//box8
            return 8;
        }
        return 0 ;
    }

    public boolean checkPlayerWinCondition(){
        if(playerMark[0] == true && playerMark[1] == true && playerMark[2] == true){
            return true;
        }
        else if(playerMark[3] == true && playerMark[4] == true && playerMark[5] == true){
            return true;
        }
        else if(playerMark[6] == true && playerMark[7] == true && playerMark[8] == true){
            return true;
        }
        else if(playerMark[0] == true && playerMark[3] == true && playerMark[6] == true){
            return true;
        }
        else if(playerMark[1] == true && playerMark[4] == true && playerMark[7] == true){
            return true;
        }
        else if(playerMark[2] == true && playerMark[5] == true && playerMark[8] == true){
            return true;
        }
        else if(playerMark[0] == true && playerMark[4] == true && playerMark[8] == true){
            return true;
        }
        else if(playerMark[2] == true && playerMark[4] == true && playerMark[6] == true){
            return true;
        }
        return false;
    }

    public boolean checkBotWinCondition(){
        if(botMark[0] == true && botMark[1] == true && botMark[2] == true){
            return true;
        }
        else if(botMark[3] == true && botMark[4] == true && botMark[5] == true){
            return true;
        }
        else if(botMark[6] == true && botMark[7] == true && botMark[8] == true){
            return true;
        }
        else if(botMark[0] == true && botMark[3] == true && botMark[6] == true){
            return true;
        }
        else if(botMark[1] == true && botMark[4] == true && botMark[7] == true){
            return true;
        }
        else if(botMark[2] == true && botMark[5] == true && botMark[8] == true){
            return true;
        }
        else if(botMark[0] == true && botMark[4] == true && botMark[8] == true){
            return true;
        }
        else if(botMark[2] == true && botMark[4] == true && botMark[6] == true){
            return true;
        }
        return false;
    }

    public void resetPoint(){
        playerPoint = 0;
        botPoint = 0;
    }

    public void resetBoardGame(){
        for (JLabel item : box){ // reset Mark
            item.setText(" ");
            item.addMouseListener(this);
        }
        Arrays.fill(botMark,false);
        Arrays.fill(playerMark,false);
        countMark = 0;
    }
}
