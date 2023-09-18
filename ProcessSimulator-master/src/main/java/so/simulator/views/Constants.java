package so.simulator.views;

import java.awt.*;

public interface Constants {


    String TITTLE = "Simulador: Transiciones de procesos";
    Dimension SIZE = new Dimension(950, 600);

    String TITTLE_PANEL_SIMULATION = " Simulación ";
    String TITTLE_PANEL_CREATION_PROCESS = " Creación de proceso ";
    String TITTLE_FRAME_GRAPHICS = "Graficas de los procesos";
    String TITTLE_PANEL_GRAPHIC_TIME_LIFE = " Grafica del tiempo de vida total de los procesos ";
    String TITTLE_PANEL_GRAPHIC_TIME_READY = " Grafica del tiempo en estado listo ";
    String TITTLE_PANEL_GRAPHIC_TIME_WAITING = " Grafica del tiempo en estado bloqueado ";
    String TEXT_LABEL_TIME_ASSIGN = "Tiempo asignado: ";
    String TEXT_LABEl_CLOCK = "Tiempo simulacion: ";
    String TEXT_LABEL_QUANTUM = "Quantum";

    String TEXT_LABEL_MAX_TIME_IO = "Tiempo max Entrada/Salida:";

    String TEXT_LABEL_MAX_TIME_PROCESS_LIFE = "Tiempo max vida:";

    String TIME_TO_NEW_PROCESS = "Siguiente Proceso en:";

    String TEXT_BTN_FINISH_SIMULATION = "Finalizar";

    Font FONT_LIST = new Font("Arial", Font.PLAIN, 15);

    String TEXT_LABEL_NAME_PROCESS = "Nombre proceso:";
    String TOOL_TIP_BTN_OPEN_GRAPHICS = "Presione para abrir las graficas sobre el tiempo de los procesos";

    String VALUE_Y_GRAPHIC = "Tiempo ";
    String VALUE_X_GRAPHIC = "Procesos";

}

