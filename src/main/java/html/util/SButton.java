package html.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Administrator on 2017-3-8.
 */
public class SButton extends JButton{

    private Border emptyBorder = BorderFactory.createEmptyBorder(0,0, 0, 0);
    private Color roverBorderColor = Color.gray;
    private ImageIcon icon = new ImageIcon("copy.jpg");

    private Border roverBorder = new Border() {

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(roverBorderColor);
            g.drawRect(x, y, width - 1, height - 1);
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(1, 1, 1, 1);
        }

        public boolean isBorderOpaque() {
            return false;
        }
    };

    public SButton(){
        super();
        setBackground(new Color(180,180,180));

    }

    public SButton(String text){
        super(text);
        setBackground(Color.white);
        this.setPreferredSize(new Dimension(60,30));

        this.setOpaque(false);
        //this.setBorder(emptyBorder);
        this.setContentAreaFilled(true);
        this.setFocusPainted(false);
        this.setRolloverEnabled(false);

        //setIcon(icon);

        setMargin(new Insets(1, 1, 1, 1));


        Font font=new Font("Arial",Font.BOLD,18);
        setFont(font);

        // 设置前景色（文字颜色）
        setForeground(Color.red);


//        this.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                if (isRolloverEnabled()) {
//                    setBorder(roverBorder);
//                    setPreferredSize(new Dimension(60,30));
//                }
//                setPreferredSize(new Dimension(60,30));
//                setBorder(roverBorder);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                if (isRolloverEnabled()) {
//                    setBorder(emptyBorder);
//                    setPreferredSize(new Dimension(60,30));
//                }
//                setPreferredSize(new Dimension(60,30));
//                setBorder(emptyBorder);
//            }
//        });
    }





}
