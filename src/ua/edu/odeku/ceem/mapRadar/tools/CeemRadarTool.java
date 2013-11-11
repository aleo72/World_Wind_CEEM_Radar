package ua.edu.odeku.ceem.mapRadar.tools;

import ua.edu.odeku.ceem.mapRadar.utils.thread.Handler;

import javax.swing.*;

/**
 * User: Aleo skype: aleo72
 * Date: 10.11.13
 * Time: 14:42
 */
public interface CeemRadarTool extends NamingTool, PanelTool {

    public void setParent(JFrame frame);

    public Handler getHandlerForJFrame(final ToolFrame frame);
}
