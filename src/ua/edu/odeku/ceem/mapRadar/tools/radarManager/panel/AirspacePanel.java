/*
 * Odessa State environmental University
 * Copyright (C) 2014
 */

package ua.edu.odeku.ceem.mapRadar.tools.radarManager.panel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import ua.edu.odeku.ceem.mapRadar.tools.CeemPanel;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 * Панель, для отображения воздушных пространств
 * User: Aleo Bakalov
 * Date: 10.01.14
 * Time: 11:37
 */
public class AirspacePanel implements CeemPanel {

    private JPanel panel1;
    public JButton buttonCreate;
    public JButton buttonRemove;
    public JButton buttonClearSelection;
    public JTable table;
    public JCheckBox checkBoxResizeNewShapes;

    @Override
    public JPanel getRootPanel() {
        return (JPanel) $$$getRootComponent$$$();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:noGrow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FormLayout("fill:d:grow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):grow", "center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        CellConstraints cc = new CellConstraints();
        panel1.add(panel2, cc.xy(3, 1));
        buttonCreate = new JButton();
        this.$$$loadButtonText$$$(buttonCreate, ResourceBundle.getBundle("strings").getString("button_create"));
        panel2.add(buttonCreate, cc.xy(1, 3));
        buttonRemove = new JButton();
        this.$$$loadButtonText$$$(buttonRemove, ResourceBundle.getBundle("strings").getString("button_remove"));
        panel2.add(buttonRemove, cc.xy(3, 3));
        buttonClearSelection = new JButton();
        this.$$$loadButtonText$$$(buttonClearSelection, ResourceBundle.getBundle("strings").getString("button_clear_selection"));
        panel2.add(buttonClearSelection, cc.xy(5, 3));
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setToolTipText(ResourceBundle.getBundle("strings").getString("table_radarManager_airspace_table_toolTip"));
        panel1.add(scrollPane1, cc.xy(3, 3, CellConstraints.FILL, CellConstraints.FILL));
        table = new JTable();
        scrollPane1.setViewportView(table);
    }

    /**
     * @noinspection ALL
     */
    private void $$$loadButtonText$$$(AbstractButton component, String text) {
        StringBuffer result = new StringBuffer();
        boolean haveMnemonic = false;
        char mnemonic = '\0';
        int mnemonicIndex = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '&') {
                i++;
                if (i == text.length()) break;
                if (!haveMnemonic && text.charAt(i) != '&') {
                    haveMnemonic = true;
                    mnemonic = text.charAt(i);
                    mnemonicIndex = result.length();
                }
            }
            result.append(text.charAt(i));
        }
        component.setText(result.toString());
        if (haveMnemonic) {
            component.setMnemonic(mnemonic);
            component.setDisplayedMnemonicIndex(mnemonicIndex);
        }
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
