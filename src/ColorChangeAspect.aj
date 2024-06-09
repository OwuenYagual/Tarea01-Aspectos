import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.SwingUtilities;

public aspect ColorChangeAspect {
	private ColorChanger currentColorChanger;
	private static final String LOG_FILE = "color_change_log.txt";
	
    pointcut buttonclicked(String color): execution(void ColorChanger.notifyObservers(..)) && args(color);
    after(String color): buttonclicked(color){
        ColorChanger changer = getCurrentColorChanger();
        if (changer != null) {
            SwingUtilities.invokeLater(() -> {
                switch (color) {
                    case "rosado":
                        changer.getContentPane().setBackground(Color.PINK);
                        break;
                    case "magenta":
                        changer.getContentPane().setBackground(Color.MAGENTA);
                        break;
                    case "azul":
                        changer.getContentPane().setBackground(Color.BLUE);
                        break;
                }
                System.out.println("El color de fondo ha cambiado a " + color);
                logColorChange(color);
            });
        }
    }
    
    //Capturar el objeto ColorChanger del metodo main
    pointcut colorChangerConstructor(ColorChanger changer): execution(ColorChanger.new(..)) && this(changer);
    before(ColorChanger changer): colorChangerConstructor(changer){
    		currentColorChanger = changer;
    }	
	
    private ColorChanger getCurrentColorChanger() {
        return currentColorChanger;
    }
    
    //Funcionalidad extra
    private void logColorChange(String color) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            bw.write(LocalDateTime.now() + " - El color de fondo ha cambiado a " + color);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

