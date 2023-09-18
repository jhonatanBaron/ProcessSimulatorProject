package so.simulator.views;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import so.simulator.controllers.Commands;
import so.simulator.views.components.ModifiedFlowLayout;
import so.simulator.views.components.MyJButton;
import so.simulator.views.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiManager extends JFrame {

    private ActionListener listener;
    private PanelSimulationInfo panelSimulationInfo;
    private PanelCreateProcess panelCreateProcess;
    private PanelProcessExecution panelProcessExecution;
    private PanelCreateSimulation panelCreateSimulation;

    private PanelProcessBlocked panelProcessBlocked;
    private JList<String> readyQueue;
    private JLabel labelReadyQueue;
    private MyJButton btnOpenGraphs;

    public GuiManager(ActionListener listener) {
        super(Constants.TITTLE);
        //configurar tema de la aplicacion
//        FlatCyanLightIJTheme.setup();
        this.getContentPane().setBackground(Color.WHITE);
        this.listener = listener;
        this.panelSimulationInfo = new PanelSimulationInfo(listener);
        this.panelCreateProcess = new PanelCreateProcess(listener);
        this.panelProcessExecution = new PanelProcessExecution(listener);
        this.panelProcessBlocked = new PanelProcessBlocked(listener);
        this.panelCreateSimulation = new PanelCreateSimulation(listener);
        this.readyQueue = new JList<>();
        this.labelReadyQueue = new JLabel("Procesos listos: ");
        this.btnOpenGraphs = new MyJButton(listener, Commands.BTN_OPEN_GRAPHICS, "Abrir Graficas");
        this.init();
    }

    private void init() {
        setSize(Constants.SIZE);
        this.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setEnableLists(false);
        this.fill();
        addToolTips();
        setVisible(true);
    }

    public void setEnableBtnWakeProcess(boolean status){
        this.btnOpenGraphs.setEnabled(status);
    }

    public void setEnablePanelProcessExecution(boolean status){
        this.panelProcessExecution.setEnableComponents(status);
    }

    public void clearList() {
        DefaultListModel<String> listModelEmpty = new DefaultListModel<>();
        this.readyQueue.setModel(listModelEmpty);
    }

    public void setTimeRestProcess(int time) {
        this.panelProcessExecution.setTimeRest(time);
    }

    public void updateReadyQueue(ArrayList<String> namesProcess) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String process : namesProcess) {
            listModel.addElement(process);
        }
        readyQueue.setModel(listModel);
    }

    public void setProcessActual(String nameProcess, int timeAssign, int timeRest) {
        this.panelProcessExecution.setProcessActual(nameProcess, timeAssign, timeRest);
    }

    private void fill() {
        this.setLayout(null);
        this.panelCreateSimulation.setBounds(15,20, 250,320);
        this.panelSimulationInfo.setBounds(15, 340, 250, 200);
        this.panelCreateProcess.setBounds(300, 20, 300, 120);
        readyQueue.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
        labelReadyQueue.setBounds(650, 20, 250, 20);
        readyQueue.setLayout(new ModifiedFlowLayout());
        JScrollPane jScrollPaneQueueProcess = new JScrollPane(readyQueue);
        jScrollPaneQueueProcess.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPaneQueueProcess.setBounds(650, 40, 250, 400);

        this.readyQueue.setFont(Constants.FONT_LIST);
        this.panelProcessExecution.setBounds(300, 140, 300, 200);
        this.panelProcessBlocked.setBounds(300, 340, 300,200);
        this.btnOpenGraphs.setBounds(710, 500, 140, 30);

        add(panelCreateSimulation);
        add(panelSimulationInfo);
        add(panelCreateProcess);
        add(panelProcessExecution);
        add(panelProcessBlocked);
        add(labelReadyQueue);
        add(jScrollPaneQueueProcess);
        add(btnOpenGraphs);
    }

    public void resetComponentsPanelCurrentProcess(){
        this.panelProcessExecution.resetComponents();
    }

    private void addToolTips(){
        this.btnOpenGraphs.setToolTipText(Constants.TOOL_TIP_BTN_OPEN_GRAPHICS);
    }

    public void setEnableLists(boolean status) {
        this.readyQueue.setEnabled(status);
    }

    public void clearLists() {
        DefaultListModel<String> listModelEmpty = new DefaultListModel<>();
        this.readyQueue.setModel(listModelEmpty);
        this.setEnableLists(false);
    }

    public void resetSpinnerUCP() {
        this.panelSimulationInfo.resetComponentsUCP();
    }


    public void resetNameProcess() {
        this.panelCreateProcess.resetNameProcess();
    }

    public PanelCreateSimulation getPanelCreateSimulation() {
        return panelCreateSimulation;
    }

    public PanelSimulationInfo getPanelSimulationInfo() {
        return panelSimulationInfo;
    }

    public PanelCreateProcess getPanelCreateProcess() {
        return panelCreateProcess;
    }

    public PanelProcessExecution getPanelProcessExecution() {
        return panelProcessExecution;
    }

    public PanelProcessBlocked getPanelProcessBlocked() {
        return panelProcessBlocked;
    }
}
