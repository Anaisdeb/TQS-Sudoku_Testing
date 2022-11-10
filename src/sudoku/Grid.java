package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class Grid extends JPanel{
    private SudokuPuzzle puzzle;
    private int currentlySelectedCol;
    private int currentlySelectedRow;
    private int usedWidth;
    private int usedHeight;
    private int fontSize;

    public Grid() {
        this.setPreferredSize(new Dimension(540,450));
        this.addMouseListener(new SudokuPanelMouseAdapter());
        this.puzzle = new Generator().generateRandomSudoku();
        currentlySelectedCol = -1;
        currentlySelectedRow = -1;
        usedWidth = 0;
        usedHeight = 0;
        fontSize = 26;
    }


    public Grid(SudokuPuzzle puzzle) {
        this.setPreferredSize(new Dimension(540,450));
        this.addMouseListener(new SudokuPanelMouseAdapter());
        this.puzzle = puzzle;
        currentlySelectedCol = -1;
        currentlySelectedRow = -1;
        usedWidth = 0;
        usedHeight = 0;
        fontSize = 26;
    }

    public void newSudokuPuzzle(SudokuPuzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(1.0f,1.0f,1.0f));

        int slotWidth = this.getWidth()/GridType.getColumns();
        int slotHeight = this.getHeight()/GridType.getRows();

        usedWidth = (this.getWidth()/GridType.getColumns())*GridType.getColumns();
        usedHeight = (this.getHeight()/GridType.getRows())*GridType.getRows();

        g2d.fillRect(0, 0,usedWidth,usedHeight);

        g2d.setColor(new Color(0.0f,0.0f,0.0f));
        for(int x = 0;x <= usedWidth;x+=slotWidth) {
            if((x/slotWidth) % GridType.getBoxWidth() == 0) {
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(x, 0, x, usedHeight);
            }
            else {
                g2d.setStroke(new BasicStroke(1));
                g2d.drawLine(x, 0, x, usedHeight);
            }
        }
        //this will draw the right most line
        //g2d.drawLine(usedWidth - 1, 0, usedWidth - 1,usedHeight);
        for(int y = 0;y <= usedHeight;y+=slotHeight) {
            if((y/slotHeight) % GridType.getBoxHeight() == 0) {
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(0, y, usedWidth, y);
            }
            else {
                g2d.setStroke(new BasicStroke(1));
                g2d.drawLine(0, y, usedWidth, y);
            }
        }
        //this will draw the bottom line
        //g2d.drawLine(0, usedHeight - 1, usedWidth, usedHeight - 1);

        Font f = new Font("Times New Roman", Font.PLAIN, fontSize);
        g2d.setFont(f);
        FontRenderContext fContext = g2d.getFontRenderContext();
        for(int row=0;row < GridType.getRows();row++) {
            for(int col=0;col < GridType.getColumns();col++) {
                if(!puzzle.isSlotAvailable(row, col)) {
                    int textWidth = (int) f.getStringBounds(puzzle.getValue(row, col), fContext).getWidth();
                    int textHeight = (int) f.getStringBounds(puzzle.getValue(row, col), fContext).getHeight();
                    g2d.drawString(puzzle.getValue(row, col), (col*slotWidth)+((slotWidth/2)-(textWidth/2)), (row*slotHeight)+((slotHeight/2)+(textHeight/2)));
                }
            }
        }
        if(currentlySelectedCol != -1 && currentlySelectedRow != -1) {
            g2d.setColor(new Color(0.0f,0.0f,1.0f,0.3f));
            g2d.fillRect(currentlySelectedCol * slotWidth,currentlySelectedRow * slotHeight,slotWidth,slotHeight);
        }
    }

    public void messageFromNumActionListener(String buttonValue) {
        if(currentlySelectedCol != -1 && currentlySelectedRow != -1) {
            puzzle.makeMove(currentlySelectedRow, currentlySelectedCol, buttonValue, true);
            repaint();
        }
    }

    public class NumActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            messageFromNumActionListener(((JButton) e.getSource()).getText());
        }
    }

    private class SudokuPanelMouseAdapter extends MouseInputAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                int slotWidth = usedWidth/GridType.getColumns();
                int slotHeight = usedHeight/GridType.getRows();
                currentlySelectedRow = e.getY() / slotHeight;
                currentlySelectedCol = e.getX() / slotWidth;
                e.getComponent().repaint();
            }
        }
    }
}