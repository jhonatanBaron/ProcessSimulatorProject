package so.simulator.views.panels;

import so.simulator.controllers.Commands;
import so.simulator.views.Constants;
import so.simulator.views.components.MyJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelCreateSimulation extends JPanel {

    private JTextField sprMaxProcessTimeLife;
    private JTextField sprMaxTimeIOOperation;
    private JTextField sprMaxTimeNextProcess;
    private JTextField sprSimulationTime;
    private JButton btnStartSimulation;

    public PanelCreateSimulation(ActionListener listener) {
        setBorder(BorderFactory.createTitledBorder("Crear Simulación (segundos)"));
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(5, 1, 5, 2));
        initComponents(listener);
        fill();
    }

    private void initComponents(ActionListener listener) {
        sprSimulationTime = new JTextField();
        sprMaxProcessTimeLife = new JTextField();
        sprMaxTimeNextProcess = new JTextField();
        sprMaxTimeIOOperation = new JTextField();
        btnStartSimulation = new MyJButton(listener, Commands.BTN_START_SIMULATION,"Iniciar Simulación");
    }

    private void fill() {
        sprSimulationTime.setBorder(BorderFactory.createTitledBorder("Tiempo de simulación"));
        sprMaxTimeNextProcess.setBorder(BorderFactory.createTitledBorder("Max. Tiempo de Vida Proceso"));
        sprMaxProcessTimeLife.setBorder(BorderFactory.createTitledBorder("Max. Tiempo próximo Proceso"));
        sprMaxTimeIOOperation.setBorder(BorderFactory.createTitledBorder("Max. Tiempo ejecucion I/O"));

        add(sprSimulationTime);
        add(sprMaxTimeNextProcess);
        add(sprMaxProcessTimeLife);
        add(sprMaxTimeIOOperation);
        add(btnStartSimulation);
    }

    public int getMaxProcessTimeLife(){
        return Integer.valueOf(sprMaxProcessTimeLife.getText());
    }
    public int getMaxTimeIOOperation(){
        return Integer.valueOf(sprMaxTimeIOOperation.getText());
    }
    public int getMaxTimeNextProcess(){
        return Integer.valueOf(sprMaxTimeNextProcess.getText());
    }
    public int getSimulationTime(){
        return Integer.valueOf(sprSimulationTime.getText());
    }

}
