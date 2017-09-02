
package factorialyfibonacci;
//importaciones
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ventana extends JFrame implements ActionListener {
//definicion de atributos 
    private JLabel instruccion1;
    private JLabel instruccion2;
    private JTextField numero;
    private JButton botonfac;
    private JButton botonfibo;
    
/*inicializa los métodos que incluyen 
 el diseño de la ventana y sus componentes*/
    public ventana() {
        configurarVentana();
        iniciarComponentes();
    }

    //diseño de la ventana
    public void configurarVentana() {
        setTitle("Factorial y Fibonacci");//titulo
        setSize(400, 300);//tamaño
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(new Color(220, 216, 255));//color
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /*inicializa los componentes de la 
    ventana dandoles diseño y posición
    y los agrega*/
    public void iniciarComponentes() {
        instruccion1 = new JLabel("Escribe un numero:");
        instruccion1.setBounds(10, 10, 150, 30);
        instruccion1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(instruccion1);

        numero = new JTextField();
        numero.setBounds(10, 40, 150, 30);
        numero.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(numero);

        instruccion2 = new JLabel("Selecciona un boton");
        instruccion2.setBounds(10, 70, 170, 30);
        instruccion2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(instruccion2);

        botonfac = new JButton("Factorial");
        botonfac.setBounds(10, 110, 100, 30);
        botonfac.setFont(new Font("TimesRoman", Font.BOLD, 15));
        botonfac.addActionListener(this);
        botonfac.setVisible(true);
        add(botonfac);

        botonfibo = new JButton("Fibonacci");
        botonfibo.setBounds(120, 110, 130, 30);
        botonfibo.setFont(new Font("TimesRoman", Font.BOLD, 15));
        botonfibo.addActionListener(this);
        botonfibo.setVisible(true);
        add(botonfibo);

    }
/*metodo abstracto que recibe un evento 
y decide si la acción será calcular el 
factorial o si será calcular el fibonacci*/
    @Override
    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(numero.getText());
        if (e.getSource() == botonfac) {
            JOptionPane.showMessageDialog(this, "El resultado del factorial de " + numero.getText() + " es: " + calculafactorial(num));
        } else {
            if (e.getSource() == botonfibo) {
                JOptionPane.showMessageDialog(this, "El numero en la posicion " + numero.getText() + " que indicaste es: " + fibonacci(num));
            }
        }
    }

    //metodo que calcula el factorial de un numero
    //recibe de parametro el numero ingresado
    public int calculafactorial(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
    //metodo que calcula el la posicion fibonacci de un numero
    //recibe de parametro el numero ingresado
    public int fibonacci(int num) {
        int fibo = 0;
        if (num == 0 || num == 1) {
            fibo = num;
        } else {
            fibo = fibonacci(num - 2) + fibonacci(num - 1);
        }
        return fibo;
    }

}
