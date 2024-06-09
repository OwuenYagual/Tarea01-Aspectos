import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ColorChanger extends JFrame {
    private List<ColorObserver> observers = new ArrayList<>();

    public ColorChanger() {
        setTitle("Botones para cambiar el fondo: ");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JButton Boton1 = new JButton("Rosado");
        Insets ins=new Insets(100,30,20,185);
        Boton1.setMargin(ins);
        Boton1.setBackground(Color.pink);
        JButton Boton2 = new JButton("Magenta");
        Boton2.setMargin(ins);
        Boton2.setBackground(Color.MAGENTA);
        JButton Boton3 = new JButton("Azul");
        Boton3.setBackground(Color.blue);
        Insets ins1=new Insets(100,30,20,205);
        Boton3.setMargin(ins1);

        
        Boton1.addActionListener(new ColorActionListener("rosado"));
        Boton2.addActionListener(new ColorActionListener("magenta"));
        Boton3.addActionListener(new ColorActionListener("azul"));
        
        add(Boton1);
        add(Boton2);
        add(Boton3);
    }

    public void addObserver(ColorObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String color) {
        for (ColorObserver observer : observers) {
            observer.update(color);
        }
    }

    private class ColorActionListener implements ActionListener {
        private String color;

        public ColorActionListener(String color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            notifyObservers(color);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorChanger cc = new ColorChanger();
            cc.setVisible(true);
        });
    }
}

interface ColorObserver {
    void update(String color);
}


