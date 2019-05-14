package AI_Local_Search;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

import javax.swing.*;

public class Chart extends JFrame {
    private DataTable data;

    public Chart() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1600, 1400);
        data = new DataTable(Double.class, Double.class);
        XYPlot plot = new XYPlot(data);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
    }

    public void addData(double x, double y) {
        data.add(x, y);
    }
}
